package course2_5.employeeacc;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private final int wage;
    private final int department;


    public Employee(String firstName, String lastName, int wage, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wage = wage;
        this.department = department;
    }

    public int getWage() {
        return wage;
    }

    public int getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return wage == employee.wage && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, wage, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wage=" + wage +
                ", department=" + department +
                '}';
    }
}

