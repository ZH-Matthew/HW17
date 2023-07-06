package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import course2_5.employeeacc.exception.EmployeeAlreadyAddedException;
import course2_5.employeeacc.exception.EmployeeInvalidCharactersInNameException;
import course2_5.employeeacc.exception.EmployeeNotFoundException;
import course2_5.employeeacc.exception.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    final int limitEmployees = 5;


    @Override
    public Employee addEmployee(String firstName, String lastName, int wage, int department) {
        if (employees.size() < limitEmployees) {
            if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
                String fName = StringUtils.capitalize(firstName);
                String lName = StringUtils.capitalize(lastName);
                Employee newEmp = new Employee(fName, lName, wage, department);
                if (employees.contains(newEmp)) {
                    throw new EmployeeAlreadyAddedException();
                } else {
                    employees.add(newEmp);
                    return newEmp;
                }
            } else {
                throw new EmployeeInvalidCharactersInNameException();
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int wage, int department) {
        Employee existEmp = new Employee(firstName, lastName, wage, department);
        if (employees.contains(existEmp)) {
            employees.remove(existEmp);
            return existEmp;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int wage, int department) {
        Employee verEmp = new Employee(firstName, lastName, wage, department);
        if (employees.contains(verEmp)) {
            return verEmp;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> showAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public Employee maxWageDept(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getWage))
                .orElseThrow();
    }

    @Override
    public Employee minWageDept(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getWage))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeesFromDept(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesByDept() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.toList()));
    }
}


