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

    public void removeAppointment(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointments.remove(appointment);
                System.out.println("Appointment removed successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public Appointment getAppointmentById(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }

    public void displayAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        for (Appointment appointment : appointments) {
            appointment.displayInfo();
        }
    }

    public void getAppointmentsByPatient(String patientId) {
        boolean found = false;

        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equals(patientId)) {
                appointment.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for this patient.");
        }
    }

}
