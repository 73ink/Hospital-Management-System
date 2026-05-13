package Services;

import Entity.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
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


    public List<Doctor> getDoctors() {
        return doctors;
    }

}

