package com.empresa.infrastructure.repository;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.repository.EmpresaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface JpaEmpresaRepository extends EmpresaRepository, JpaRepository<Empresa, String> {
    // Hereda los métodos de ambas interfaces
    @Override
    List<Empresa> findByFechaAdhesionAfter(LocalDate fecha);
}
