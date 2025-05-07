package com.pabrikx.mahasiswa.controller;

import com.pabrikx.mahasiswa.dto.MahasiswaRequestDTO;
import com.pabrikx.mahasiswa.dto.MahasiswaResponseDTO;
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
    public ResponseEntity<String> create(@RequestBody MahasiswaRequestDTO request){
        mahasiswaService.create(request);
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public ResponseEntity<List<MahasiswaResponseDTO>> findAll(){
        try{
            return ResponseEntity.ok(mahasiswaService.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/id={id}")
    public ResponseEntity<MahasiswaResponseDTO> findByNim(@PathVariable Long id){
        try {
            return ResponseEntity.ok(mahasiswaService.findById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/query={query}")
    public ResponseEntity<List<MahasiswaResponseDTO>> getMahasiswaByQuery(@PathVariable String query){
        var lowerCaseQuery = query.toLowerCase();
        try {
            return ResponseEntity.ok(mahasiswaService.getMahasiswaByQuery(lowerCaseQuery));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{nim}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            mahasiswaService.deleteById(id);
            return ResponseEntity.ok("Success delete mahasiswa w/ " + id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody MahasiswaRequestDTO request){
        try {
            mahasiswaService.updateById(id, request);
            return ResponseEntity.ok("Succees");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
