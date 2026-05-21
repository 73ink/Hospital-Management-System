package Interfaces;

import Entity.Appointment;
import java.time.LocalDate;

public class Appointable {
    void scheduleAppointment(Appointment appointment);
    void cancelAppointment(String appointmentId);
    void rescheduleAppointment(String appointmentId, LocalDate newDate);
}
