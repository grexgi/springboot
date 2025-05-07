package com.pabrikx.jurusan.repository;

import com.pabrikx.jurusan.model.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JurusanRepository extends JpaRepository<Jurusan, Long> {
    Optional<Jurusan> findByNama(String nama);
    List<Jurusan> findByNamaContaining(String nama);
}

