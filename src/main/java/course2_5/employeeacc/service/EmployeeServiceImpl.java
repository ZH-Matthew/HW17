package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import course2_5.employeeacc.exception.EmployeeAlreadyAddedException;
import course2_5.employeeacc.exception.EmployeeNotFoundException;
import course2_5.employeeacc.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employeesMap = new HashMap<>();

    final int limitEmployees = 5;


    @Override
    public Employee addEmployee(String firstName, String lastName, int wage, int department) {
        if (employeesMap.size() < limitEmployees) {
            Employee newEmp = new Employee(firstName, lastName, wage, department);
            String key = firstName + lastName;
            if (employeesMap.containsKey(key)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                employeesMap.put(key, newEmp);
                return newEmp;
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (employeesMap.containsKey(key)) {
            employeesMap.remove(key);
            return "Сотрдуник " + firstName + " " + lastName + " удалён";
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (employeesMap.containsKey(key)) {
            return employeesMap.get(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Map<String, Employee> showAllEmployees() {
        return new HashMap<>(employeesMap);
    }

    @Override
    public Employee maxWageDept(int department){
        return employeesMap.values().stream()
                .filter(e -> e.getDepartment()==department)
                .max(Comparator.comparingInt(Employee::getWage))
                .orElseThrow();
    }

    @Override
    public Employee minWageDept(int department){
        return employeesMap.values().stream()
                .filter(e -> e.getDepartment()==department)
                .min(Comparator.comparingInt(Employee::getWage))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeesFromDept(int department){
        return employeesMap.values().stream()
                .filter(e -> e.getDepartment()==department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee>  allEmployeesByDept(){
        return employeesMap.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}


