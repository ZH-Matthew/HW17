package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    EmployeeServiceImpl data = new EmployeeServiceImpl();

    @Override
    public Integer maxByDept(int department) {
        return data.maxWageDept(department);
    }

    @Override
    public Integer minByDept(int department) {
        return data.minWageDept(department);
    }

    @Override
    public Integer sumByDept(int department) {
        return data.sumWageDept(department);
    }

    @Override
    public List<Employee> employeesByDept(int department) {
        return data.allEmployeesFromDept(department);
    }

    @Override
    public Map<Integer, List<Employee>> allByDept() {
        return data.allEmployeesByDept();
    }


}
