package staffbook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import staffbook.domain.Employee;
import staffbook.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesByDepartment(@PathVariable("id") int id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/{id}//salary/sum")
    public int getSalarySumDepartment(@PathVariable("id") int id) {
        return departmentService.getSalarySumDepartment(id);
    }

    @GetMapping("/{id}//salary/max")
    public int getSalaryMaxDepartment(@PathVariable("id") int id) {
        return departmentService.getSalaryMaxDepartment(id);
    }

    @GetMapping("/{id}//salary/min")
    public int getSalaryMinDepartment(@PathVariable("id") int id) {
        return departmentService.getSalaryMinDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesByDepartments() {
        return departmentService.getEmployeesByDepartments();
    }
}
