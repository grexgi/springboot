package com.pabrikx.jurusan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JurusanResponseDTO {
    Long id;
    String jurusanNama;
}