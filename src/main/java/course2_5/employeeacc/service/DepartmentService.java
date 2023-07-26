package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Integer maxByDept(int department);


    Integer minByDept(int department);


    Integer sumByDept(int department);


    List<Employee> employeesByDept(int department);


    Map<Integer, List<Employee>> allByDept();
}
