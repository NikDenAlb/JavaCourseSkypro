package staffbook.service;

import staffbook.domain.Department;
import staffbook.domain.Employee;

import java.util.List;
import java.util.Map;

import static staffbook.domain.Department.DEP1;
import static staffbook.domain.Department.DEP2;
import static staffbook.domain.Department.DEP5;

public class Constants {
    public static final int MAX_DEP_ID = Department.values().length - 1;
    public static final int MIN_DEP_ID = 0;
    public static final int EMPTY_DEP_ID = 2;
    public static Employee employee1 = new Employee("Namea", "Surnamea", DEP1, 1000);
    public static Employee employee2 = new Employee("Nameb", "Surnameb", DEP2, 1000);
    public static Employee employee3 = new Employee("Namec", "Surnamec", DEP2, 2000);
    public static Employee employee4 = new Employee("Named", "Surnamed", DEP5, 3000);
    public static Employee employee5 = new Employee("Namee", "Surnamee", DEP5, 4000);

    public static final List<Employee> EMPLOYEE_LIST = List.of(
            new Employee("Namea", "Surnamea", DEP1, 1000),
            new Employee("Nameb", "Surnameb", DEP2, 1000),
            new Employee("Namec", "Surnamec", DEP2, 2000),
            new Employee("Named", "Surnamed", DEP5, 3000),
            new Employee("Namee", "Surnamee", DEP5, 4000));
    public static final Map<String, Employee> EMPLOYEE_MAP = Map.of(
            "Namea" + " " + "Surnamea", new Employee("Namea", "Surnamea", DEP1, 1000),
            "Nameb" + " " + "Surnameb", new Employee("Nameb", "Surnameb", DEP2, 1000),
            "Namec" + " " + "Surnamec", new Employee("Namec", "Surnamec", DEP2, 2000),
            "Named" + " " + "Surnamed", new Employee("Named", "Surnamed", DEP5, 3000),
            "Namee" + " " + "Surnamee", new Employee("Namee", "Surnamee", DEP5, 4000));
    public static final Map<Integer, List<Employee>> EMPLOYEE_MAP_BY_DEP = Map.of(
            0, List.of(employee1),
            1, List.of(employee2, employee3),
            4, List.of(employee4, employee5));

    public static final List<Employee> EMPLOYEE_LIST_MAX_ID = List.of(
            new Employee("Named", "Surnamed", DEP5, 3000),
            new Employee("Namee", "Surnamee", DEP5, 4000));
    public static final List<Employee> EMPLOYEE_LIST_MIN_ID = List.of(
            new Employee("Namea", "Surnamea", DEP1, 1000));
    public static final int EMPLOYEE_LIST_MIN_ID_SALARY_SUM = 1000;
    public static final int EMPLOYEE_LIST_MAX_ID_SALARY_SUM = 7000;
    public static final int EMPLOYEE_LIST_MAX_ID_SALARY_MAX = 4000;
    public static final int EMPLOYEE_LIST_MAX_ID_SALARY_MIN = 3000;
    public static final int EMPLOYEE_LIST_MIN_ID_SALARY_MAX = 1000;
    public static final int EMPLOYEE_LIST_MIN_ID_SALARY_MIN = 1000;
}
