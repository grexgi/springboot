package com.pabrikx.mahasiswa.service;

import com.pabrikx.mahasiswa.dto.MahasiswaDTO;
import com.pabrikx.mahasiswa.mapper.MahasiswaMapper;
import com.pabrikx.mahasiswa.model.Mahasiswa;
import com.pabrikx.mahasiswa.repository.MahasiswaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    public Mahasiswa create(Mahasiswa mahasiswa){
        return mahasiswaRepository.save(mahasiswa);
    }

    public List<MahasiswaDTO> findAll(){
        return mahasiswaRepository.findAll().stream()
                .map(MahasiswaMapper::toDTO)
                .toList();
    }

    public MahasiswaDTO findByNim(String nim){
        return mahasiswaRepository.findByNim(nim).stream()
                .map(MahasiswaMapper::toDTO)
                .toList().getFirst();
    }

    public void deleteByNim(String nim){
        Optional<Mahasiswa> mahasiswa = mahasiswaRepository.findByNim(nim);
        mahasiswa.ifPresent(mahasiswaRepository::delete);
    }

    public Mahasiswa updateByNim(String nim, Mahasiswa mahasiswa){
        Mahasiswa newMahasiswa = mahasiswaRepository.findByNim(nim)
                .orElseThrow(() -> new EntityNotFoundException("Mahasiswa dengan NIM " + nim + " tidak ditemukan."));

        newMahasiswa.setNama(mahasiswa.getNama());
        newMahasiswa.setJurusan(mahasiswa.getJurusan());

        return mahasiswaRepository.save(newMahasiswa);
    }
}
