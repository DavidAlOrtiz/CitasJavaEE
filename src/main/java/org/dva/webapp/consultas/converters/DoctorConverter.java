package org.dva.webapp.consultas.converters;

import java.util.Optional;

import org.dva.webapp.consultas.entities.Doctor;
import org.dva.webapp.consultas.services.CitasService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named("DoctorConverter")
public class DoctorConverter implements Converter<Doctor> {

    @Inject
    private CitasService service;

    @Override
    public Doctor getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null) {
            return null;
        }
        Optional<Doctor> doctorOptional = service.porIdDoctor(Long.valueOf(id));
        if (doctorOptional.isPresent()) {
            return doctorOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Doctor doctor) {
        if (doctor == null) {
            return "0";
        }
        return doctor.getId().toString();
    }
}
