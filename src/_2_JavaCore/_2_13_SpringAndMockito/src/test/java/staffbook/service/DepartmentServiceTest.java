package staffbook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import staffbook.service.impl.DepartmentServiceImpl;
import staffbook.service.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static staffbook.service.Constants.EMPLOYEE_LIST_MAX_ID;
import static staffbook.service.Constants.EMPLOYEE_LIST_MIN_ID;
import static staffbook.service.Constants.EMPLOYEE_MAP;
import static staffbook.service.Constants.MAX_DEP_ID;
import static staffbook.service.Constants.MIN_DEP_ID;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    void getEmployeesByDepartment() {
        when(employeeServiceMock.getStaffBook()).thenReturn(EMPLOYEE_MAP);

        assertEquals(EMPLOYEE_LIST_MAX_ID, out.getEmployeesByDepartment(MAX_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MIN_ID, out.getEmployeesByDepartment(MIN_DEP_ID));
    }

    @Test
    void getSalarySumDepartment() {
    }

    @Test
    void getSalaryMaxDepartment() {
    }

    @Test
    void getSalaryMinDepartment() {
    }

    @Test
    void getEmployeesByDepartments() {
    }
}