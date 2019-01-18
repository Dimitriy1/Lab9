package mate.academy.jpademo.model.device;

import mate.academy.jpademo.model.accessory.Accessory;
import mate.academy.jpademo.model.test.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "photometer_device")
public class Photometer extends Device {
    @Column
    private Integer transmittance;
    @Column
    private Double radius;
    @Column
    private Double weight;

    public Photometer() {

    }

    public Photometer(String name,
                      String model,
                      String brand,
                      Set<Accessory> accessories,
                      Set<Test> tests,
                      Integer transmittance,
                      Double radius,
                      Double weight) {
        super(name, model, brand, accessories, tests);
        this.transmittance = transmittance;
        this.radius = radius;
        this.weight = weight;
    }

    public Integer getTransmittance() {
        return transmittance;
    }

    public void setTransmittance(Integer transmittance) {
        this.transmittance = transmittance;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Photometer{" +
                "transmittance=" + transmittance +
                ", radius=" + radius +
                ", weight=" + weight +
                '}';
    }
}