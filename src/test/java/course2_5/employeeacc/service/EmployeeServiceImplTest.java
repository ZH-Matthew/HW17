package course2_5.employeeacc.service;

import course2_5.employeeacc.exception.EmployeeAlreadyAddedException;
import course2_5.employeeacc.exception.EmployeeInvalidCharactersInNameException;
import course2_5.employeeacc.exception.EmployeeNotFoundException;
import course2_5.employeeacc.exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;

import static course2_5.employeeacc.service.Constants.*;
import static course2_5.employeeacc.service.Constants.L_NAME_ALPHA;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    EmployeeService service = new EmployeeServiceImpl();

    void addByLimitException() {
        service.addEmployee(F_NAME_1, L_NAME_1, WAGE_1, DEPT_1);
        service.addEmployee(F_NAME_2, L_NAME_2, WAGE_2, DEPT_2);
        service.addEmployee(F_NAME_3, L_NAME_3, WAGE_3, DEPT_3);
        service.addEmployee(F_NAME_4, L_NAME_4, WAGE_4, DEPT_4);
        service.addEmployee(F_NAME_5, L_NAME_5, WAGE_5, DEPT_5);
    }

    void doubleAdd(){
        service.addEmployee(F_NAME_1, L_NAME_1, WAGE_1, DEPT_1);
        service.addEmployee(F_NAME_1, L_NAME_1, WAGE_1, DEPT_1);
    }

    @Test
    void addEmployeeLimitException() {
        assertThrows(EmployeeStorageIsFullException.class, this::addByLimitException);
    }

    @Test
    void addEmployeeInvalidCharactersException() {
        assertThrows(EmployeeInvalidCharactersInNameException.class, ()-> service.addEmployee(F_NAME_ALPHA, L_NAME_ALPHA, WAGE_ALPHA, DEPT_ALPHA));
    }

    @Test
    void addEmployeeAlreadyAddedException() {
        assertThrows(EmployeeAlreadyAddedException.class, this::doubleAdd);
    }

    @Test
    void addEmployeeTest() {
        assertEquals(EMPLOYEE_1, service.addEmployee(F_NAME_1,L_NAME_1,WAGE_1,DEPT_1));
    }


    @Test
    void removeEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, ()-> service.removeEmployee(F_NAME_ALPHA, L_NAME_ALPHA, WAGE_ALPHA, DEPT_ALPHA));
    }

    @Test
    void removeEmployeeTest() {
        service.addEmployee(F_NAME_1,L_NAME_1,WAGE_1,DEPT_1);
        assertEquals(EMPLOYEE_1, service.removeEmployee(F_NAME_1,L_NAME_1,WAGE_1,DEPT_1));
    }

    @Test
    void findEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, ()-> service.findEmployee(F_NAME_ALPHA, L_NAME_ALPHA, WAGE_ALPHA, DEPT_ALPHA));
    }

    @Test
    void findEmployeeTest() {
        service.addEmployee(F_NAME_1, L_NAME_1, WAGE_1, DEPT_1);
        assertEquals(EMPLOYEE_1, service.findEmployee(F_NAME_1, L_NAME_1, WAGE_1, DEPT_1));
    }
}