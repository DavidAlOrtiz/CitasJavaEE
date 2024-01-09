package org.dva.webapp.consultas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "el campo nombre no puede ser vacio!")
    private String nombrePaciente;

    private LocalDate horarioConsulta;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Consultorio consultorio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public LocalDate getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(LocalDate horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Cita [id=" + id + ", nombrePaciente=" + nombrePaciente + ", idConsultorio="
                + ", idDoctor=" + ", horarioConsulta=" + ", consultorio="
                + "]";
    }

}
