package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.TestDao;
import mate.academy.jpademo.model.TypeOfTest;
import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.device.Device;
import mate.academy.jpademo.model.test.BloodTest;
import mate.academy.jpademo.model.test.SkinTest;
import mate.academy.jpademo.model.test.Test;
import mate.academy.jpademo.service.TestService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestServiceImpl implements TestService {
    private TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test read(Integer id) {
        return testDao.read(id);
    }

    @Override
    public Integer create(Test test) {
        return testDao.create(test);
    }

    @Override
    public void update(Test test) {
        testDao.update(test);
    }

    @Override
    public void delete(Test test) {
        testDao.delete(test);
    }

    @Override
    public Set<Test> getAllTests() {
        return testDao.getAllTests();
    }

    @Override
    public Set<Test> getAllTestsInDateRange(LocalDate from, LocalDate to) {
        return testDao.getAllTestsInDateRange(from, to);
    }

    @Override
    public void doTest(Patient patient, TypeOfTest testType, Device device) {
        switch (testType) {
            case SKIN:
                SkinTest skinTest = new SkinTest();
                skinTest.setDevice(device);
                skinTest.setPatient(patient);
                skinTest.setOily((double) new Random().nextInt(50));
                skinTest.setDryness((double) new Random().nextInt(100));
                skinTest.setDateOfCreate(LocalDate.now());
                create(skinTest);
            case BLOOD:
                BloodTest bloodTest = new BloodTest();
                bloodTest.setDevice(device);
                bloodTest.setPatient(patient);
                bloodTest.setDateOfCreate(LocalDate.now());
                bloodTest.setLevelOfGlucose((double) new Random().nextInt(200));
                create(bloodTest);
        }
        System.out.println("patient: " + patient + " testType: " + testType + " device: " + device);
    }
}