package com.brainday.painelapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/pacientes/{id}")
    public PacienteDTO getPacienteById(@PathVariable Long id) {
    	return pacienteService.getPacienteById(id);
    }
    
    @PutMapping("/pacientes/{id}")
    public PacienteDTO updatePacienteById(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
    	return pacienteService.updatePacienteById(id, pacienteDTO);
    }

    @GetMapping("/pacientes")
    public List<PacienteDTO> getAllPacientes(){
    	return pacienteService.getAllPacientes();
    }
    
    @DeleteMapping("pacientes/{id}")
    public ResponseEntity<String> deletePacienteById(@PathVariable Long id) {
    	pacienteService.deletePacienteById(id);
    	return ResponseEntity.ok("Paciente deletado com sucesso!");
    }
}
