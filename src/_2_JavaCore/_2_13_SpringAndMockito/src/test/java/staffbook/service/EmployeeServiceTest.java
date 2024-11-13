package staffbook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import staffbook.domain.Employee;
import staffbook.exception.EmployeeAlreadyAddedException;
import staffbook.exception.EmployeeNotFoundException;
import staffbook.exception.EmployeeStorageIsFullException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static staffbook.service.Constants.EMPLOYEE_LIST;
import static staffbook.service.Constants.employee1;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Value("${PAGES}")
    int PAGES;

    static Stream<Arguments> arguments() {
        return Stream.of(Arguments.of("Namea", "Surnamea", 0, 1000),
                Arguments.of("Nameb", "Surnameb", 2, 2000),
                Arguments.of("Namec", "Surnamec", 3, 3000));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void add(String firstname, String lastname, int department, int salary) {
        Employee actual = employeeService.add(firstname, lastname, department, salary);
        assertNotNull(actual);
        assertEquals(firstname, actual.getFirstName());
        assertEquals(lastname, actual.getLastName());
        assertEquals(department, actual.getDepartment().ordinal());
        assertEquals(salary, actual.getSalary());

        assertTrue(employeeService.getStaffBook().containsValue(actual));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void addAlreadyHas(String firstname, String lastname, int department, int salary) {
        employeeService.add(firstname, lastname, department, salary);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(firstname, lastname, department, salary));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void addToFull(String firstname, String lastname, int department, int salary) {

        if (employeeService.getStaffBook().isEmpty()) {
            for (int i = 0; i < PAGES; i++) {
                employeeService.add("name" + (char) ((int) 'a' + i), "surname" + (char) ((int) 'a' + i), 0, 1);
            }
        }
        assertThrows(EmployeeStorageIsFullException.class, () ->
                employeeService.add(firstname + (char) ((int) 'a' + PAGES), lastname + (char) ((int) 'a' + PAGES), department, salary));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void remove(String firstname, String lastname, int department, int salary) {

        employeeService.add(firstname, lastname, department, salary);
        Employee actual = employeeService.remove(firstname, lastname);
        assertNotNull(actual);
        assertEquals(firstname, actual.getFirstName());
        assertEquals(lastname, actual.getLastName());
        assertEquals(department, actual.getDepartment().ordinal());
        assertEquals(salary, actual.getSalary());

        assertFalse(employeeService.getStaffBook().containsValue(actual));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void removeNotHere(String firstname, String lastname) {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(firstname, lastname));
    }

    @Test
    void find() {
        EMPLOYEE_LIST.forEach(e -> employeeService.add(e.getFirstName(), e.getLastName(), e.getDepartment().ordinal(), e.getSalary()));
        assertEquals(employee1, employeeService.find(employee1.getFirstName(),employee1.getLastName()));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("Меня", "Здесьнет"));
    }
}
