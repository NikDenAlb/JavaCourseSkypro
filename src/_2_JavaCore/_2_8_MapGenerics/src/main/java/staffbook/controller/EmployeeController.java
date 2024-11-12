package staffbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import staffbook.domain.Employee;
import staffbook.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/book")
    public Collection<Employee> book() {
        return employeeService.getStaffBook();
    }
}
