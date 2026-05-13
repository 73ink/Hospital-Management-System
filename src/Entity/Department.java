package Entity;
import java.util.ArrayList;
import java.util.List;
public class Department {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors;
    private List<String> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, String headDoctorId, List<String> doctors, List<String> nurses, int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.doctors = doctors;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }

}
