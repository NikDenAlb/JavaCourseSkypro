package staffbook.service;

import staffbook.domain.Department;
import staffbook.domain.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentsService {
    Employee maxSalaryDepartmentAny(int departmentId);

    Employee minSalaryDepartmentAny(int departmentId);

    Collection<Employee> allByDep(int departmentId);

    Map<Department, List<Employee>> allByDep();
}
