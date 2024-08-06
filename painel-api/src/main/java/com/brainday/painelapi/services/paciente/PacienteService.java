package com.brainday.painelapi.services.paciente;

import java.util.List;

import com.brainday.painelapi.dtos.PacienteDTO;

public interface PacienteService {
    PacienteDTO addPaciente(PacienteDTO pacienteDTO);
    PacienteDTO getPacienteById(Long id);
    PacienteDTO updatePacienteById(Long id, PacienteDTO pacienteDTO);
    void deletePacienteById(Long id);
    List<PacienteDTO> getAllPacientes();
}
