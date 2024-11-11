package staffbook.service;

import staffbook.domain.Employee;

import java.util.Map;

public interface EmployeeService {

    Map<String, Employee> getStaffBook();

    Employee add(String firstName, String lastName, int department, int salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}
