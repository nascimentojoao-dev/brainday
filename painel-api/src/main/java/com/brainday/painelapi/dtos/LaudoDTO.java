package com.brainday.painelapi.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LaudoDTO {
    private Long id;
    private LocalDate data;
    private String descricao;
    private Long pacienteId;
}
