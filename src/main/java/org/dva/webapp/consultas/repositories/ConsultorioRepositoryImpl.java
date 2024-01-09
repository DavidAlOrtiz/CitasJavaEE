package org.dva.webapp.consultas.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.dva.webapp.consultas.entities.Consultorio;

import java.util.List;

@RequestScoped
public class ConsultorioRepositoryImpl implements CrudRepository<Consultorio> {

    @Inject
    private EntityManager em;

    @Override
    public List<Consultorio> listar() {
        return em.createQuery("from Consultorio", Consultorio.class).getResultList();
    }

    @Override
    public Consultorio porId(Long id) {
        return em.find(Consultorio.class, id);
    }

    @Override
    public void guardar(Consultorio consultorio) {
        if (consultorio.getId() != null && consultorio.getId() > 0) {
            em.merge(consultorio);
        } else {
            em.persist(consultorio);
        }
    }

    @Override
    public void eliminar(Long id) {
        em.remove(porId(id));
    }
}
