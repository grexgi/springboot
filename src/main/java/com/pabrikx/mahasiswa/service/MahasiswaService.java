package com.pabrikx.mahasiswa.service;

import com.pabrikx.jurusan.model.Jurusan;
import com.pabrikx.jurusan.repository.JurusanRepository;
import com.pabrikx.mahasiswa.dto.MahasiswaRequestDTO;
import com.pabrikx.mahasiswa.dto.MahasiswaResponseDTO;
import com.pabrikx.mahasiswa.mapper.MahasiswaMapper;
import com.pabrikx.mahasiswa.model.Mahasiswa;
import com.pabrikx.mahasiswa.repository.MahasiswaRepository;
import com.pabrikx.mahasiswa.repository.MahasiswaRepositoryJDBC;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    MahasiswaRepositoryJDBC mahasiswaRepositoryJDBC;

    @Autowired
    JurusanRepository jurusanRepository;

    public void create(MahasiswaRequestDTO request){
        Jurusan jurusan = jurusanRepository.findById(request.getJurusanId())
                .orElseThrow(() -> new RuntimeException("Jurusan tidak ditemukan"));

        Mahasiswa mahasiswa = Mahasiswa.builder()
                .nama(request.getNama())
                .nim(request.getNim())
                .jurusan(jurusan)
                .build();

        mahasiswaRepository.save(mahasiswa);
    }

    public List<MahasiswaResponseDTO> findAll(){
        return mahasiswaRepository.findAll().stream()
                .map(MahasiswaMapper::toDTO)
                .toList();
    }

    public MahasiswaResponseDTO findById(Long id){
        return MahasiswaMapper.toDTO(mahasiswaRepository.findById(id).orElseThrow());
    }

    public List<MahasiswaResponseDTO> getMahasiswaByQuery(String query){
        return mahasiswaRepositoryJDBC.findByNameQuery(query).stream()
                .map(MahasiswaMapper::toDTO)
                .toList();
    }

    public void deleteById(Long id){
        if(!mahasiswaRepository.existsById(id)){
            throw new EntityNotFoundException("Mahasiswa dengan id "+id+" tidak ditemukan");
        }
        mahasiswaRepository.deleteById(id);
    }

    public void updateById(Long id, MahasiswaRequestDTO request){
        Mahasiswa newMahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mahasiswa dengan id " + id + " tidak ditemukan."));

        Jurusan jurusan = jurusanRepository.findById(request.getJurusanId())
                        .orElseThrow(() -> new EntityNotFoundException("Jurusan dengan ID "+ request.getJurusanId()+"tidak ditemukan."));

        newMahasiswa.setNama(request.getNama());
        newMahasiswa.setNim(request.getNim());
        newMahasiswa.setJurusan(jurusan);

        mahasiswaRepository.save(newMahasiswa);
    }
}
