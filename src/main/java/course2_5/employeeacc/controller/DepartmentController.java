package course2_5.employeeacc.controller;

import course2_5.employeeacc.Employee;
import course2_5.employeeacc.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService serviceDept;

    public DepartmentController(DepartmentService serviceDept) {
        this.serviceDept = serviceDept;
    }

    @GetMapping("/{id}/salary/max")
    public Integer findEmployeeMaxWageDept(@PathVariable int id) {
        return serviceDept.maxByDept(id);
    }

    @GetMapping("/{id}/salary/min")
    public Integer findEmployeeMinWageDept(@PathVariable int id) {
        return serviceDept.minByDept(id);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer findEmployeeSumWageDept(@PathVariable int id) {
        return serviceDept.sumByDept(id);
    }

    @GetMapping("{id}/employees")
    public List<Employee> allEmployeesFromDept(@PathVariable int id) {
        return serviceDept.employeesByDept(id);
    }


    @GetMapping("/employees")
    public Map<Integer, List<Employee>> allEmployeesByDept() {
        return serviceDept.allByDept();
    }


}
