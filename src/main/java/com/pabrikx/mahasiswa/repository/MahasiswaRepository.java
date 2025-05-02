package com.pabrikx.mahasiswa.repository;

import com.pabrikx.mahasiswa.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    Optional<Mahasiswa> findByNim(String nim);
    Optional<Mahasiswa> deleteByNim(String nim);
    Boolean existsByNim(String nim);
}
