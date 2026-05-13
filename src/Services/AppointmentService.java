package Services;
import Entity.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added successfully.");
    }
}
