package Services;

import Entity.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();



    public List<Doctor> getDoctors() {
        return doctors;
    }

}

