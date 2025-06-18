package com.empresa.infrastructure.repository;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.model.Transferencia;
import com.empresa.domain.repository.TransferenciaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface JpaTransferenciaRepository extends TransferenciaRepository, JpaRepository<Transferencia, Long> {

    @Override
    @Query("SELECT DISTINCT t.empresa FROM Transferencia t WHERE t.fechaTransferencia > :fecha")
    List<Empresa> findEmpresasConTransferenciasDesde(LocalDate fecha);
}
