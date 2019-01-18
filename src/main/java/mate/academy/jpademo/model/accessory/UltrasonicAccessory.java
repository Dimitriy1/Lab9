package mate.academy.jpademo.model.accessory;

import mate.academy.jpademo.model.device.Device;

import javax.persistence.Entity;

@Entity(name = "ultrasonic_accessory")
public class UltrasonicAccessory extends Accessory {
    public UltrasonicAccessory() {
    }

    public UltrasonicAccessory(Device device) {
        super(device);
    }
}
