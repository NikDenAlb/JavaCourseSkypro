package staffbook.service;

import org.springframework.stereotype.Service;
import staffbook.domain.Employee;
import staffbook.exception.EmployeeAlreadyAddedException;
import staffbook.exception.EmployeeNotFoundException;
import staffbook.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAXPAGES = 3;
    private final List<Employee> staffBook = new ArrayList<>();

    @Override
    public Employee add(String firstname, String lastname) {
        Employee addEmployee = new Employee(firstname, lastname);
        if (staffBook.contains(addEmployee)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        if (staffBook.size() == MAXPAGES) {
            throw new EmployeeStorageIsFullException("Книга заполнена");
        }
        staffBook.add(addEmployee);
        return addEmployee;
    }

    @Override
    public Employee remove(String firstname, String lastname) {
        Employee deleteEmployee = new Employee(firstname, lastname);
        if (!staffBook.remove(deleteEmployee)) {
            throw new EmployeeNotFoundException("Такого сотрудника и не было");
        }
        return deleteEmployee;
    }

    @Override
    public int find(String firstname, String lastname) {
        Employee findEmployee = new Employee(firstname, lastname);
        if (!staffBook.contains(findEmployee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return staffBook.indexOf(findEmployee);
    }

    @Override
    public List<Employee> getStaffBook() {
        return Collections.unmodifiableList(staffBook);
    }
}
