package org.dva.webapp.consultas.services;

import java.util.List;
import java.util.Optional;

import org.dva.webapp.consultas.entities.Doctor;
import org.dva.webapp.consultas.entities.Cita;
import org.dva.webapp.consultas.repositories.CrudRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DoctoresServiceImpl implements DoctorService {

    @Inject
    private CrudRepository<Doctor> repository;

    @Override
    public List<Doctor> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Doctor> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Doctor doctor) {
        repository.guardar(doctor);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

}
