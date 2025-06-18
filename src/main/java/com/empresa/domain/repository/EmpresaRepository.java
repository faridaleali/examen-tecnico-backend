package com.empresa.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.domain.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
    List<Empresa> findByFechaAdhesionAfter(LocalDate fecha);
}
