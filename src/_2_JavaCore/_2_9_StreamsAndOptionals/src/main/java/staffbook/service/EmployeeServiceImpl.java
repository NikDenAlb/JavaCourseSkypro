package staffbook.service;

import org.springframework.stereotype.Service;
import staffbook.domain.Employee;
import staffbook.exception.EmployeeAlreadyAddedException;
import staffbook.exception.EmployeeNotFoundException;
import staffbook.exception.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAXPAGES = 3;
    private final Map<String, Employee> staffBook = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee addEmployee = new Employee(firstName, lastName);
        if (staffBook.containsKey(addEmployee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        if (staffBook.size() == MAXPAGES) {
            throw new EmployeeStorageIsFullException("Книга заполнена");
        }
        staffBook.put(addEmployee.getFullName(), addEmployee);
        return addEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee deleteEmployee = new Employee(firstName, lastName);
        if (staffBook.remove(deleteEmployee.getFullName()) == null) {
            throw new EmployeeNotFoundException("Такого сотрудника и не было");
        }
        return deleteEmployee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName, lastName);
        Employee out = staffBook.get(findEmployee.getFullName());
        if (out == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return out;
    }

    @Override
    public Collection<Employee> getStaffBook() {
        return Collections.unmodifiableCollection(staffBook.values());
    }
}