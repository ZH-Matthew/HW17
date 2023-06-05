package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import course2_5.employeeacc.exception.EmployeeAlreadyAddedException;
import course2_5.employeeacc.exception.EmployeeNotFoundException;
import course2_5.employeeacc.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Валера", "Подайпатроны"),
            new Employee("Наталья", "Морскаяпехота"),
            new Employee("Ибрагим", "Кандибобирович")
    ));

    final int limitEmployees = 5;


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() < limitEmployees) {
            Employee newEmp = new Employee(firstName, lastName);
            if (employees.contains(newEmp)) {
                throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
            } else {
                employees.add(newEmp);
                return newEmp;
            }
        } else {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee existEmp = new Employee(firstName, lastName);
        if (employees.contains(existEmp)) {
            employees.remove(existEmp);
            return existEmp;
        } else {
            throw new EmployeeNotFoundException("удаляемый сотрудник не найден");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee verEmp = new Employee(firstName, lastName);
        if (employees.contains(verEmp)) {
            return verEmp;
        } else {
            throw new EmployeeNotFoundException("сотрудник не найден!");
        }
    }

    @Override
    public String showAllEmployees() {
        String text = " ";
        for (Employee employee : employees) {
            text = text.concat(employee.toString());
        }
        return text;
    }
}
