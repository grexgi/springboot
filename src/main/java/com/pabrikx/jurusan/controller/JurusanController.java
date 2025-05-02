package com.pabrikx.jurusan.controller;

import com.pabrikx.jurusan.dto.JurusanDTO;
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
    public ResponseEntity<Jurusan> create(@RequestBody Jurusan jurusan) {
        return ResponseEntity.ok(jurusanService.createJurusan(jurusan));
    }

    @GetMapping
    public ResponseEntity<List<JurusanDTO>> findAll() {
        try{
            return ResponseEntity.ok(jurusanService.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jurusan> findById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(jurusanService.findById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/nama={nama}")
    public ResponseEntity<Jurusan> findByNama(@PathVariable String nama) {
        try{
            return ResponseEntity.ok(jurusanService.findByNama(nama));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/q={nama}")
    public ResponseEntity<List<Jurusan>> findByNamaContain(@PathVariable String nama) {
        try{
            return ResponseEntity.ok(jurusanService.findByNamaContain(nama));
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
    public ResponseEntity<Jurusan> update(@PathVariable Long id, @RequestBody Jurusan jurusan){
        try{
            var result = jurusanService.update(id, jurusan);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
