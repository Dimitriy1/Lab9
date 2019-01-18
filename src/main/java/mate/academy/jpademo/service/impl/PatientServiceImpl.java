package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.PatientDao;
import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.service.PatientService;

import java.util.Set;

public class PatientServiceImpl implements PatientService {
    PatientDao patienceDao;

    public PatientServiceImpl(PatientDao patienceDao) {
        this.patienceDao = patienceDao;
    }

    @Override
    public Patient read(Integer id) {
        return patienceDao.read(id);
    }

    @Override
    public Integer create(Patient patient) {
        return patienceDao.create(patient);
    }

    @Override
    public void update(Patient patient) {
        patienceDao.update(patient);
    }

    @Override
    public void delete(Patient patient) {
        patienceDao.delete(patient);
    }

    @Override
    public Set<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel) {
        return patienceDao.getPatientsWithGlucoseHigherThan(normalLevel);
    }
}
