package mate.academy.jpademo.model.test;

import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "test")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_id")
    private Integer id;
    @Column(name = "date_of_create")
    private LocalDate dateOfCreate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(optional = false)
    @JoinColumn(name = "device_id")
    private Device device;

    public Test() {

    }

    public Test(LocalDate dateOfCreate, Patient patient, Device device) {
        this.dateOfCreate = dateOfCreate;
        this.patient = patient;
        this.device = device;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", dateOfCreate=" + dateOfCreate +
                '}';
    }
}