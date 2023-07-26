package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static course2_5.employeeacc.service.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl repository;

    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    void maxWageTest() {
        when(repository.getEmployees())
                .thenReturn(EMPLOYEES_DEPT_2);
        assertEquals(WAGE_3, out.maxWageDept(DEPT_2));

        verify(repository, times(1)).getEmployees();

    }

    @Test
    void minWageTest() {
        when(repository.getEmployees())
                .thenReturn(EMPLOYEES_DEPT_2);
        assertEquals(WAGE_2, out.minWageDept(DEPT_2));
        verify(repository, times(1)).getEmployees();
    }

    @Test
    void sumWageDept() {
        when(repository.getEmployees())
                .thenReturn(EMPLOYEES_DEPT_2);
        assertEquals(WAGE_2 + WAGE_3, out.sumWageDept(DEPT_2));
        verify(repository, times(1)).getEmployees();
    }


    @Test
    void allEmployeesFromDept() {
        when(repository.getEmployees())
                .thenReturn(EMPLOYEES_DEPT_2);
        assertEquals(EMPLOYEES_DEPT_2, out.allEmployeesFromDept(DEPT_2));
        verify(repository, times(1)).getEmployees();
    }

    @Test
    void allEmployeesByDept() {
        Map<Integer, List<Employee>> map = new HashMap<>();
        map.put(1, EMPLOYEES_DEPT_1);
        map.put(2, EMPLOYEES_DEPT_2);
        map.put(3, EMPLOYEES_DEPT_3);
        when(repository.getEmployees())
                .thenReturn(ALL_EMPLOYEES_BY_DEPT);
        assertEquals(map, out.allEmployeesByDept());
        verify(repository, times(1)).getEmployees();
    }
}