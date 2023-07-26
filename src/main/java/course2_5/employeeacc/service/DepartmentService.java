package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Integer maxWageDept(int department);

    //мин зп по отделу
    Integer minWageDept(int department);

    //сумма зп по отделу
    Integer sumWageDept(int department);

    //список сотрудников по департаменту
    List<Employee> allEmployeesFromDept(int department);

    //возвращает сотрудников, сгруппированых по отделам
    Map<Integer, List<Employee>> allEmployeesByDept();
}
