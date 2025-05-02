package com.pabrikx.jurusan.mapper;

import com.pabrikx.jurusan.dto.JurusanDTO;
import com.pabrikx.jurusan.model.Jurusan;

public class JurusanMapper {

    public static JurusanDTO toDTO(Jurusan jurusan) {
        return JurusanDTO.builder()
                .id(jurusan.getId())
                .jurusanNama(jurusan.getNama())
                .build();
    }
}