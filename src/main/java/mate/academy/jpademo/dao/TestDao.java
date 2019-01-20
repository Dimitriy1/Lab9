package mate.academy.jpademo.dao;

import mate.academy.jpademo.model.test.Test;

import java.time.LocalDate;
import java.util.Set;

public interface TestDao extends CrudDao<Test, Integer> {
    Set<Test> getAllTests();

    Set<Test> getAllTestsInDateRange(LocalDate from, LocalDate to);
}
