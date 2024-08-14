package com.brainday.painelapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainday.painelapi.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	boolean existsByNome(String nome);
}
