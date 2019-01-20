package mate.academy.jpademo.dao.impl;

import mate.academy.jpademo.dao.AbstractDao;
import mate.academy.jpademo.dao.DeviceDao;
import mate.academy.jpademo.model.device.Device;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DeviceDaoImpl extends AbstractDao implements DeviceDao {

    public DeviceDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Device read(Integer id) {
        entityManager.getTransaction().begin();
        Device device = entityManager.find(Device.class, id);
        entityManager.getTransaction().commit();
        return device;
    }

    @Override
    public Integer create(Device device) {
        entityManager.getTransaction().begin();
        entityManager.persist(device);
        Query query = entityManager.createNativeQuery("select max(device.device_id) as maxId from device");
        Integer id = (Integer) query.getSingleResult();
        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Device device) {
        entityManager.getTransaction().begin();
        entityManager.merge(device);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Device device) {
        entityManager.getTransaction().begin();
        entityManager.remove(device);
        entityManager.getTransaction().commit();
    }
}
