package com.pabrikx.mahasiswa.mapper;

import com.pabrikx.mahasiswa.dto.MahasiswaResponseDTO;
import com.pabrikx.mahasiswa.model.Mahasiswa;

public class MahasiswaMapper {
    public static MahasiswaResponseDTO toDTO(Mahasiswa mahasiswa){
        return MahasiswaResponseDTO.builder()
                .id(mahasiswa.getId())
                .nim(mahasiswa.getNim())
                .nama(mahasiswa.getNama())
                .jurusan(mahasiswa.getJurusan() != null ? mahasiswa.getJurusan().getNama() : null)
                .build();
    }
}
