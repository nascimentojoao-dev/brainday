package com.brainday.painelapi.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaudoDTO {
    private Long id;
    private LocalDate data;
    private String descricao;
    private Long pacienteId;
}
