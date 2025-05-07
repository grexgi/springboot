package com.pabrikx.jurusan.controller;

import com.pabrikx.common.response.ApiResponse;
import com.pabrikx.jurusan.dto.JurusanRequestDTO;
import com.pabrikx.jurusan.dto.JurusanResponseDTO;
import com.pabrikx.jurusan.service.JurusanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Jurusan", description = "CRUD Jurusan API")
// we can see swagger documentation in localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("/api/jurusan")
public class JurusanController {

    @Autowired
    private JurusanService jurusanService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> create(@RequestBody @Valid JurusanRequestDTO request) {
            jurusanService.createJurusan(request);
            return ResponseEntity.ok(new ApiResponse<>(true, "Success", request.toString()));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<JurusanResponseDTO>>> findAll() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", jurusanService.findAll()));
    }

    @GetMapping("/id={id}")
    public ResponseEntity<ApiResponse<JurusanResponseDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", jurusanService.findById(id)));
    }

    @GetMapping("/name={nama}")
    public ResponseEntity<ApiResponse<JurusanResponseDTO>> findByNama(@PathVariable String nama) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", jurusanService.findByNama(nama)));
    }

    @GetMapping("/query={query}")
    public ResponseEntity<ApiResponse<List<JurusanResponseDTO>>> findByNamaContain(@PathVariable String query) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", jurusanService.findByNamaContain(query)));
    }

//    This code is not handling referenced row on other table.
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id) {
        jurusanService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "success", "Jurusan with ID " + id + " deleted successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> update(@PathVariable Long id, @RequestBody @Valid JurusanRequestDTO request){
        jurusanService.update(id, request);
        return ResponseEntity.ok(new ApiResponse<>(true, "success", "Jurusan with ID " + id + " updated successfully" + request.toString()));
    }

}
