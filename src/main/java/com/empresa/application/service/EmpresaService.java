package com.empresa.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepo;

    public EmpresaService(@Qualifier("jpaEmpresaRepository") EmpresaRepository empresaRepository) {
        this.empresaRepo = empresaRepository;
    }

    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        return empresaRepo.findByFechaAdhesionAfter(LocalDate.now().minusMonths(1));
    }

    public Empresa adherirEmpresa(Empresa empresa) {
        if (empresaRepo.existsById(empresa.getCuit())) {
            throw new IllegalArgumentException("Empresa ya adherida");
        }
        empresa.setFechaAdhesion(LocalDate.now());
        return empresaRepo.save(empresa);
    }
}