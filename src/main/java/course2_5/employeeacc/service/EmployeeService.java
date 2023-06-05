package course2_5.employeeacc.service;
import course2_5.employeeacc.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    String showAllEmployees();
}
