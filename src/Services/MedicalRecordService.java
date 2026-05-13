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
}
