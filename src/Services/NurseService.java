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

    public void removeNurse(String nurseId) {
        for (Nurse nurse : nurses) {
            if (nurse.getNurseId().equals(nurseId)) {
                nurses.remove(nurse);
                System.out.println("Nurse removed successfully.");
                return;
            }
        }
        System.out.println("Nurse not found.");
    }

    public Nurse getNurseById(String nurseId) {
        for (Nurse nurse : nurses) {
            if (nurse.getNurseId().equals(nurseId)) {
                return nurse;
            }
        }
        return null;
    }

    public void displayAllNurses() {
        if (nurses.isEmpty()) {
            System.out.println("No nurses available.");
            return;
        }

        for (Nurse nurse : nurses) {
            nurse.displayInfo();
        }
    }

    public void getNursesByDepartment(String departmentId) {
        boolean found = false;

        for (Nurse nurse : nurses) {
            if (nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {
                nurse.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No nurses found in this department.");
        }
    }

}
