package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int wage, int department);

    Employee removeEmployee(String firstName, String lastName, int wage, int department);

    Employee findEmployee(String firstName, String lastName, int wage, int department);

    Collection<Employee> showAllEmployees();

    Integer maxWageDept(int department);

    Integer minWageDept(int department);

    Integer sumWageDept(int department);

    List<Employee> allEmployeesFromDept(int department);

    Map<Integer, List<Employee>> allEmployeesByDept();
}
