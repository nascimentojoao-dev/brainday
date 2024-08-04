package com.brainday.painelapi.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PacienteDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<LaudoDTO> laudos;
}

