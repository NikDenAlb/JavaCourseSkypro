package staffbook.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import staffbook.exception.DepartmentWithoutEmployeesException;
import staffbook.exception.ImpossibleDepartmentException;

@ControllerAdvice
public class DepartmentsControllerAdvice {
    @ExceptionHandler({DepartmentWithoutEmployeesException.class,
            ImpossibleDepartmentException.class})
    public ResponseEntity<String> handleDepartmentWithoutEmployeesException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ошибка: " + e.getMessage());
    }
}
