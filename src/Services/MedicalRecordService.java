package Services;

import Entity.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService {

    private List<MedicalRecord> records = new ArrayList<>();

    public void addRecord(MedicalRecord record) {
        records.add(record);
        System.out.println("Medical record added successfully.");
    }

    public void editRecord(String recordId, MedicalRecord updatedRecord) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getRecordId().equals(recordId)) {
                records.set(i, updatedRecord);
                System.out.println("Medical record updated successfully.");
                return;
            }
        }
        System.out.println("Medical record not found.");
    }

    public void removeRecord(String recordId) {
        for (MedicalRecord record : records) {
            if (record.getRecordId().equals(recordId)) {
                records.remove(record);
                System.out.println("Medical record removed successfully.");
                return;
            }
        }
        System.out.println("Medical record not found.");
    }

    public MedicalRecord getRecordById(String recordId) {
        for (MedicalRecord record : records) {
            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        return null;
    }

    public void displayAllRecords() {
        if (records.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        for (MedicalRecord record : records) {
            record.displayInfo();
        }
    }

    public void getRecordsByPatientId(String patientId) {
        boolean found = false;

        for (MedicalRecord record : records) {
            if (record.getPatientId().equals(patientId)) {
                record.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found for this patient.");
        }
    }

    public void getRecordsByDoctorId(String doctorId) {
        boolean found = false;

        for (MedicalRecord record : records) {
            if (record.getDoctorId().equals(doctorId)) {
                record.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found for this doctor.");
        }
    }

    public void displayPatientHistory(String patientId) {
        System.out.println("Medical History for Patient ID: " + patientId);
        getRecordsByPatientId(patientId);
    }

    public List<MedicalRecord> getRecords() {
        return records;
    }


}
