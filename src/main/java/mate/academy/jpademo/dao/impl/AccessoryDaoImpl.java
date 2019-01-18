package mate.academy.jpademo.dao.impl;

import mate.academy.jpademo.dao.AbstractDao;
import mate.academy.jpademo.dao.AccessoryDao;
import mate.academy.jpademo.model.accessory.Accessory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;

public class AccessoryDaoImpl extends AbstractDao implements AccessoryDao, Serializable {

    public AccessoryDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Accessory read(Integer id) {
        entityManager.getTransaction().begin();
        Accessory accessory = entityManager.find(Accessory.class, id);
        entityManager.getTransaction().commit();
        return accessory;
    }

    @Override
    public Integer create(Accessory accessory) {
        entityManager.getTransaction().begin();
        entityManager.persist(accessory);
        Query query = entityManager.createNativeQuery("select max(accessory.accessory_id) as maxId from accessory");
        Integer id = (Integer) query.getSingleResult();
        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Accessory accessory) {
        entityManager.getTransaction().begin();
        entityManager.merge(accessory);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Accessory accessory) {
        entityManager.getTransaction().begin();
        entityManager.remove(accessory);
        entityManager.getTransaction().commit();
    }
}
