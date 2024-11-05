package staffbook.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import staffbook.exception.EmployeeAlreadyAddedException;
import staffbook.exception.EmployeeNotFoundException;
import staffbook.exception.EmployeeStorageIsFullException;
import staffbook.exception.ImpossibleDepartmentException;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler({EmployeeStorageIsFullException.class,
            EmployeeAlreadyAddedException.class,
            ImpossibleDepartmentException.class})
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Ошибка: " + e.getMessage());
    }

    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<String> handleRuntimeException(EmployeeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ошибка: " + e.getMessage());
    }
}
