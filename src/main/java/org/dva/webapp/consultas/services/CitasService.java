package org.dva.webapp.consultas.services;

import jakarta.ejb.Local;
import org.dva.webapp.consultas.entities.Consultorio;
import org.dva.webapp.consultas.entities.Doctor;
import org.dva.webapp.consultas.entities.Cita;

import java.util.List;
import java.util.Optional;

@Local
public interface CitasService {
    List<Cita> listar();

    Optional<Cita> porId(Long id);

    void guardar(Cita cita);

    void eliminar(Long id);

    List<Consultorio> listarConsultorio();

    Optional<Consultorio> porIdConsultorio(Long id);

    List<Doctor> listarDoctor();

    Optional<Doctor> porIdDoctor(Long id);
}
