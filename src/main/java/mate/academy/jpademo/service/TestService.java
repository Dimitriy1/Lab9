package mate.academy.jpademo.service;

import mate.academy.jpademo.model.TypeOfTest;
import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.device.Device;
import mate.academy.jpademo.model.test.Test;

import java.time.LocalDate;
import java.util.Set;

public interface TestService {
    Test read(Integer id);

    Integer create(Test test);

    void update(Test test);

    void delete(Test test);

    Set<Test> getAllTests();

    Set<Test> getAllTestsInDateRange(LocalDate from, LocalDate to);

    void doTest(Patient patient, TypeOfTest testType, Device device);
}
