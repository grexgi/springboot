package com.pabrikx.jurusan.service;

import com.pabrikx.jurusan.dto.JurusanDTO;
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

    public List<JurusanDTO> findAll(){
        return jurusanRepository.findAll().stream()
                .map(JurusanMapper::toDTO)
                .toList();
    }

    public Jurusan findById(Long id) {
        return jurusanRepository.findById(id).orElseThrow();
    }

    public Jurusan findByNama(String nama) {
        return jurusanRepository.findByNama(nama).orElseThrow();
    }

    public List<Jurusan> findByNamaContain(String query){
        return jurusanRepository.findByNamaContaining(query).orElseThrow();
    }

    public Jurusan createJurusan(Jurusan jurusan){
        return jurusanRepository.save(jurusan);
    }

    public void deleteById (Long id){
        if(!jurusanRepository.existsById(id)){
            throw new EntityNotFoundException("Jurusan dengan ID " + id + " tidak ditemukan.");
        }
        jurusanRepository.deleteById(id);
    }

    public Jurusan update(Long id, Jurusan jurusan){
        Jurusan newJurusan =  jurusanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jurusan dengan ID " + id + " tidak ditemukan."));

        newJurusan.setNama(jurusan.getNama());
        return jurusanRepository.save(newJurusan);
    }
}

