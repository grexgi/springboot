package com.pabrikx.jurusan.mapper;

import com.pabrikx.jurusan.dto.JurusanResponseDTO;
import com.pabrikx.jurusan.model.Jurusan;

public class JurusanMapper {

    public static JurusanResponseDTO toDTO(Jurusan jurusan) {
        return JurusanResponseDTO.builder()
                .id(jurusan.getId())
                .jurusanNama(jurusan.getNama())
                .build();
    }
}