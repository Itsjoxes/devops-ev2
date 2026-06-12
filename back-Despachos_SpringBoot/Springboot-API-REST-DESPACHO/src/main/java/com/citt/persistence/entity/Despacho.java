package com.citt.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despacho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDespacho;
    //@NotNull(message = "Fecha de despacho es obligatoria")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  // Especifica el formato de fecha
    private LocalDate fechaDespacho;
    private String patenteCamion;
    private int intento;
    private Long idCompra;
    //@NotBlank(message = "La dirección es obligatoria")
    private String direccionCompra;
    // Explicit getters and setters in case Lombok annotation processing is not active
    public Long getIdDespacho() {
        return this.idDespacho;
    }

    public void setIdDespacho(Long idDespacho) {
        this.idDespacho = idDespacho;
    }

    public java.time.LocalDate getFechaDespacho() {
        return this.fechaDespacho;
    }

    public void setFechaDespacho(java.time.LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getPatenteCamion() {
        return this.patenteCamion;
    }

    public void setPatenteCamion(String patenteCamion) {
        this.patenteCamion = patenteCamion;
    }

    public int getIntento() {
        return this.intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public Long getIdCompra() {
        return this.idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public String getDireccionCompra() {
        return this.direccionCompra;
    }

    public void setDireccionCompra(String direccionCompra) {
        this.direccionCompra = direccionCompra;
    }

    public Long getValorCompra() {
        return this.valorCompra;
    }

    public void setValorCompra(Long valorCompra) {
        this.valorCompra = valorCompra;
    }

    public boolean isDespachado() {
        return this.despachado;
    }

    public void setDespachado(boolean despachado) {
        this.despachado = despachado;
    }
    private Long valorCompra;
    private boolean despachado = false;
}