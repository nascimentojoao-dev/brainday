package com.brainday.painelapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainday.painelapi.dtos.PacienteDTO;
import com.brainday.painelapi.services.paciente.PacienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<String> getDoctorPanel() {
        return ResponseEntity.ok("Bem vindo ao painel de Doutor!");
    }
    
    @PostMapping("/pacientes")
    public PacienteDTO addPaciente(@RequestBody PacienteDTO pacienteDTO){
    	return pacienteService.addPaciente(pacienteDTO);
    }
}
