package com.brainday.painelapi.services.paciente;

import java.util.List;

import com.brainday.painelapi.dtos.PacienteDTO;

public interface PacienteService {
    PacienteDTO addPaciente(PacienteDTO pacienteDTO);
    PacienteDTO getPaciente(Long id);
    PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTO);
    void deletePaciente(Long id);
    List<PacienteDTO> getAllPacientes();
}
