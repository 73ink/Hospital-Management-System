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

    public void editNurse(String nurseId, Nurse updatedNurse) {
        for (int i = 0; i < nurses.size(); i++) {
            if (nurses.get(i).getNurseId().equals(nurseId)) {
                nurses.set(i, updatedNurse);
                System.out.println("Nurse updated successfully.");
                return;
            }
        }
        System.out.println("Nurse not found.");
    }


}
