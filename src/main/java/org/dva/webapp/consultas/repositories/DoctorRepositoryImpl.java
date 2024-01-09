package org.dva.webapp.consultas.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.dva.webapp.consultas.entities.Doctor;

import java.util.List;

@RequestScoped
public class DoctorRepositoryImpl implements CrudRepository<Doctor> {

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
        em.remove(porId(id));
    }
}
