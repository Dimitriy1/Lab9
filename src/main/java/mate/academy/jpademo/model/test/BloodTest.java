package mate.academy.jpademo.model.test;

import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity(name = "blood_test")
public class BloodTest extends Test {
    @Column(name = "level_of_glucose")
    private Double levelOfGlucose;

    public BloodTest() {

    }

    public BloodTest(LocalDate dateOfCreate,
                     Patient patient,
                     Device device,
                     Double levelOfGlucose) {
        super(dateOfCreate, patient, device);
        this.levelOfGlucose = levelOfGlucose;
    }

    public Double getLevelOfGlucose() {
        return levelOfGlucose;
    }

    public void setLevelOfGlucose(Double levelOfGlucose) {
        this.levelOfGlucose = levelOfGlucose;
    }

    @Override
    public String toString() {
        return "BloodTest{" +
                "levelOfGlucose=" + levelOfGlucose +
                '}';
    }
}
