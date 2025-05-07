package com.pabrikx.mahasiswa;

import com.pabrikx.jurusan.model.Jurusan;
import com.pabrikx.mahasiswa.dto.MahasiswaResponseDTO;
import com.pabrikx.mahasiswa.model.Mahasiswa;
import com.pabrikx.mahasiswa.repository.MahasiswaRepository;
import com.pabrikx.mahasiswa.service.MahasiswaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MahasiswaServiceTest {

	@Mock
	private MahasiswaRepository mahasiswaRepository;

	@InjectMocks
	private MahasiswaService mahasiswaService;

	private Mahasiswa mahasiswa;

	@BeforeEach
	void setUp() {
		Jurusan jurusan = Jurusan.builder()
				.id(1L)
				.nama("Teknik Informatika")
				.build();

		mahasiswa = Mahasiswa.builder()
				.id(1L)
				.nama("Gavin")
				.nim("220001")
				.jurusan(jurusan)
				.build();
	}

	@Test
	void testGetMahasiswaById_success() {
		// Arrange
		when(mahasiswaRepository.findById(1L)).thenReturn(Optional.of(mahasiswa));

		// Act
		MahasiswaResponseDTO result = mahasiswaService.findById(1L);

		// Assert
		assertNotNull(result);
		assertEquals("Gavin", result.getNama());
		assertEquals("220001", result.getNim());
		assertEquals("Teknik Informatika", result.getJurusan());
	}

	@Test
	void testGetMahasiswaById_notFound() {
		// Arrange
		when(mahasiswaRepository.findById(99L)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(RuntimeException.class, () -> mahasiswaService.findById(99L));
	}
}
