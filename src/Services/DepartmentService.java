package Services;
import Entity.Department;
import java.util.ArrayList;
import java.util.List;
public class DepartmentService {

    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department added successfully.");
    }
}
