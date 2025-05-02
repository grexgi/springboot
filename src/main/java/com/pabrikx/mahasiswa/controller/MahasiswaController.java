package com.pabrikx.mahasiswa.controller;

import com.pabrikx.mahasiswa.dto.MahasiswaDTO;
import com.pabrikx.mahasiswa.model.Mahasiswa;
import com.pabrikx.mahasiswa.service.MahasiswaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @PostMapping
    public ResponseEntity<Mahasiswa> create(@RequestBody Mahasiswa mahasiswa){
        return ResponseEntity.ok(mahasiswaService.create(mahasiswa));
    }

    @GetMapping
    public ResponseEntity<List<MahasiswaDTO>> findAll(){
        return ResponseEntity.ok(mahasiswaService.findAll());
    }

    @GetMapping("/{nim}")
    public ResponseEntity<MahasiswaDTO> findByNim(@PathVariable String nim){
        return ResponseEntity.ok(mahasiswaService.findByNim(nim));
    }

    @DeleteMapping("/{nim}")
    public ResponseEntity<String> deleteByNim(@PathVariable String nim){
        try {
            mahasiswaService.deleteByNim(nim);
            return ResponseEntity.ok("Success delete mahasiswa w/ " + nim);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{nim}")
    public ResponseEntity<Mahasiswa> updateByNim(@PathVariable String nim, @RequestBody Mahasiswa mahasiswa){
        return ResponseEntity.ok(mahasiswaService.updateByNim(nim, mahasiswa));
    }
}
