package Services;
import Interfaces.Manageable;
import Interfaces.Searchable;

import Entity.Doctor;
import Entity.Patient;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class DoctorService implements Manageable, Searchable{
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }
    public void editDoctor(String doctorId, Doctor updatedDoctor){
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(doctorId)) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor updated successfully.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }
    public void removeDoctor(String doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                doctors.remove(doctor);
                System.out.println("Doctor removed successfully.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }
    public Doctor getDoctorById(String doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }
        }
        return null;
    }
    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }
    }

    public void getDoctorsBySpecialization(String specialization) {
        boolean found = false;

        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                doctor.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctors found with this specialization.");
        }
    }

    public void getAvailableDoctors() {
        boolean found = false;

        for (Doctor doctor : doctors) {
            if (!doctor.getAvailableSlots().isEmpty()) {
                doctor.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available doctors found.");
        }
    }


    public List<Doctor> getDoctors() {
        return doctors;
    }

// overloading methods:
    // Overloaded addDoctor methods
    // Task 2.3: Overloaded addDoctor methods

    public void addDoctor(String name, String specialization, String phone) {
        String[] nameParts = name.split(" ");

        String firstName = nameParts[0];
        String lastName = "Not specified";

        if (nameParts.length > 1) {
            lastName = nameParts[1];
        }

        Doctor doctor = new Doctor(
                "PERS-DOC-" + (doctors.size() + 1),
                firstName,
                lastName,
                LocalDate.of(1980, 1, 1),
                "Not specified",
                phone,
                "Not provided",
                "Not provided",
                "DOC-" + (doctors.size() + 1),
                specialization,
                "Not provided",
                0,
                "Not assigned",
                0.0,
                new ArrayList<>(),
                new ArrayList<>()
        );

        doctors.add(doctor);
        System.out.println("Doctor added with basic information.");
    }

    public void addDoctor(String name, String specialization, String phone, double consultationFee) {
        String[] nameParts = name.split(" ");

        String firstName = nameParts[0];
        String lastName = "Not specified";

        if (nameParts.length > 1) {
            lastName = nameParts[1];
        }

        Doctor doctor = new Doctor(
                "PERS-DOC-" + (doctors.size() + 1),
                firstName,
                lastName,
                LocalDate.of(1980, 1, 1),
                "Not specified",
                phone,
                "Not provided",
                "Not provided",
                "DOC-" + (doctors.size() + 1),
                specialization,
                "Not provided",
                0,
                "Not assigned",
               consultationFee,
                new ArrayList<>(),
                new ArrayList<>()
        );

        doctors.add(doctor);
        System.out.println("Doctor added with consultation fee.");
    }

    // Task 2.3: Overloaded assignPatient methods

    public void assignPatient(String doctorId, String patientId) {
        Doctor doctor = getDoctorById(doctorId);

        if (doctor != null) {
            doctor.assignPatient(patientId);
            System.out.println("Patient assigned to doctor successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void assignPatient(Doctor doctor, Patient patient) {
        if (doctor != null && patient != null) {
            doctor.assignPatient(patient.getPatientId());
            System.out.println("Patient assigned to doctor successfully.");
        } else {
            System.out.println("Doctor or patient is missing.");
        }
    }

    public void assignPatient(String doctorId, List<String> patientIds) {
        Doctor doctor = getDoctorById(doctorId);

        if (doctor != null) {
            for (String patientId : patientIds) {
                doctor.assignPatient(patientId);
            }
            System.out.println("Patients assigned to doctor successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    // Task 2.3: Overloaded displayDoctors methods

    public void displayDoctors() {
        displayAllDoctors();
    }

    public void displayDoctors(String specialization) {
        getDoctorsBySpecialization(specialization);
    }

    public void displayDoctors(String departmentId, boolean showAvailableOnly) {
        boolean found = false;

        for (Doctor doctor : doctors) {
            if (doctor.getDepartmentId().equalsIgnoreCase(departmentId)) {

                if (showAvailableOnly) {
                    if (!doctor.getAvailableSlots().isEmpty()) {
                        doctor.displayInfo();
                        found = true;
                    }
                } else {
                    doctor.displayInfo();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No doctors found with the selected filter.");
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Doctor) {
            addDoctor((Doctor) entity);
        }
    }

    @Override
    public void remove(String id) {
        removeDoctor(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctors;
    }

    @Override
    public void search(String keyword) {
        getDoctorsBySpecialization(keyword);
    }

    @Override
    public Object searchById(String id) {
        return getDoctorById(id);
    }
}

