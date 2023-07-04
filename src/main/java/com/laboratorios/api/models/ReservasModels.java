package com.laboratorios.api.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity(name = "reservas")
public class ReservasModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long id_profesores;

    @Column
    private Long id_laboratorios;

    @Column
    private Date fecha_reserva;

    @Column
    private String bloque;

    @Column
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_profesores() {
        return id_profesores;
    }

    public void setId_profesores(Long id_profesores) {
        this.id_profesores = id_profesores;
    }

    public Long getId_laboratorios() {
        return id_laboratorios;
    }

    public void setId_laboratorios(Long id_laboratorios) {
        this.id_laboratorios = id_laboratorios;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}