package org.dva.webapp.consultas.services;

import java.util.List;
import java.util.Optional;

import org.dva.webapp.consultas.entities.Doctor;

import jakarta.ejb.Local;

@Local
public interface DoctorService {
    List<Doctor> listar();

    Optional<Doctor> porId(Long id);

    void guardar(Doctor cita);

    void eliminar(Long id);
}
