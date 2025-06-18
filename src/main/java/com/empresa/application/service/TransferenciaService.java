package com.empresa.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
    private final TransferenciaRepository transRepo;

    public TransferenciaService(@Qualifier("jpaTransferenciaRepository") TransferenciaRepository transRepo) {
        this.transRepo = transRepo;
    }

    public List<Empresa> getEmpresasConTransferenciasUltimoMes() {
        return transRepo.findEmpresasConTransferenciasDesde(LocalDate.now().minusMonths(1));
    }
}
