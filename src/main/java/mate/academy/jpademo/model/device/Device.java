package mate.academy.jpademo.model.device;

import mate.academy.jpademo.model.accessory.Accessory;
import mate.academy.jpademo.model.test.Test;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "device")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private String brand;
    @OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Accessory> accessories;
    @OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Test> tests;

    public Device() {

    }

    public Device(String name,
                  String model,
                  String brand,
                  Set<Accessory> accessories,
                  Set<Test> tests) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.accessories = accessories;
        this.tests = tests;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public void addAccessory(Accessory accessory) {
        if (accessories == null) {
            accessories = new LinkedHashSet<>();
        }
        accessory.setDevice(this);
        accessories.add(accessory);
    }

    public void addTest(Test test) {
        if (test == null) {
            tests = new LinkedHashSet<>();
        }
        test.setDevice(this);
        tests.add(test);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", accessories=" + accessories +
                ", tests=" + tests +
                '}';
    }
}