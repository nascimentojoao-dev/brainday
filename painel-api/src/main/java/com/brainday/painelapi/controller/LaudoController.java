package com.brainday.painelapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainday.painelapi.dtos.LaudoDTO;
import com.brainday.painelapi.services.laudo.LaudoService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class LaudoController {
	
	private final LaudoService laudoService;
	
	@PostMapping("/laudos/{pacienteId}")
	LaudoDTO addLaudoByPacienteId(@PathVariable Long pacienteId, @RequestBody LaudoDTO laudoDTO) {
		return laudoService.addLaudoByPacienteId(pacienteId, laudoDTO);
	}
	
	@DeleteMapping("/laudos/{laudoId}")
	public void deleteLaudoByLaudoId(@PathVariable Long laudoId) {
		laudoService.deleteLaudoByLaudoId(laudoId);
	}
	
	@GetMapping("/laudos")
	List<LaudoDTO> getAllLaudos(){
		return laudoService.getAllLaudos();
	}
	
	@GetMapping("/laudos/paciente/{pacienteId}")
	List<LaudoDTO> getLaudosByPacienteId(@PathVariable Long pacienteId){
		return laudoService.getLaudosByPacienteId(pacienteId);
	}
}
