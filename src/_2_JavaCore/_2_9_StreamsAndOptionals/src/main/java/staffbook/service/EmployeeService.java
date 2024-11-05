package staffbook.service;

import staffbook.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Collection<Employee> getStaffBook();

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}