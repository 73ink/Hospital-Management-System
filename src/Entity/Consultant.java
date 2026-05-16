package Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor{
    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List availableSlots, List assignedPatients, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.consultationTypes = new ArrayList<>();
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Consultation Types: " + consultationTypes);
        System.out.println("Online Consultation Available: " + onlineConsultationAvailable);
        System.out.println("Consultation Duration: " + consultationDuration + " minutes");
        System.out.println("-----------------------------------");
    }

    public void scheduleConsultation(String consultationType) {
        consultationTypes.add(consultationType);
        System.out.println("Consultation scheduled: " + consultationType);
    }

    public void provideSecondOpinion() {
        System.out.println("Consultant is providing a second opinion.");
    }

}
