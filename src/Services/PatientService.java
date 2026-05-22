package Services;

import Interfaces.Manageable;
import Interfaces.Searchable;

import java.time.LocalDate;
import Entity.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientService implements Manageable, Searchable{
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
    public Patient getPatientById(String patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        for (Patient patient : patients) {
            patient.displayInfo();
        }
    }
    public void searchPatientsByName(String name) {
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.getFirstName().equalsIgnoreCase(name) ||
                    patient.getLastName().equalsIgnoreCase(name)) {

                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patient found with this name.");
        }
    }


    public static List<Patient> getPatients() {
        return patients;
    }

// overloading methods:
    // Overloaded addPatient methods

    public void addPatient(String firstName, String lastName, String phone) {
        Patient patient = new Patient(
                "PERS-" + (patients.size() + 1),
                firstName,
                lastName,
                LocalDate.of(2000, 1, 1),
                "Not specified",
                phone,
                "Not provided",
                "Not provided",
                "PAT-" + (patients.size() + 1),
                "Not specified",
                new ArrayList<>(),
                "Not provided",
                LocalDate.now(),
                "Not provided",
                new ArrayList<>(),
                new ArrayList<>()
        );

        patients.add(patient);
        System.out.println("Patient added with minimal information.");
    }

    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient patient = new Patient(
                "PERS-" + (patients.size() + 1),
                firstName,
                lastName,
                LocalDate.of(2000, 1, 1),
                "Not specified",
                phone,
                email,
                "Not provided",
                "PAT-" + (patients.size() + 1),
                bloodGroup,
                new ArrayList<>(),
                "Not provided",
                LocalDate.now(),
                "Not provided",
                new ArrayList<>(),
                new ArrayList<>()
        );

        patients.add(patient);
        System.out.println("Patient added with blood group and email.");
    }

    //  Overloaded searchPatients methods

    public void searchPatients(String keyword) {
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.getFirstName().equalsIgnoreCase(keyword) ||
                    patient.getLastName().equalsIgnoreCase(keyword) ||
                    patient.getPatientId().equalsIgnoreCase(keyword) ||
                    patient.getPhoneNumber().equalsIgnoreCase(keyword)) {

                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patient found.");
        }
    }

    public void searchPatients(String firstName, String lastName) {
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                    patient.getLastName().equalsIgnoreCase(lastName)) {

                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patient found with this full name.");
        }
    }

    // : Overloaded displayPatients methods

    public void displayPatients() {
        displayAllPatients();
    }

    public void displayPatients(String filter) {
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.getBloodGroup().equalsIgnoreCase(filter) ||
                    patient.getGender().equalsIgnoreCase(filter)) {

                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients match this filter.");
        }
    }

    public void displayPatients(int limit) {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        int count = 0;

        for (Patient patient : patients) {
            if (count == limit) {
                break;
            }

            patient.displayInfo();
            count++;
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Patient) {
            addPatient((Patient) entity);
        }
    }

    @Override
    public void remove(String id) {
        removePatient(id);
    }

    @Override
    public List<Patient> getAll() {
        return patients;
    }

    @Override
    public void search(String keyword) {
        searchPatients(keyword);
    }

    @Override
    public Object searchById(String id) {
        return getPatientById(id);
    }
}
