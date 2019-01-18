package mate.academy.jpademo.service.factory;

import mate.academy.jpademo.dao.impl.AccessoryDaoImpl;
import mate.academy.jpademo.dao.impl.DeviceDaoImpl;
import mate.academy.jpademo.dao.impl.PatientDaoImpl;
import mate.academy.jpademo.dao.impl.TestDaoImpl;
import mate.academy.jpademo.service.AccessoryService;
import mate.academy.jpademo.service.DeviceService;
import mate.academy.jpademo.service.PatientService;
import mate.academy.jpademo.service.TestService;
import mate.academy.jpademo.service.impl.AccessoryServiceImpl;
import mate.academy.jpademo.service.impl.DeviceServiceImpl;
import mate.academy.jpademo.service.impl.PatientServiceImpl;
import mate.academy.jpademo.service.impl.TestServiceImpl;
import mate.academy.jpademo.util.HibernateUtil;

import javax.persistence.EntityManager;

public class ServiceFactory {
    private static final EntityManager entityManager;

    static {
        entityManager = HibernateUtil.getEntityManager();
    }

    public static DeviceService getDeviseService() {
        return new DeviceServiceImpl(new DeviceDaoImpl(entityManager));
    }

    public static PatientService getPatientService() {
        return new PatientServiceImpl(new PatientDaoImpl(entityManager));
    }

    public static TestService getTestService() {
        return new TestServiceImpl(new TestDaoImpl(entityManager));
    }

    public static AccessoryService getAccessoryService() {
        return new AccessoryServiceImpl(new AccessoryDaoImpl(entityManager));
    }
}