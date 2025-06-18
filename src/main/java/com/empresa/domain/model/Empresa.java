package com.empresa.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Empresa {
    @Id
    private String cuit;
    private String razonSocial;
    private LocalDate fechaAdhesion;
    
    public Empresa() {}

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFechaAdhesion() {
        return fechaAdhesion;
    }

    public void setFechaAdhesion(LocalDate fechaAdhesion) {
        this.fechaAdhesion = fechaAdhesion;
    }

    
}
