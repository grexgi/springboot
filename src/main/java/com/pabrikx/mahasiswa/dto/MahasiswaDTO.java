package com.pabrikx.mahasiswa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MahasiswaDTO {
    Long id;
    String nim;
    String nama;
    String jurusan_nama;
}
