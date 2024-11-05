package staffbook.exception;

public class DepartmentWithoutEmployeesException extends RuntimeException {
    public DepartmentWithoutEmployeesException(String message) {
        super(message);
    }
}
