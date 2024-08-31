package com.brainday.painelapi.services.laudo;

import java.util.List;

import com.brainday.painelapi.dtos.LaudoDTO;

public interface LaudoService {
	LaudoDTO addLaudoByPacienteId(Long pacienteId, LaudoDTO laudoDTO);
	void deleteLaudoByLaudoId(Long laudoId);
	List<LaudoDTO> getAllLaudos();
	List<LaudoDTO> getLaudosByPacienteId(Long pacienteId);
}
