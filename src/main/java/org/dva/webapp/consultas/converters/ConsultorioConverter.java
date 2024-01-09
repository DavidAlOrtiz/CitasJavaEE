package org.dva.webapp.consultas.converters;

import java.util.Optional;

import org.dva.webapp.consultas.entities.Consultorio;
import org.dva.webapp.consultas.services.CitasService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named("ConsultorioConverter")
public class ConsultorioConverter implements Converter<Consultorio> {

    @Inject
    private CitasService service;

    @Override
    public Consultorio getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null) {
            return null;
        }
        Optional<Consultorio> consultorioOptional = service.porIdConsultorio(Long.valueOf(id));
        if (consultorioOptional.isPresent()) {
            return consultorioOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Consultorio consultorio) {
        if (consultorio == null) {
            return "0";
        }
        return consultorio.getId().toString();
    }
}
