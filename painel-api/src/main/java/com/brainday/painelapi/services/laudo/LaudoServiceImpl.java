package com.brainday.painelapi.services.laudo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brainday.painelapi.dtos.LaudoDTO;
import com.brainday.painelapi.entities.Laudo;
import com.brainday.painelapi.entities.Paciente;
import com.brainday.painelapi.exceptions.LaudoNotFoundException;
import com.brainday.painelapi.exceptions.PacienteNotFoundException;
import com.brainday.painelapi.repositories.LaudoRepository;
import com.brainday.painelapi.repositories.PacienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LaudoServiceImpl implements LaudoService {

    private final LaudoRepository laudoRepository;

    private final PacienteRepository pacienteRepository;

    @Override
    public LaudoDTO addLaudoByPacienteId(Long pacienteId, LaudoDTO laudoDTO) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNotFoundException(pacienteId));

        Laudo laudo = new Laudo();
        laudo.setData(laudoDTO.getData());
        laudo.setDescricao(laudoDTO.getDescricao());
        laudo.setPaciente(paciente);

        Laudo savedLaudo = laudoRepository.save(laudo);

        return new LaudoDTO(savedLaudo.getId(), savedLaudo.getData(), savedLaudo.getDescricao(), savedLaudo.getPaciente().getId());
    }

    @Override
    public void deleteLaudoByLaudoId(Long laudoId) {
        Laudo laudo = laudoRepository.findById(laudoId)
                .orElseThrow(() -> new LaudoNotFoundException(laudoId));

        laudoRepository.delete(laudo);
    }

    @Override
    public List<LaudoDTO> getAllLaudos() {
        List<Laudo> laudos = laudoRepository.findAll();
        return laudos.stream()
                .map(laudo -> new LaudoDTO(laudo.getId(), laudo.getData(), laudo.getDescricao(), laudo.getPaciente().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<LaudoDTO> getLaudosByPacienteId(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNotFoundException(pacienteId));

        List<Laudo> laudos = paciente.getLaudos();
        return laudos.stream()
                .map(laudo -> new LaudoDTO(laudo.getId(), laudo.getData(), laudo.getDescricao(), laudo.getPaciente().getId()))
                .collect(Collectors.toList());
    }
}
