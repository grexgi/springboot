package com.pabrikx.mahasiswa.model;

import com.pabrikx.jurusan.model.Jurusan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nama;
    private String nim;

    @ManyToOne
    @JoinColumn(name = "jurusan_id")
    private Jurusan jurusan;
}
