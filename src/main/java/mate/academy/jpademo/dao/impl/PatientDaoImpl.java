package mate.academy.jpademo.dao.impl;

import mate.academy.jpademo.dao.AbstractDao;
import mate.academy.jpademo.dao.PatientDao;
import mate.academy.jpademo.model.Patient;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.LinkedHashSet;
import java.util.Set;

public class PatientDaoImpl extends AbstractDao implements PatientDao {

    public PatientDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Patient read(Integer id) {
        entityManager.getTransaction().begin();
        Patient patient = entityManager.find(Patient.class, id);
        entityManager.getTransaction().commit();
        return patient;
    }

    @Override
    public Integer create(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        Query query = entityManager.createNativeQuery("select max(patient.patient_id) as maxId from patient");
        Integer id = (Integer) query.getSingleResult();
        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.remove(patient);
        entityManager.getTransaction().commit();
    }

    @Override
    public Set<Patient> getPatientsWithGlucoseHigherThan(Double glucoseNormalLevel) {
        entityManager.getTransaction().begin();
        TypedQuery<Patient> query = entityManager.createQuery("select p from patient p " +
                "inner join blood_test bt " +
                "on p.id = bt.patient.id " +
                "where bt.levelOfGlucose > :normalLevel", Patient.class);
        query.setParameter("normalLevel", glucoseNormalLevel);
        Set<Patient> patients = new LinkedHashSet<>(query.getResultList());
        entityManager.getTransaction().commit();
        return patients;
    }
}
