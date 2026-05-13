package Services;

import Entity.Doctor;
import Entity.Nurse;
import java.util.ArrayList;
import java.util.List;

public class NurseService {

    private List<Nurse> nurses = new ArrayList<>();

    public void addNurse(Nurse nurse){
        nurses.add(nurse);
        System.out.println("Nurse added successfully.");
    }


}
