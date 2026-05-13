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

    public void editAppointment(String appointmentId, Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.set(i, updatedAppointment);
                System.out.println("Appointment updated successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
}
