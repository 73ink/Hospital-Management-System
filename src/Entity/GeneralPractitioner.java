package Entity;
import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor{
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

        // constructor: Person -> Doctor -> GeneralPractitioner
    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List availableSlots, List assignedPatients, boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    // override method

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Walk-in Available: " + walkinAvailable);
        System.out.println("Home Visit Available: " + homeVisitAvailable);
        System.out.println("Vaccination Certified: " + vaccinationCertified);
        System.out.println("-----------------------------------");
    }
    public void scheduleHomeVisit() {
        if (homeVisitAvailable) {
            System.out.println("Home visit scheduled successfully.");
        } else {
            System.out.println("Home visit is not available for this doctor.");
        }
    }
}

