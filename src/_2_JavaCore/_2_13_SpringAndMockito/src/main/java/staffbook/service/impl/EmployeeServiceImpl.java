package staffbook.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import staffbook.domain.Department;
import staffbook.domain.Employee;
import staffbook.exception.EmployeeAlreadyAddedException;
import staffbook.exception.EmployeeNotFoundException;
import staffbook.exception.EmployeeStorageIsFullException;
import staffbook.exception.ImpossibleDepartmentException;
import staffbook.exception.InvalidInputException;
import staffbook.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Value("${PAGES}")
    private int PAGES;
    @Getter
    private final Map<String, Employee> staffBook = new HashMap<>();

    public Employee create(Employee employee) {
        if (staffBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        if (staffBook.size() == PAGES) {
            throw new EmployeeStorageIsFullException("Книга заполнена");
        }
        staffBook.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee read(String firstName, String lastName) {
        Employee out = staffBook.get(firstName + " " + lastName);
        if (out == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return out;
    }

    public Employee delete(String firstName, String lastName) {
        Employee out = staffBook.remove(firstName + " " + lastName);
        if (out == null) {
            throw new EmployeeNotFoundException("Такого сотрудника и не было");
        }
        return out;
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        validateInput(firstName, lastName);
        return create(new Employee(firstName, lastName, getDepartmentByIndex(department), salary));
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        validateInput(firstName, lastName);
        return delete(firstName, lastName);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        validateInput(firstName, lastName);
        return read(firstName, lastName);
    }

    private static Department getDepartmentByIndex(int index) {
        Department[] departments = Department.values();
        if (index < 0 || index >= departments.length) {
            throw new ImpossibleDepartmentException("Индекс вне диапазона: " + index);
        }
        return departments[index];
    }

    private void validateInput(String firstName, String lastName) {
        if (!isAlpha(firstName) || !isAlpha(lastName)) {
            throw new InvalidInputException("Ввод содержит недопустимый символ");
        }
    }
}
