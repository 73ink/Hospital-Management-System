package Entity;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient {

    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<MedicalRecord> medicalRecords, List<Appointment> appointments, int visitCount, String preferredDoctorId, LocalDate lastVisitDate) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.visitCount = visitCount;
        this.preferredDoctorId = preferredDoctorId;
        this.lastVisitDate = lastVisitDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Last Visit Date: " + lastVisitDate);
        System.out.println("Preferred Doctor ID: " + preferredDoctorId);
        System.out.println("-----------------------------------");
    }

    public void scheduleFollowUp(LocalDate followUpDate) {
        System.out.println("Follow-up scheduled on: " + followUpDate);
    }

    public void updateVisitCount() {
        visitCount++;
        lastVisitDate = LocalDate.now();
    }

    // getter and setter

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }
}