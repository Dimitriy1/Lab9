package mate.academy.jpademo.model.test;

import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity(name = "skin_test")
public class SkinTest extends Test {
    @Column
    private Double dryness;
    @Column
    private Double oily;

    public SkinTest() {

    }

    public SkinTest(LocalDate dateOfCreate,
                    Patient patient,
                    Device device,
                    Double dryness,
                    Double oily) {
        super(dateOfCreate, patient, device);
        this.dryness = dryness;
        this.oily = oily;
    }

    public Double getDryness() {
        return dryness;
    }

    public void setDryness(Double dryness) {
        this.dryness = dryness;
    }

    public Double getOily() {
        return oily;
    }

    public void setOily(Double oily) {
        this.oily = oily;
    }

    @Override
    public String toString() {
        return "SkinTest{" +
                "dryness=" + dryness +
                ", oily=" + oily +
                '}';
    }
}
