package com.empresa.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    @Query("SELECT DISTINCT t.empresa FROM Transferencia t WHERE t.fechaTransferencia > :fecha")
    List<Empresa> findEmpresasConTransferenciasDesde(LocalDate fecha);
}
