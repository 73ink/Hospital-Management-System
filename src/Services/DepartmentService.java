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

    public void editDepartment(String departmentId, Department updatedDepartment) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentId().equals(departmentId)) {
                departments.set(i, updatedDepartment);
                System.out.println("Department updated successfully.");
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public void removeDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                departments.remove(department);
                System.out.println("Department removed successfully.");
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public Department getDepartmentById(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    public void displayAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        for (Department department : departments) {
            department.displayInfo();
        }
    }

    public void assignDoctorToDepartment(String doctorId, String departmentId) {
        Department department = getDepartmentById(departmentId);

        if (department != null) {
            department.assignDoctor(doctorId);
            System.out.println("Doctor assigned to department successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }
}
