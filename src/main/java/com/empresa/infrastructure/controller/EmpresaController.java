package com.empresa.infrastructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.application.service.EmpresaService;
import com.empresa.application.service.TransferenciaService;
import com.empresa.domain.model.Empresa;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;
    private final TransferenciaService transferenciaService;

    public EmpresaController(EmpresaService empresaService, TransferenciaService transferenciaService) {
        this.empresaService = empresaService;
        this.transferenciaService = transferenciaService;
    }

    @GetMapping("/adhesion-mes")
    public List<Empresa> empresasAdheridas() {
        return empresaService.getEmpresasAdheridasUltimoMes();
    }

    @GetMapping("/transf-mes")
    public List<Empresa> empresasConTransferencias() {
        return transferenciaService.getEmpresasConTransferenciasUltimoMes();
    }

    @PostMapping("/adhesion")
    public ResponseEntity<?> adherir(@RequestBody Empresa empresa) {
        try {
            return ResponseEntity.ok(empresaService.adherirEmpresa(empresa));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}
