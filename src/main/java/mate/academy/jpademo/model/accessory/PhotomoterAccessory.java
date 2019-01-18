package mate.academy.jpademo.model.accessory;

import mate.academy.jpademo.model.device.Device;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "photometer_accessory")
public class PhotomoterAccessory extends Accessory {
    
    public PhotomoterAccessory() {
    }

    public PhotomoterAccessory(Device device) {
        super(device);
    }
}
