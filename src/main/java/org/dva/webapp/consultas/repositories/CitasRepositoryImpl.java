package org.dva.webapp.consultas.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.dva.webapp.consultas.entities.Cita;

import java.util.List;

@RequestScoped
public class CitasRepositoryImpl implements CrudRepository<Cita> {

    @Inject
    private EntityManager em;

    @Override
    public List<Cita> listar() {
        return em
                .createQuery("select c from Cita c left outer join fetch c.consultorio left outer join fetch c.doctor",
                        Cita.class)
                .getResultList();
    }

    @Override
    public Cita porId(Long id) {
        // return em.find(cita.class, id);
        return em.createQuery(
                "select c from Cita c left outer join fetch c.consultorio left outer join fetch c.doctor where c.id=:id",
                Cita.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void guardar(Cita cita) {
        if (cita.getId() != null && cita.getId() > 0) {
            em.merge(cita);
        } else {
            em.persist(cita);
        }
    }

    @Override
    public void eliminar(Long id) {
        Cita cita = porId(id);
        em.remove(cita);
    }
}
