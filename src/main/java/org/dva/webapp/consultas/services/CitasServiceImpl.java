package org.dva.webapp.consultas.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.dva.webapp.consultas.entities.Consultorio;
import org.dva.webapp.consultas.entities.Doctor;
import org.dva.webapp.consultas.entities.Cita;
import org.dva.webapp.consultas.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class CitasServiceImpl implements CitasService {

    @Inject
    private CrudRepository<Cita> repository;

    @Inject
    private CrudRepository<Consultorio> consulRepository;

    @Inject
    private CrudRepository<Doctor> doctorRepository;

    @Override
    public List<Cita> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Cita> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Cita cita) {
        repository.guardar(cita);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    @Override
    public List<Consultorio> listarConsultorio() {
        return consulRepository.listar();
    }

    @Override
    public Optional<Consultorio> porIdConsultorio(Long id) {
        return Optional.ofNullable(consulRepository.porId(id));
    }

    @Override
    public List<Doctor> listarDoctor() {
        return doctorRepository.listar();
    }

    @Override
    public Optional<Doctor> porIdDoctor(Long id) {
        return Optional.ofNullable(doctorRepository.porId(id));
    }
}
