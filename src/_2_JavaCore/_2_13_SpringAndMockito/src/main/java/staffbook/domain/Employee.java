package staffbook.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Getter
public class Employee {
    private final String firstName;
    private final String lastName;
    @Setter
    private Department department;
    @Setter
    private int salary;

    public Employee(String firstName, String lastName, Department department, int salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
