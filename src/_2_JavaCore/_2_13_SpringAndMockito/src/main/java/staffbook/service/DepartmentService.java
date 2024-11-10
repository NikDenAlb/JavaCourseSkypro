package staffbook.service;

import staffbook.domain.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Collection<Employee> getEmployeesByDepartment(int id);

    int getSalarySumDepartment(int id);

    int getSalaryMaxDepartment(int id);

    int getSalaryMinDepartment(int id);

    Map<Integer, List<Employee>> getEmployeesByDepartments();
}
