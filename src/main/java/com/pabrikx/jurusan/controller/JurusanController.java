package com.pabrikx.jurusan.controller;

import com.pabrikx.jurusan.dto.JurusanRequestDTO;
import com.pabrikx.jurusan.dto.JurusanResponseDTO;
import com.pabrikx.jurusan.model.Jurusan;
import com.pabrikx.jurusan.service.JurusanService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jurusan")
public class JurusanController {

    @Autowired
    private JurusanService jurusanService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody JurusanRequestDTO request) {
        try {
            jurusanService.createJurusan(request);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<JurusanResponseDTO>> findAll() {
        try{
            return ResponseEntity.ok(jurusanService.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/id={id}")
    public ResponseEntity<JurusanResponseDTO> findById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(jurusanService.findById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/name={nama}")
    public ResponseEntity<JurusanResponseDTO> findByNama(@PathVariable String nama) {
        try{
            return ResponseEntity.ok(jurusanService.findByNama(nama));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/query={query}")
    public ResponseEntity<List<JurusanResponseDTO>> findByNamaContain(@PathVariable String query) {
        try{
            return ResponseEntity.ok(jurusanService.findByNamaContain(query));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    This code is not handling referenced row on other table.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try{
            jurusanService.deleteById(id);
            return ResponseEntity.ok("Success delete Jurusan " + id);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody JurusanRequestDTO request){
        try{
            jurusanService.update(id, request);
            return ResponseEntity.ok("Update berhasil");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
