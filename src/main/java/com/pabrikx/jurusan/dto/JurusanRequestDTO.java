package com.pabrikx.jurusan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JurusanRequestDTO {

    @NotBlank(message = "Jurusan name cannot be blank")
    String jurusanNama;
}
