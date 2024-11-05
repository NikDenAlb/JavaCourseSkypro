package staffbook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import staffbook.domain.Department;
import staffbook.domain.Employee;
import staffbook.service.DepartmentsService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryDepartmentAny(@RequestParam("departmentId") int departmentId) {
        return departmentsService.maxSalaryDepartmentAny(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryDepartmentAny(@RequestParam("departmentId") int departmentId) {
        return departmentsService.minSalaryDepartmentAny(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> allByDep(@RequestParam("departmentId") int departmentId) {
        return departmentsService.allByDep(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Department, List<Employee>> allByDep() {
        return departmentsService.allByDep();
    }
}
