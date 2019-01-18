package mate.academy.jpademo.model.accessory;

import mate.academy.jpademo.model.device.Device;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "accessory")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accessory_id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "device_id")
    private Device device;

    public Accessory() {

    }

    public Accessory(Device device) {
        this.device = device;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                '}';
    }
}
