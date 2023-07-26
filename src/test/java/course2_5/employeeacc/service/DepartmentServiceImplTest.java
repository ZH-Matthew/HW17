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
        when(repository.maxWageDept(DEPT_1))
                .thenReturn(WAGE_1);
        assertEquals(WAGE_1, out.maxByDept(DEPT_1));

        verify(repository, times(1)).maxWageDept(DEPT_1);

    }

    @Test
    void minWageTest() {
        when(repository.minWageDept(DEPT_2))
                .thenReturn(WAGE_2);
        assertEquals(WAGE_2, out.minByDept(DEPT_2));
        verify(repository, times(1)).minWageDept(DEPT_2);
    }

    @Test
    void sumWageDept() {
        when(repository.sumWageDept(DEPT_2))
                .thenReturn(WAGE_2 + WAGE_3);
        assertEquals(WAGE_2 + WAGE_3, out.sumByDept(DEPT_2));
        verify(repository, times(1)).sumWageDept(DEPT_2);
    }


    @Test
    void allEmployeesFromDept() {
        when(repository.allEmployeesFromDept(DEPT_2))
                .thenReturn(EMPLOYEES_DEPT_2);
        assertEquals(EMPLOYEES_DEPT_2, out.employeesByDept(DEPT_2));
        verify(repository, times(1)).allEmployeesFromDept(DEPT_2);
    }

    @Test
    void allEmployeesByDept() {
        Map<Integer, List<Employee>> map = new HashMap<>();
        map.put(2, EMPLOYEES_DEPT_2);
        map.put(3, EMPLOYEES_DEPT_3);
        when(repository.allEmployeesByDept())
                .thenReturn(map);
        assertEquals(map, out.allByDept());
        verify(repository, times(1)).allEmployeesByDept();
    }
}