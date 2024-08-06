package com.brainday.painelapi.services.paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

	private final PacienteRepository pacienteRepository;

	@Override
	public PacienteDTO addPaciente(PacienteDTO pacienteDTO) {
		Paciente paciente = new Paciente();
		paciente.setNome(pacienteDTO.getNome());
		paciente.setDataNascimento(pacienteDTO.getDataNascimento());

		if (pacienteDTO.getLaudos() != null) {

			List<Laudo> laudos = pacienteDTO.getLaudos().stream().map(laudoDTO -> {
				Laudo laudo = new Laudo();
				laudo.setData(laudoDTO.getData());
				laudo.setDescricao(laudoDTO.getDescricao());
				return laudo;
			}).collect(Collectors.toList());

			laudos.forEach(laudo -> laudo.setPaciente(paciente));
			paciente.setLaudos(laudos);

		} else {
			pacienteDTO.setLaudos(new ArrayList<>());
		}

		Paciente savedPaciente = pacienteRepository.save(paciente);

		return new PacienteDTO(savedPaciente.getId(), savedPaciente.getNome(), savedPaciente.getDataNascimento(),
				savedPaciente.getLaudos().stream().map(laudo -> new LaudoDTO(laudo.getId(), laudo.getData(),
						laudo.getDescricao(), laudo.getPaciente().getId())).collect(Collectors.toList()));
	}

	@Override
	public PacienteDTO getPacienteById(Long id) {

		Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);

		if (optionalPaciente.isPresent()) {
			Paciente paciente = optionalPaciente.get();

			return new PacienteDTO(paciente.getId(), paciente.getNome(), paciente.getDataNascimento(),
					paciente.getLaudos().stream().map(laudo -> new LaudoDTO(laudo.getId(), laudo.getData(),
							laudo.getDescricao(), laudo.getPaciente().getId())).collect(Collectors.toList()));
		} else {
			throw new RuntimeException("Paciente com id: " + id + " não encontrado.");
		}
	}

	@Override
	public PacienteDTO updatePacienteById(Long id, PacienteDTO pacienteDTO) {
		Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);

		if (optionalPaciente.isPresent()) {
			Paciente foundPaciente = optionalPaciente.get();

			if (pacienteDTO.getNome() != null && !pacienteDTO.getNome().isEmpty()) {
				foundPaciente.setNome(pacienteDTO.getNome());
			}

			if (pacienteDTO.getDataNascimento() != null) {

				foundPaciente.setDataNascimento(pacienteDTO.getDataNascimento());
			}

			if (pacienteDTO.getLaudos() != null && !pacienteDTO.getLaudos().isEmpty()) {
				List<Laudo> existingLaudos = foundPaciente.getLaudos();

				List<Laudo> newLaudos = pacienteDTO.getLaudos().stream().map(laudoDTO -> {
					Laudo laudo = new Laudo();
					laudo.setData(laudoDTO.getData());
					laudo.setDescricao(laudoDTO.getDescricao());
					laudo.setPaciente(foundPaciente);
					return laudo;
				}).collect(Collectors.toList());

				existingLaudos.addAll(newLaudos);
				foundPaciente.setLaudos(existingLaudos);
			}

			Paciente updatedPaciente = pacienteRepository.save(foundPaciente);

			return new PacienteDTO(updatedPaciente.getId(), updatedPaciente.getNome(),
					updatedPaciente.getDataNascimento(),
					updatedPaciente.getLaudos().stream().map(laudo -> new LaudoDTO(laudo.getId(), laudo.getData(),
							laudo.getDescricao(), laudo.getPaciente().getId())).collect(Collectors.toList()));
		} else {
			throw new RuntimeException("Paciente com id: " + id + " não encontrado.");
		}
	}

	@Override
	public void deletePacienteById(Long id) {
		Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);

		if (optionalPaciente.isPresent()) {
			pacienteRepository.deleteById(id);
		} else {
			throw new RuntimeException("Paciente com id: " + id + " não encontrado.");
		}
	}

	@Override
	public List<PacienteDTO> getAllPacientes() {
		List<Paciente> pacientes = pacienteRepository.findAll();

		return pacientes.stream()
				.map(paciente -> new PacienteDTO(paciente.getId(), paciente.getNome(), paciente.getDataNascimento(),
						paciente.getLaudos().stream()
								.map(laudo -> new LaudoDTO(laudo.getId(), laudo.getData(), laudo.getDescricao(),
										laudo.getPaciente().getId()))
								.collect(Collectors.toList())))
				.collect(Collectors.toList());

	}

}
