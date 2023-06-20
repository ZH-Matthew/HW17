package course2_5.employeeacc.controller;

import course2_5.employeeacc.Employee;
import course2_5.employeeacc.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "Привет, я программа для учета сотрудников!";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int wage,@RequestParam int department) {
        return service.addEmployee(firstName, lastName, wage, department);
    }


    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }


    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }


    @GetMapping("/all")
    public Map<String,Employee> showAll() {
        return service.showAllEmployees();
    }

    @GetMapping("/departments/max-salary")
    public Employee findEmployeeMaxWage(@RequestParam int departmentId){
        return service.maxWageDept(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee findEmployeeMinWage(@RequestParam int departmentId){
        return service.minWageDept(departmentId);
    }

    @GetMapping("/departments/all")
    public List<Employee> allEmployeesFromDept(@RequestParam int departmentId){
        return service.allEmployeesFromDept(departmentId);
    }
    @GetMapping("/departments/allEmployee")
    public List<Employee> allEmployeesByDept(){
        return service.allEmployeesByDept();
    }







}
