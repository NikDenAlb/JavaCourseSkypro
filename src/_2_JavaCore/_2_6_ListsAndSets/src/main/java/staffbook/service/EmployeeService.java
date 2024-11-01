package staffbook.service;

import staffbook.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    List<Employee> getStaffBook();

    Employee remove(String firstName, String lastName);

    int find(String firstName, String lastName);
}