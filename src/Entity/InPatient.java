package Entity;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class InPatient extends Patient{
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;
}
