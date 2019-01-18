package mate.academy.jpademo.service;

import mate.academy.jpademo.model.Patient;

import java.util.List;
import java.util.Set;

public interface PatientService {
    Patient read(Integer id);

    Integer create(Patient patient);

    void update(Patient patient);

    void delete(Patient patient);

    Set<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel);
}
