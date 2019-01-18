package mate.academy.jpademo;

import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.TypeOfTest;
import mate.academy.jpademo.model.device.Photometer;
import mate.academy.jpademo.model.device.UltrasonicDevice;
import mate.academy.jpademo.service.factory.ServiceFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setName("Kiril");
        patient.setLastName("Babiev");
        patient.setDateOfBirth(LocalDate.of(1997,6,6));
        ServiceFactory.getPatientService().create(patient);

        UltrasonicDevice ultrasonicDevice = new UltrasonicDevice();
        ultrasonicDevice.setColor("black");
        ultrasonicDevice.setVolume(200.0);
        ultrasonicDevice.setTension(750.0);
        ServiceFactory.getDeviseService().create(ultrasonicDevice);

        ServiceFactory.getTestService().doTest(patient, TypeOfTest.SKIN,ultrasonicDevice);

        patient = new Patient();
        patient.setName("Dima");
        patient.setLastName("Litvin");
        patient.setDateOfBirth(LocalDate.of(2001,10,6));
        ServiceFactory.getPatientService().create(patient);

        Photometer photometer = new Photometer();
        photometer.setRadius(20.0);
        photometer.setWeight(25.5);
        photometer.setTransmittance(340);
        ServiceFactory.getDeviseService().create(photometer);
        ServiceFactory.getTestService().doTest(patient, TypeOfTest.BLOOD,photometer);
        ServiceFactory.getTestService().getAllTests().stream().forEach(System.out::println);
        ServiceFactory.getPatientService().getPatientsWithGlucoseHigherThan(130.0).stream().forEach(System.out::println);
        ServiceFactory.getTestService().getAllTestsInDateRange(LocalDate.of(1997,10,10),LocalDate.now());
    }
}
