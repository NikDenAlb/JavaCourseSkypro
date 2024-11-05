package staffbook.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import staffbook.domain.Department;
import staffbook.domain.Employee;
import staffbook.exception.DepartmentWithoutEmployeesException;
import staffbook.exception.ImpossibleDepartmentException;
import staffbook.repository.EmployeeBook;
import staffbook.service.DepartmentsService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentsService {
    private final EmployeeBook employeeBook;

    @Override
    public Employee maxSalaryDepartmentAny(int departmentId) {
        return employeeBook.getStaffBook().values().stream()
                .filter(e -> e.getDepartment().ordinal() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentWithoutEmployeesException("В отделе нет работников"));
    }

    @Override
    public Employee minSalaryDepartmentAny(int departmentId) {
        return employeeBook.getStaffBook().values().stream()
                .filter(e -> e.getDepartment().ordinal() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentWithoutEmployeesException("В отделе нет работников"));
    }

    @Override
    public Collection<Employee> allByDep(int departmentId) {
        return employeeBook.getStaffBook().values().stream()
                .filter(e -> e.getDepartment() == getDepartmentByIndex(departmentId))
                .toList();
    }

    @Override
    public Map<Department, List<Employee>> allByDep() {
        return employeeBook.getStaffBook().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    private static Department getDepartmentByIndex(int index) {
        Department[] departments = Department.values();
        if (index < 0 || index >= departments.length) {
            throw new ImpossibleDepartmentException("Индекс вне диапазона: " + index);
        }
        return departments[index];
    }
}
