package staffbook.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import staffbook.domain.Employee;
import staffbook.exception.EmployeeAlreadyAddedException;
import staffbook.exception.EmployeeNotFoundException;
import staffbook.exception.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
@RequiredArgsConstructor
public class EmployeeBook {
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
}
