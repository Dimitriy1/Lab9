package mate.academy.jpademo.model.device;

import mate.academy.jpademo.model.accessory.Accessory;
import mate.academy.jpademo.model.test.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "ultrasonic_device")
public class UltrasonicDevice extends Device {
    @Column
    private Double volume;
    @Column
    private Double tension;
    @Column
    private String color;

    public UltrasonicDevice() {

    }

    public UltrasonicDevice(String name,
                            String model,
                            String brand,
                            Set<Accessory> accessories,
                            Set<Test> tests,
                            Double volume,
                            Double tension,
                            String color) {
        super(name, model, brand, accessories, tests);
        this.volume = volume;
        this.tension = tension;
        this.color = color;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTension() {
        return tension;
    }

    public void setTension(Double tension) {
        this.tension = tension;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "UltrasonicDevice{" +
                "volume=" + volume +
                ", tension=" + tension +
                ", color='" + color + '\'' +
                '}';
    }
}