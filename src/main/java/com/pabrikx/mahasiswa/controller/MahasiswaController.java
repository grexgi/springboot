package com.pabrikx.mahasiswa.controller;

import com.pabrikx.common.response.ApiResponse;
import com.pabrikx.mahasiswa.dto.MahasiswaRequestDTO;
import com.pabrikx.mahasiswa.dto.MahasiswaResponseDTO;
import com.pabrikx.mahasiswa.service.MahasiswaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Mahasiswa", description = "CRUD Mahasiswa API")
// we can see swagger documentation in localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> create(@RequestBody @Valid MahasiswaRequestDTO request){
        mahasiswaService.create(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", "Success create mahasiswa " + request.toString()));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MahasiswaResponseDTO>>> findAll(){
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", mahasiswaService.findAll()));
    }

    @GetMapping("/id={id}")
    public ResponseEntity<ApiResponse<MahasiswaResponseDTO>> findByNim(@PathVariable Long id){
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", mahasiswaService.findById(id)));
    }

    @GetMapping("/query={query}")
    public ResponseEntity<ApiResponse<List<MahasiswaResponseDTO>>> findByNameQuery(@PathVariable String query){
        var lowerCaseQuery = query.toLowerCase();
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", mahasiswaService.findByNameQuery(lowerCaseQuery)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id){
        mahasiswaService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", "Success delete mahasiswa with id " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateById(@PathVariable Long id, @RequestBody @Valid MahasiswaRequestDTO request){
        mahasiswaService.updateById(id, request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", "Success update mahasiswa with id " + id + " as " + request.toString()));
    }
}
