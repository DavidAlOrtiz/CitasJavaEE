package org.dva.webapp.consultas.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.dva.webapp.consultas.entities.Consultorio;
import org.dva.webapp.consultas.entities.Cita;
import org.dva.webapp.consultas.services.CitasService;

import java.util.Arrays;
import java.util.List;

@Model
public class ConsultaController {

    private Cita cita;

    private Long id;

    @Inject
    private CitasService service;

    @Produces
    @Model
    public String titulo() {
        return "Consultas";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Cita> findAll() {
        return service.listar();
    }

    @Produces
    @Model
    public Cita producto() {
        this.cita = new Cita();
        if (id != null && id > 0) {
            service.porId(id).ifPresent(p -> {
                this.cita = p;
            });
        }
        return cita;
    }

    @Produces
    @Model
    public List<Consultorio> categorias() {
        return service.listarConsultorio();
    }

    public String editar(Long id) {
        this.id = id;
        return "form.xhtml";
    }

    public String guardar() {
        System.out.println(cita);
        service.guardar(cita);
        return "index.xhtml?faces-redirect=true";
    }

    public String eliminar(Long id) {
        service.eliminar(id);
        return "index.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
