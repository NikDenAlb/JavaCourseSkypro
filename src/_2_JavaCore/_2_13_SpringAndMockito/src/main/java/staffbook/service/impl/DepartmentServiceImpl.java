package staffbook.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import staffbook.domain.Department;
import staffbook.domain.Employee;
import staffbook.exception.DepartmentWithoutEmployeesException;
import staffbook.exception.ImpossibleDepartmentException;
import staffbook.service.DepartmentService;
import staffbook.service.EmployeeService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    @Override
    public Collection<Employee> getEmployeesByDepartment(int id) {
        Department department = checkId(id);
        return employeeService.getStaffBook().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    @Override
    public int getSalarySumDepartment(int id) {
        return getEmployeesByDepartment(id).stream()
                .mapToInt(Employee::getSalary).sum();
    }

    @Override
    public int getSalaryMaxDepartment(int id) {
        return getEmployeesByDepartment(id).stream()
                .mapToInt(Employee::getSalary)
                .max().orElseThrow(()-> new DepartmentWithoutEmployeesException("No Employees in department"));
    }

    @Override
    public int getSalaryMinDepartment(int id) {
        checkId(id);
        return getEmployeesByDepartment(id).stream()
                .mapToInt(Employee::getSalary)
                .min().orElseThrow(()-> new DepartmentWithoutEmployeesException("No Employees in department"));
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartments() {
        return employeeService.getStaffBook().stream()
                .collect(Collectors.groupingBy(e->e.getDepartment().ordinal()));
    }

    private static Department checkId(int id) {
        return Arrays.stream(Department.values())
                .filter(p -> p.ordinal() == id)
                .findAny()
                .orElseThrow(() -> new ImpossibleDepartmentException("Департамента с таким номером не существует"));
    }
}
