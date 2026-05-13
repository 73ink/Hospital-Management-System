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
}
