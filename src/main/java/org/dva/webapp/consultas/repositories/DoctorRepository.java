package org.dva.webapp.consultas.repositories;

import java.util.List;

import org.dva.webapp.consultas.entities.Consultorio;
import org.dva.webapp.consultas.entities.Doctor;
import org.dva.webapp.consultas.entities.Cita;
import org.dva.webapp.consultas.repositories.CrudRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class DoctorRepository implements CrudRepository<Doctor> {

    @Inject
    private EntityManager em;

    @Override
    public List<Doctor> listar() {
        return em.createQuery("from Doctor", Doctor.class).getResultList();
    }

    @Override
    public Doctor porId(Long id) {
        return em.find(Doctor.class, id);
    }

    @Override
    public void guardar(Doctor doctor) {
        if (doctor.getId() != null && doctor.getId() > 0) {
            em.merge(doctor);
        } else {
            em.persist(doctor);
        }
    }

    @Override
    public void eliminar(Long id) {
        Doctor doctor = porId(id);
        em.remove(doctor);
    }

}
