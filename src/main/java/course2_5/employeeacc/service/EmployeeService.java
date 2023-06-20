package course2_5.employeeacc.service;
import course2_5.employeeacc.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int wage, int department);

    String removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String,Employee> showAllEmployees();

    Employee maxWageDept(int department);

    Employee minWageDept(int department);

    List<Employee> allEmployeesFromDept(int department);

    List<Employee>  allEmployeesByDept();
}
