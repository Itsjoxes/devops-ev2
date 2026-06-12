package com.citt.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVenta;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccionCompra;
    private int valorCompra;
    @NotNull(message = "Fecha de compra es obligatoria")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  // Especifica el formato de fecha
    private LocalDate fechaCompra;
    @NotNull(message = "El campo de despacho debe ser proporcionado")
    private Boolean despachoGenerado = false;

    // Explicit getters/setters in case Lombok processing isn't active
    public Long getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getDireccionCompra() {
        return this.direccionCompra;
    }

    public void setDireccionCompra(String direccionCompra) {
        this.direccionCompra = direccionCompra;
    }

    public Integer getValorCompra() {
        return this.valorCompra;
    }

    public void setValorCompra(Integer valorCompra) {
        this.valorCompra = valorCompra;
    }

    public java.time.LocalDate getFechaCompra() {
        return this.fechaCompra;
    }

    public void setFechaCompra(java.time.LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Boolean getDespachoGenerado() {
        return this.despachoGenerado;
    }

    public void setDespachoGenerado(Boolean despachoGenerado) {
        this.despachoGenerado = despachoGenerado;
    }
}
