package Services;

import Entity.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private static List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }
    public void editPatient(String patientId, Patient updatedPatient){
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId().equals(patientId)) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }
    public void removePatient(String patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId().equals(patientId)) {
                patients.remove(patient);
                System.out.println("Patient removed successfully.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

}
