package staffbook.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import staffbook.domain.Department;
import staffbook.domain.Employee;
import staffbook.exception.ImpossibleDepartmentException;
import staffbook.repository.EmployeeBook;
import staffbook.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeBook employeeBook;

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        return employeeBook.create(new Employee(firstName, lastName, getDepartmentByIndex(department), salary));
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return employeeBook.delete(firstName, lastName);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return employeeBook.read(firstName, lastName);
    }

    @Override
    public Collection<Employee> getStaffBook() {
        return Collections.unmodifiableCollection(employeeBook.getStaffBook().values());
    }

    private static Department getDepartmentByIndex(int index) {
        Department[] departments = Department.values();
        if (index < 0 || index >= departments.length) {
            throw new ImpossibleDepartmentException("Индекс вне диапазона: " + index);
        }
        return departments[index];
    }
}
