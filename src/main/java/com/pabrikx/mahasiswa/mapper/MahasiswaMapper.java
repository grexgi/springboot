package com.pabrikx.mahasiswa.mapper;

import com.pabrikx.mahasiswa.dto.MahasiswaDTO;
import com.pabrikx.mahasiswa.model.Mahasiswa;

public class MahasiswaMapper {
    public static MahasiswaDTO toDTO(Mahasiswa mahasiswa){
        return MahasiswaDTO.builder()
                .id(mahasiswa.getId())
                .nim(mahasiswa.getNim())
                .nama(mahasiswa.getNama())
                .jurusan_nama(mahasiswa.getJurusan().getNama())
                .build();
    }
}
