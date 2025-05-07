package com.pabrikx.jurusan.service;

import com.pabrikx.jurusan.dto.JurusanRequestDTO;
import com.pabrikx.jurusan.dto.JurusanResponseDTO;
import com.pabrikx.jurusan.mapper.JurusanMapper;
import com.pabrikx.jurusan.model.Jurusan;
import com.pabrikx.jurusan.repository.JurusanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurusanService {

    @Autowired
    private JurusanRepository jurusanRepository;

    public List<JurusanResponseDTO> findAll(){
        return jurusanRepository.findAll().stream()
                .map(JurusanMapper::toDTO)
                .toList();
    }

    public JurusanResponseDTO findById(Long id) {
        return JurusanMapper.toDTO(jurusanRepository.findById(id).orElseThrow());
    }

    public JurusanResponseDTO findByNama(String nama) {
        return JurusanMapper.toDTO(jurusanRepository.findByNama(nama).orElseThrow());
    }

    public List<JurusanResponseDTO> findByNamaContain(String query){
        return  jurusanRepository.findByNamaContaining(query).stream()
                .map(JurusanMapper::toDTO)
                .toList();
    }

    public void createJurusan(JurusanRequestDTO requestDTO){
        Jurusan jurusan = Jurusan.builder()
                .nama(requestDTO.getJurusanNama())
                .build();

        jurusanRepository.save(jurusan);
    }

    public void deleteById (Long id){
        if(!jurusanRepository.existsById(id)){
            throw new EntityNotFoundException("Jurusan dengan ID " + id + " tidak ditemukan.");
        }
        jurusanRepository.deleteById(id);
    }

    public void update(Long id, JurusanRequestDTO requestDTO){
        Jurusan newJurusan =  jurusanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jurusan dengan ID " + id + " tidak ditemukan."));

        newJurusan.setNama(requestDTO.getJurusanNama());
        jurusanRepository.save(newJurusan);
    }
}

