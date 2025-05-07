package com.pabrikx.mahasiswa.dto;

import lombok.Data;

@Data
public class MahasiswaRequestDTO {
    private String nama;
    private String nim;
    private Long jurusanId;
}
