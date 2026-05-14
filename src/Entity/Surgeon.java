package Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Surgeon extends Doctor{
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    //Constructor chaining flow: Person -> Doctor -> Surgeon
    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List availableSlots, List assignedPatients, int surgeriesPerformed, boolean operationTheatreAccess, List<String> surgeryTypes) {
        //  Doctor constructor will call Person constructor
        super (id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.operationTheatreAccess = operationTheatreAccess;
        this.surgeryTypes = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Surgery Types: " + surgeryTypes);
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
        System.out.println("----------------");
    }

    public void performSurgery(String surgeryType) {
        if (operationTheatreAccess) {
            surgeriesPerformed++;
            surgeryTypes.add(surgeryType);
            System.out.println("Surgery performed successfully.");
        } else {
            System.out.println("This surgeon does not have operation theatre access.");
        }
    }
    public void updateSurgeryCount() {
        surgeriesPerformed++;
    }
}
