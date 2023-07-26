package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService data;

    public DepartmentServiceImpl(EmployeeService data) {
        this.data = data;
    }

    @Override
    public Integer maxWageDept(int department) {
        return data.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getWage)
                .max()
                .getAsInt();
    }

    @Override
    public Integer minWageDept(int department) {
        return data.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getWage)
                .min()
                .getAsInt();
    }

    @Override
    public Integer sumWageDept(int department) {
        return data.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getWage)
                .sum();
    }

    @Override
    public List<Employee> allEmployeesFromDept(int department) {
        return data.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesByDept() {
        return data.getEmployees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.toList()));
    }
}
