package com.pabrikx.mahasiswa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MahasiswaResponseDTO {
    Long id;
    String nama;
    String nim;
    String jurusan;
}
