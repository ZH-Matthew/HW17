package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import course2_5.employeeacc.exception.EmployeeAlreadyAddedException;
import course2_5.employeeacc.exception.EmployeeNotFoundException;
import course2_5.employeeacc.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String,Employee> employeesMap = new HashMap<>();

    final int limitEmployees = 5;


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeesMap.size() < limitEmployees) {
            Employee newEmp = new Employee(firstName, lastName);
            String key = firstName+lastName;
            if (employeesMap.containsKey(key)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                employeesMap.put(key,newEmp);
                return newEmp;
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee existEmp = new Employee(firstName, lastName);
        String key = firstName+lastName;
        if (employeesMap.containsKey(key)) {
            employeesMap.remove(key);
            return existEmp;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee verEmp = new Employee(firstName, lastName);
        String key = firstName+lastName;
        if (employeesMap.containsKey(key)) {
            return verEmp;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Map<String, Employee> showAllEmployees() {
        return new HashMap<>(employeesMap);
    }


}
