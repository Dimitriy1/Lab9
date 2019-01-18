package mate.academy.jpademo.dao.impl;

import mate.academy.jpademo.dao.AbstractDao;
import mate.academy.jpademo.dao.TestDao;
import mate.academy.jpademo.model.test.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestDaoImpl extends AbstractDao implements TestDao {

    public TestDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Test read(Integer id) {
        entityManager.getTransaction().begin();
        Test test = entityManager.find(Test.class, id);
        entityManager.getTransaction().commit();
        return test;
    }

    @Override
    public Integer create(Test test) {
        entityManager.getTransaction().begin();
        entityManager.persist(test);
        Query query = entityManager.createNativeQuery("select max(test.test_id) as maxId from test");
        Integer id = (Integer) query.getSingleResult();
        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Test test) {
        entityManager.getTransaction().begin();
        entityManager.merge(test);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Test test) {
        entityManager.getTransaction().begin();
        entityManager.remove(test);
        entityManager.getTransaction().commit();
    }

    @Override
    public Set<Test> getAllTests() {
        entityManager.getTransaction().begin();
        TypedQuery<Test> query = entityManager.createQuery("select t from test t", Test.class);
        Set<Test> tests = new LinkedHashSet<>(query.getResultList());
        entityManager.getTransaction().commit();
        return tests;
    }

    @Override
    public Set<Test> getAllTestsInDateRange(LocalDate from, LocalDate to) {
        entityManager.getTransaction().begin();
        TypedQuery<Test> query = entityManager.createQuery("select t from test t " +
                "inner join patient p " +
                "on p.id = t.patient.id " +
                "where t.dateOfCreate >= :from and t.dateOfCreate <= :to", Test.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        Set<Test> tests = new LinkedHashSet<>(query.getResultList());
        entityManager.getTransaction().commit();
        return tests;
    }
}