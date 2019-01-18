package mate.academy.jpademo.dao;

import mate.academy.jpademo.model.Patient;

import java.util.Set;

public interface PatientDao extends CrudDao<Patient, Integer> {
    Set<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel);
}
