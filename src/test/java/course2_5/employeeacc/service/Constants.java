package course2_5.employeeacc.service;

import course2_5.employeeacc.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {


    public static final String F_NAME_1 = "Valera";
    public static final String L_NAME_1 = "Valerevich";

    public static final int WAGE_1 = 30000;
    public static final int DEPT_1 = 1;


    public static final String F_NAME_2 = "Denis";
    public static final String L_NAME_2 = "Denisovich";

    public static final int WAGE_2 = 50000;
    public static final int DEPT_2 = 2;

    public static final String F_NAME_3 = "Ivan";
    public static final String L_NAME_3 = "Ivanovich";

    public static final int WAGE_3 = 70000;
    public static final int DEPT_3 = 2;

    public static final String F_NAME_4 = "Petr";
    public static final String L_NAME_4 = "Petrovich";

    public static final int WAGE_4 = 80000;
    public static final int DEPT_4 = 3;

    public static final String F_NAME_5 = "LISHNIY";
    public static final String L_NAME_5 = "LISHNIY";

    public static final int WAGE_5 = 55555;
    public static final int DEPT_5 = 3;

    public static final String F_NAME_ALPHA = "3.14zdec";
    public static final String L_NAME_ALPHA = "Provek_*A";

    public static final int WAGE_ALPHA = 55555;
    public static final int DEPT_ALPHA = 3;

    public static final Employee EMPLOYEE_1 = new Employee(F_NAME_1,L_NAME_1,WAGE_1,DEPT_1);
    public static final Employee EMPLOYEE_2 = new Employee(F_NAME_2,L_NAME_2,WAGE_2,DEPT_2);
    public static final Employee EMPLOYEE_3 = new Employee(F_NAME_3,L_NAME_3,WAGE_3,DEPT_3);
    public static final Employee EMPLOYEE_4 = new Employee(F_NAME_4,L_NAME_4,WAGE_4,DEPT_4);
    public static final Employee EMPLOYEE_5 = new Employee(F_NAME_5,L_NAME_5,WAGE_5,DEPT_5);


    public static final ArrayList<Employee> EMPLOYEES_DEPT_2 =  new ArrayList<>(List.of(EMPLOYEE_2,EMPLOYEE_3));
    public static final ArrayList<Employee> EMPLOYEES_DEPT_3 =  new ArrayList<>(List.of(EMPLOYEE_4,EMPLOYEE_5));




}
