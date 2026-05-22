package Main;

import Entity.*;
import Services.*;
import java.util.ArrayList;
import Utils.InputHandler;
import Utils.HelperUtils;

import java.time.LocalDate;

public class HospitalManagementApp {

    private static InputHandler input = new InputHandler();

    private static PatientService patientService = new PatientService();
    private static DoctorService doctorService = new DoctorService();
    private static NurseService nurseService = new NurseService();
    private static AppointmentService appointmentService = new AppointmentService();
    private static MedicalRecordService recordService = new MedicalRecordService();
    private static DepartmentService departmentService = new DepartmentService();

    public static void main(String[] args) {
        addSampleData();

        boolean running = true;

        while (running) {
            showMainMenu();
            int choice = input.getIntInput("Choose option: ", 1, 8);

            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    nurseMenu();
                    break;
                case 4:
                    appointmentMenu();
                    break;
                case 5:
                    medicalRecordMenu();
                    break;
                case 6:
                    departmentMenu();
                    break;
                case 7:
                    reportsMenu();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using Hospital Management System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("\n===== Hospital Management System =====");
        System.out.println("1. Patient Management");
        System.out.println("2. Doctor Management");
        System.out.println("3. Nurse Management");
        System.out.println("4. Appointment Management");
        System.out.println("5. Medical Records Management");
        System.out.println("6. Department Management");
        System.out.println("7. Reports and Statistics");
        System.out.println("8. Exit");
    }

    public static void patientMenu() {
        System.out.println("\n--- Patient Management ---");
        System.out.println("1. Register New Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Search Patient");
        System.out.println("4. Remove Patient");

        int choice = input.getIntInput("Choose option: ", 1, 4);

        switch (choice) {
            case 1:
                String firstName = input.getStringInput("First name: ");
                String lastName = input.getStringInput("Last name: ");
                String phone = input.getStringInput("Phone: ");
                String bloodGroup = input.getStringInput("Blood group: ");
                String email = input.getStringInput("Email: ");

                patientService.addPatient(firstName, lastName, phone, bloodGroup, email);
                break;

            case 2:
                patientService.displayAllPatients();
                break;

            case 3:
                String keyword = input.getStringInput("Enter patient name, ID, or phone: ");
                patientService.searchPatients(keyword);
                break;

            case 4:
                String id = input.getStringInput("Enter patient ID to remove: ");
                patientService.removePatient(id);
                break;
        }
    }

    public static void doctorMenu() {
        System.out.println("\n--- Doctor Management ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Search Doctor by Specialization");
        System.out.println("4. Assign Patient to Doctor");
        System.out.println("5. Remove Doctor");

        int choice = input.getIntInput("Choose option: ", 1, 5);

        switch (choice) {
            case 1:
                String name = input.getStringInput("Doctor full name: ");
                String specialization = input.getStringInput("Specialization: ");
                String phone = input.getStringInput("Phone: ");
                double fee = input.getDoubleInput("Consultation fee: ");

                doctorService.addDoctor(name, specialization, phone, fee);
                break;

            case 2:
                doctorService.displayAllDoctors();
                break;

            case 3:
                String spec = input.getStringInput("Enter specialization: ");
                doctorService.getDoctorsBySpecialization(spec);
                break;

            case 4:
                String doctorId = input.getStringInput("Doctor ID: ");
                String patientId = input.getStringInput("Patient ID: ");
                doctorService.assignPatient(doctorId, patientId);
                break;

            case 5:
                String removeId = input.getStringInput("Doctor ID to remove: ");
                doctorService.removeDoctor(removeId);
                break;
        }
    }

    public static void nurseMenu() {
        System.out.println("\n--- Nurse Management ---");
        System.out.println("1. View All Nurses");
        System.out.println("2. View Nurses by Department");
        System.out.println("3. View Nurses by Shift");

        int choice = input.getIntInput("Choose option: ", 1, 3);

        switch (choice) {
            case 1:
                nurseService.displayAllNurses();
                break;
            case 2:
                String departmentId = input.getStringInput("Department ID: ");
                nurseService.getNursesByDepartment(departmentId);
                break;
            case 3:
                String shift = input.getStringInput("Shift Morning/Evening/Night: ");
                nurseService.getNursesByShift(shift);
                break;
        }
    }

    public static void appointmentMenu() {
        System.out.println("\n--- Appointment Management ---");
        System.out.println("1. Schedule New Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. View Appointments by Patient");
        System.out.println("4. View Appointments by Doctor");
        System.out.println("5. Reschedule Appointment");
        System.out.println("6. Cancel Appointment");

        int choice = input.getIntInput("Choose option: ", 1, 6);

        switch (choice) {
            case 1:
                String patientId = input.getStringInput("Patient ID: ");
                String doctorId = input.getStringInput("Doctor ID: ");
                LocalDate date = input.getDateInput("Appointment date");
                String time = input.getStringInput("Appointment time: ");
                appointmentService.createAppointment(patientId, doctorId, date, time);
                break;

            case 2:
                appointmentService.displayAllAppointments();
                break;

            case 3:
                String pId = input.getStringInput("Patient ID: ");
                appointmentService.getAppointmentsByPatient(pId);
                break;

            case 4:
                String dId = input.getStringInput("Doctor ID: ");
                appointmentService.getAppointmentsByDoctor(dId);
                break;

            case 5:
                String appId = input.getStringInput("Appointment ID: ");
                LocalDate newDate = input.getDateInput("New date");
                appointmentService.rescheduleAppointment(appId, newDate);
                break;

            case 6:
                String cancelId = input.getStringInput("Appointment ID: ");
                appointmentService.cancelAppointment(cancelId);
                break;
        }
    }

    public static void medicalRecordMenu() {
        System.out.println("\n--- Medical Records Management ---");
        System.out.println("1. View All Records");
        System.out.println("2. View Records by Patient");
        System.out.println("3. View Records by Doctor");

        int choice = input.getIntInput("Choose option: ", 1, 3);

        switch (choice) {
            case 1:
                recordService.displayAllRecords();
                break;
            case 2:
                String patientId = input.getStringInput("Patient ID: ");
                recordService.getRecordsByPatientId(patientId);
                break;
            case 3:
                String doctorId = input.getStringInput("Doctor ID: ");
                recordService.getRecordsByDoctorId(doctorId);
                break;
        }
    }

    public static void departmentMenu() {
        System.out.println("\n--- Department Management ---");
        System.out.println("1. View All Departments");
        System.out.println("2. Assign Doctor to Department");
        System.out.println("3. Assign Nurse to Department");

        int choice = input.getIntInput("Choose option: ", 1, 3);

        switch (choice) {
            case 1:
                departmentService.displayAllDepartments();
                break;
            case 2:
                String doctorId = input.getStringInput("Doctor ID: ");
                String departmentId = input.getStringInput("Department ID: ");
                departmentService.assignDoctorToDepartment(doctorId, departmentId);
                break;
            case 3:
                String nurseId = input.getStringInput("Nurse ID: ");
                String depId = input.getStringInput("Department ID: ");
                departmentService.assignNurseToDepartment(nurseId, depId);
                break;
        }
    }

    public static void reportsMenu() {
        System.out.println("\n--- Reports and Statistics ---");
        System.out.println("Total Patients: " + patientService.getAll().size());
        System.out.println("Total Doctors: " + doctorService.getAll().size());
        System.out.println("Total Nurses: " + nurseService.getAll().size());
        System.out.println("Total Appointments: " + appointmentService.getAll().size());
        System.out.println("Total Medical Records: " + recordService.getAll().size());
        System.out.println("Total Departments: " + departmentService.getAll().size());
    }

    public static void addSampleData() {
        patientService.addPatient("Ahmed", "Al Balushi", "91234567", "O+", "ahmed@email.com");
        patientService.addPatient("Maha", "Al Harthy", "92345678", "A+", "maha@email.com");

        doctorService.addDoctor("Ali Al Siyabi", "Cardiology", "91112222", 15.0);
        doctorService.addDoctor("Sara Al Kindi", "Neurology", "93334444", 20.0);

        Nurse nurse1 = new Nurse(
                "PERS-N1",
                "Huda",
                "Al Riyami",
                LocalDate.of(1995, 3, 12),
                "Female",
                "95556666",
                "huda@email.com",
                "Muscat",
                "NUR-1",
                "DEP-1",
                "Morning",
                "Diploma Nursing",
                new ArrayList()
        );

        nurseService.addNurse(nurse1);

        Department department1 = new Department(
                "DEP-1",
                "Cardiology",
                "DOC-1",
                new ArrayList<>(),
                new ArrayList<>(),
                30,
                20
        );

        departmentService.addDepartment(department1);

        appointmentService.createAppointment("PAT-1", "DOC-1", LocalDate.now(), "10:00 AM");

        MedicalRecord record1 = new MedicalRecord(
                "REC-1",
                "PAT-1",
                "DOC-1",
                LocalDate.now(),
                "General checkup",
                "Vitamins",
                "Normal",
                "Patient is stable"
        );

        recordService.addRecord(record1);
    }
}