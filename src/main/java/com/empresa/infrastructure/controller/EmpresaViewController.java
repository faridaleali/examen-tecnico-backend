package com.empresa.infrastructure.controller;

import com.empresa.application.service.EmpresaService;
import com.empresa.application.service.TransferenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaViewController {

    private final EmpresaService empresaService;
    private final TransferenciaService transferenciaService;

    public EmpresaViewController(EmpresaService empresaService, TransferenciaService transferenciaService) {
        this.empresaService = empresaService;
        this.transferenciaService = transferenciaService;
    }

    @GetMapping("/empresas-vista")
    public String mostrarEmpresas(Model model) {
        model.addAttribute("empresas", empresaService.getEmpresasAdheridasUltimoMes());
        return "empresas";
    }

    @GetMapping("/transferencias-vista")
    public String mostrarEmpresasConTransferencias(Model model) {
        model.addAttribute("empresas", transferenciaService.getEmpresasConTransferenciasUltimoMes());
        return "transferencias";
    }
}