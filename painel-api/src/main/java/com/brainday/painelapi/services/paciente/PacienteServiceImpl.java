package com.brainday.painelapi.services.paciente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brainday.painelapi.dtos.LaudoDTO;
import com.brainday.painelapi.dtos.PacienteDTO;
import com.brainday.painelapi.entities.Laudo;
import com.brainday.painelapi.entities.Paciente;
import com.brainday.painelapi.repositories.PacienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

	private PacienteRepository pacienteRepository;

	@Override
	public PacienteDTO addPaciente(PacienteDTO pacienteDTO) {
		Paciente paciente = new Paciente();
		paciente.setNome(pacienteDTO.getNome());
		paciente.setDataNascimento(pacienteDTO.getDataNascimento());
		
		List<Laudo> laudos = pacienteDTO.getLaudos().stream().map(laudoDTO -> {
			Laudo laudo = new Laudo();
			laudo.setData(laudoDTO.getData());
			laudo.setDescricao(laudoDTO.getDescricao());
			return laudo;
		}).collect(Collectors.toList());

		laudos.forEach(laudo -> laudo.setPaciente(paciente));
		paciente.setLaudos(laudos);
		
		Paciente savedPaciente = pacienteRepository.save(paciente);
		
        return new PacienteDTO(savedPaciente.getId(), savedPaciente.getNome(), savedPaciente.getDataNascimento(),
        		savedPaciente.getLaudos().stream()
                .map(laudo -> new LaudoDTO(
                        laudo.getId(), 
                        laudo.getData(), 
                        laudo.getDescricao(), 
                        laudo.getPaciente().getId()
                    )).collect(Collectors.toList()));
	}

	@Override
	public PacienteDTO getPaciente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePaciente(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PacienteDTO> getAllPacientes() {
		// TODO Auto-generated method stub
		return null;
	}

}
