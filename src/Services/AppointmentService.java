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

    public void getAppointmentsByDoctor(String doctorId) {
        boolean found = false;

        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId().equals(doctorId)) {
                appointment.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for this doctor.");
        }
    }

    public void getAppointmentsByDate(LocalDate date) {
        boolean found = false;

        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentDate().equals(date)) {
                appointment.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found on this date.");
        }
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        Appointment appointment = getAppointmentById(appointmentId);

        if (appointment != null) {
            appointment.reschedule(newDate, newTime);
            System.out.println("Appointment rescheduled successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void cancelAppointment(String appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);

        if (appointment != null) {
            appointment.cancel();
            System.out.println("Appointment cancelled successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
// overloading
    // Task 2.3: Overloaded createAppointment methods

    public void createAppointment(String patientId, String doctorId, LocalDate date) {
        Appointment appointment = new Appointment(
                "APP-" + (appointments.size() + 1),
                patientId,
                doctorId,
                date,
                "Not specified",
                "Scheduled",
                "Not specified",
                "No notes"
        );

        appointments.add(appointment);
        System.out.println("Appointment created with date only.");
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        Appointment appointment = new Appointment(
                "APP-" + (appointments.size() + 1),
                patientId,
                doctorId,
                date,
                time,
                "Scheduled",
                "Not specified",
                "No notes"
        );

        appointments.add(appointment);
        System.out.println("Appointment created with date and time.");
    }

    public void createAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment object added successfully.");
    }

    // Task 2.3: Overloaded rescheduleAppointment methods

    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        Appointment appointment = getAppointmentById(appointmentId);

        if (appointment != null) {
            appointment.reschedule(newDate, appointment.getAppointmentTime());
            System.out.println("Appointment rescheduled with new date.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment != null) {
            appointment.reschedule(newDate, newTime);
            appointment.setNotes(reason);
            System.out.println("Appointment rescheduled. Reason added.");
        } else {
            System.out.println("Appointment is missing.");
        }
    }

    // Task 2.3: Overloaded displayAppointments methods

    public void displayAppointments(LocalDate date) {
        getAppointmentsByDate(date);
    }

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        boolean found = false;

        for (Appointment appointment : appointments) {
            boolean sameDoctor = appointment.getDoctorId().equals(doctorId);
            boolean afterStart = appointment.getAppointmentDate().isEqual(startDate) ||
                    appointment.getAppointmentDate().isAfter(startDate);
            boolean beforeEnd = appointment.getAppointmentDate().isEqual(endDate) ||
                    appointment.getAppointmentDate().isBefore(endDate);

            if (sameDoctor && afterStart && beforeEnd) {
                appointment.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for this doctor in this date range.");
        }
    }

}
