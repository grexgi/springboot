package com.pabrikx.mahasiswa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MahasiswaRequestDTO {

    @NotBlank(message = "Nama cannot be blank")
    private String nama;

    @NotBlank(message = "NIM cannot be blank")
    @Size(min = 6, message = "NIM must be at least 6 characters")
    private String nim;

    @NotBlank(message = "Jurusan ID cannot be blank")
    private Long jurusanId;
}
