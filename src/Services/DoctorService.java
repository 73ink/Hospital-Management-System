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


    public List<Doctor> getDoctors() {
        return doctors;
    }

}

