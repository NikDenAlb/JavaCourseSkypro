package staffbook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import staffbook.exception.DepartmentWithoutEmployeesException;
import staffbook.exception.ImpossibleDepartmentException;
import staffbook.service.impl.DepartmentServiceImpl;
import staffbook.service.impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static staffbook.service.Constants.EMPLOYEE_LIST_MAX_ID;
import static staffbook.service.Constants.EMPLOYEE_LIST_MAX_ID_SALARY_MAX;
import static staffbook.service.Constants.EMPLOYEE_LIST_MAX_ID_SALARY_MIN;
import static staffbook.service.Constants.EMPLOYEE_LIST_MAX_ID_SALARY_SUM;
import static staffbook.service.Constants.EMPLOYEE_LIST_MIN_ID;
import static staffbook.service.Constants.EMPLOYEE_LIST_MIN_ID_SALARY_MAX;
import static staffbook.service.Constants.EMPLOYEE_LIST_MIN_ID_SALARY_MIN;
import static staffbook.service.Constants.EMPLOYEE_LIST_MIN_ID_SALARY_SUM;
import static staffbook.service.Constants.EMPLOYEE_MAP;
import static staffbook.service.Constants.EMPLOYEE_MAP_BY_DEP;
import static staffbook.service.Constants.EMPTY_DEP_ID;
import static staffbook.service.Constants.MAX_DEP_ID;
import static staffbook.service.Constants.MIN_DEP_ID;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    void getEmployeesByDepartment() {
        when(employeeServiceMock.getStaffBook()).thenReturn(EMPLOYEE_MAP);

        assertThat(out.getEmployeesByDepartment(MAX_DEP_ID)).containsExactlyInAnyOrderElementsOf(EMPLOYEE_LIST_MAX_ID);
        assertThat(out.getEmployeesByDepartment(MIN_DEP_ID)).containsExactlyInAnyOrderElementsOf(EMPLOYEE_LIST_MIN_ID);
    }

    @Test
    void getStaffDepartmentNegative() {
        assertThrows(ImpossibleDepartmentException.class, () -> out.getEmployeesByDepartment(MIN_DEP_ID - 1));
        assertThrows(ImpossibleDepartmentException.class, () -> out.getEmployeesByDepartment(MAX_DEP_ID + 1));
    }

    @Test
    void getSalarySumDepartment() {
        when(employeeServiceMock.getStaffBook()).thenReturn(EMPLOYEE_MAP);

        assertEquals(EMPLOYEE_LIST_MIN_ID_SALARY_SUM, out.getSalarySumDepartment(MIN_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MAX_ID_SALARY_SUM, out.getSalarySumDepartment(MAX_DEP_ID));
    }

    @Test
    public void getSalarySumDepartmentNegative() {
        assertThrows(ImpossibleDepartmentException.class, () -> out.getSalarySumDepartment(MIN_DEP_ID - 1));
        assertThrows(ImpossibleDepartmentException.class, () -> out.getSalarySumDepartment(MAX_DEP_ID + 1));
    }

    @Test
    void getSalaryMaxDepartment() {
        when(employeeServiceMock.getStaffBook()).thenReturn(EMPLOYEE_MAP);

        assertEquals(EMPLOYEE_LIST_MAX_ID_SALARY_MAX, out.getSalaryMaxDepartment(MAX_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MIN_ID_SALARY_MAX, out.getSalaryMaxDepartment(MIN_DEP_ID));
    }

    @Test
    public void getSalaryMaxDepartmentNegative() {
        assertThrows(ImpossibleDepartmentException.class, () -> out.getSalaryMaxDepartment(MIN_DEP_ID - 1));
        assertThrows(ImpossibleDepartmentException.class, () -> out.getSalaryMaxDepartment(MAX_DEP_ID + 1));
        assertThrows(DepartmentWithoutEmployeesException.class, () -> out.getSalaryMaxDepartment(EMPTY_DEP_ID));
    }

    @Test
    void getSalaryMinDepartment() {
        when(employeeServiceMock.getStaffBook()).thenReturn(EMPLOYEE_MAP);

        assertEquals(EMPLOYEE_LIST_MAX_ID_SALARY_MIN, out.getSalaryMinDepartment(MAX_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MIN_ID_SALARY_MIN, out.getSalaryMinDepartment(MIN_DEP_ID));
    }

    @Test
    public void getSalaryMinDepartmentNegative() {
        assertThrows(ImpossibleDepartmentException.class, () -> out.getSalaryMinDepartment(MIN_DEP_ID - 1));
        assertThrows(ImpossibleDepartmentException.class, () -> out.getSalaryMinDepartment(MAX_DEP_ID + 1));
        assertThrows(DepartmentWithoutEmployeesException.class, () -> out.getSalaryMinDepartment(EMPTY_DEP_ID));
    }

    @Test
    void getEmployeesByDepartments() {
        when(employeeServiceMock.getStaffBook()).thenReturn(EMPLOYEE_MAP);

        assertThat(out.getEmployeesByDepartments().keySet()).containsExactlyInAnyOrderElementsOf(EMPLOYEE_MAP_BY_DEP.keySet());
        assertThat(out.getEmployeesByDepartments().values().stream()
                .flatMap(Collection::stream).collect(Collectors.toList()))
                .containsExactlyInAnyOrderElementsOf(EMPLOYEE_MAP_BY_DEP.values().stream()
                        .flatMap(Collection::stream).collect(Collectors.toList()));
    }
}
