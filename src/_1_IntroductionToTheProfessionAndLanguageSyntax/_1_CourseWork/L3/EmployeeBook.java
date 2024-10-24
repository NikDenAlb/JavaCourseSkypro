package _1_IntroductionToTheProfessionAndLanguageSyntax._1_CourseWork.L3;

import java.util.Objects;

public class EmployeeBook {

    private Employee[] employeeBook;

    public EmployeeBook(int totalEntities) {
        if (totalEntities < 0) {
            throw new IllegalArgumentException("Число записей в книге не может быть отрицательным");
        }
        if (totalEntities < 1) {
            throw new IllegalArgumentException("В книге должна быть хотя бы одна страница");
        }
        employeeBook = new Employee[totalEntities];
    }

    public void addEmployee(String fullName, Department department, int salary) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = new Employee(fullName, department, salary);
                break;
            }
            if (i == employeeBook.length - 1) {
                throw new RuntimeException("В книге нет свободных записей");
            }
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getId() == id) {
                employeeBook[i] = null;
                break;
            }
            if (i == employeeBook.length - 1) {
                throw new RuntimeException("В книге нет сотрудника с id=" + id);
            }
        }
    }

    public void deleteEmployee(String fullName) {

        boolean is = false;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getFullName().equals(fullName)) {
                employeeBook[i] = null;
                is = true;
            }
        }
        if (!is) {
            throw new RuntimeException("В книге нет сотрудников с Ф.И.О. " + fullName);
        }
    }

    public void deleteEmployee(String fullName, int id) {
        boolean is = false;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getFullName().equals(fullName) && employeeBook[i].getId() == id) {
                employeeBook[i] = null;
                is = true;
            }
        }
        if (!is) {
            throw new RuntimeException("В книге нет сотрудника с Ф.И.О. " + fullName + " и id=" + id);
        }
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null)
                if (string.isEmpty()) {
                    string.append("[").append(i).append("] ").append(employeeBook[i]);
                } else {
                    string.append("\n" + "[").append(i).append("] ").append(employeeBook[i]);
                }
        }
        return string.toString();
    }

    public int totalSalary() {
        int totalSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public int[] whoMinimumSalary() {
        int minimumSalary = Integer.MAX_VALUE;
        for (Employee employee : employeeBook) {
            if (employee != null && minimumSalary > employee.getSalary()) {
                minimumSalary = employee.getSalary();
            }
        }
        return getIdsOfParameterSalary(minimumSalary);
    }

    public Employee[] whoEmployeesMinimumSalary() {
        int minimumSalary = Integer.MAX_VALUE;
        for (Employee employee : employeeBook) {
            if (employee != null && minimumSalary > employee.getSalary()) {
                minimumSalary = employee.getSalary();
            }
        }
        return getEmployeesOfParameterSalary(minimumSalary);
    }

    public int[] whoMaximumSalary() {
        int maximumSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && maximumSalary < employee.getSalary()) {
                maximumSalary = employee.getSalary();
            }
        }
        return getIdsOfParameterSalary(maximumSalary);
    }

    public Employee[] whoEmployeesMaximumSalary() {
        int maximumSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && maximumSalary < employee.getSalary()) {
                maximumSalary = employee.getSalary();
            }
        }
        return getEmployeesOfParameterSalary(maximumSalary);
    }

    public double averageSalary() {
        int count = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                count++;
            }
        }
        if (count == 0) return 0;
        return (double) totalSalary() / count;
    }

    public void printAllFullNames() {
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(++i + ") " + employee.getFullName());
            }
        }
    }

    public void increaseSalary(double percent) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                employee.setSalary((employee.getSalary() + (int) Math.round(employee.getSalary() * percent / 100)));
            }
        }
    }

    public int[] whoMinimumDepartmentSalary(Department department) {
        int minimumSalary = Integer.MAX_VALUE;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department && minimumSalary > employee.getSalary()) {
                minimumSalary = employee.getSalary();
            }
        }
        return getIdsOfParameterDepartmentSalary(department, minimumSalary);
    }

    public Employee[] whoEmployeesMinimumDepartmentSalary(Department department) {
        int minimumSalary = Integer.MAX_VALUE;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department && minimumSalary > employee.getSalary()) {
                minimumSalary = employee.getSalary();
            }
        }
        return getEmployeesOfParameterDepartmentSalary(department, minimumSalary);
    }

    public int[] whoMaximumDepartmentSalary(Department department) {
        int maximumSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department && maximumSalary < employee.getSalary()) {
                maximumSalary = employee.getSalary();
            }
        }
        return getIdsOfParameterDepartmentSalary(department, maximumSalary);
    }

    public Employee[] whoEmployeesMaximumDepartmentSalary(Department department) {
        int maximumSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department && maximumSalary < employee.getSalary()) {
                maximumSalary = employee.getSalary();
            }
        }
        return getEmployeesOfParameterDepartmentSalary(department, maximumSalary);
    }

    public int totalDepartmentSalary(Department department) {
        int totalSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public double averageDepartmentSalary(Department department) {
        int count = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }
        if (count == 0) return 0;
        return (double) totalDepartmentSalary(department) / count;
    }

    public void increaseDepartmentSalary(Department department, double percent) {
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((employee.getSalary() + (int) Math.round(employee.getSalary() * percent / 100)));
            }
        }
    }

    public void printDepartment(Department department) {
        String string = getStringDepartmentStaff(department);
        System.out.println(Objects.requireNonNullElseGet(string, () -> "В отделе " + department + " нет сотрудников"));
    }

    public void printAllMoreSalary(int salary) {
        String string = null;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getSalary() >= salary) {
                string = getStringEmployeeWithoutDepartment(string, i);
            }
        }
        if (string != null) {
            System.out.println(string);
        } else {
            System.out.printf("Сотрудников с зарплатой равной или выше %,dр %02dк нет\n", salary / 100, salary % 100);
        }
    }

    public void printAllLessSalary(int salary) {
        String string = null;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getSalary() < salary)
                string = getStringEmployeeWithoutDepartment(string, i);
        }
        if (string != null) {
            System.out.println(string);
        } else {
            System.out.printf("Сотрудников с зарплатой ниже %,dр %02dк нет\n", salary / 100, salary % 100);
        }
    }

    public void rewriteByFullName(String fullName, Department newDepartment) {
        boolean change = false;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                change = true;
                employee.setDepartment(newDepartment);
            }
        }
        if (!change) {
            throw new RuntimeException("В книге нет сотрудника с Ф.И.О. " + fullName);
        }
    }

    public void rewriteByFullName(String fullName, int newSalary) {
        boolean change = false;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                change = true;
                employee.setSalary(newSalary);
            }
        }
        if (!change) {
            throw new RuntimeException("В книге нет сотрудника с Ф.И.О. " + fullName);
        }
    }

    public void rewriteByFullName(String fullName, Department newDepartment, int newSalary) {
        boolean change = false;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                change = true;
                employee.setDepartment(newDepartment);
                employee.setSalary(newSalary);
            }
        }
        if (!change) {
            throw new RuntimeException("В книге нет сотрудника с Ф.И.О. " + fullName);
        }
    }

    public void printAllDepartments() {

        for (Department department : Department.values()) {
            System.out.println("Отдел " + department);

            String string = getStringDepartmentStaff(department);
            System.out.println(Objects.requireNonNullElse(string, "В отделе нет сотрудников"));
        }

    }

    private int[] getIdsOfParameterSalary(int targetSalary) {
        int counter = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && targetSalary == employee.getSalary()) {
                counter++;
            }
        }
        int[] out = new int[counter];
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && targetSalary == employee.getSalary()) {
                out[i++] = employee.getId();
            }
        }
        return out;
    }

    private int[] getIdsOfParameterDepartmentSalary(Department targetDepartment, int targetSalary) {
        int counter = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == targetDepartment && targetSalary == employee.getSalary()) {
                counter++;
            }
        }
        int[] out = new int[counter];
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == targetDepartment && targetSalary == employee.getSalary()) {
                out[i++] = employee.getId();
            }
        }
        return out;
    }

    private String getStringDepartmentStaff(Department department) {
        String string = null;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartment() == department)
                string = getStringEmployeeWithoutDepartment(string, i);
        }
        return string;
    }

    private String getStringEmployeeWithoutDepartment(String string, int i) {
        if (string == null) {
            string = "[" + i + "] " + String.format("%s, зарплата %,dр %02dк, id=%d", employeeBook[i].getFullName(), employeeBook[i].getSalary() / 100, employeeBook[i].getSalary() % 100, employeeBook[i].getId());
        } else {
            string += "\n" + "[" + i + "] " + String.format("%s, зарплата %,dр %02dк, id=%d", employeeBook[i].getFullName(), employeeBook[i].getSalary() / 100, employeeBook[i].getSalary() % 100, employeeBook[i].getId());
        }
        return string;
    }

    private Employee[] getEmployeesOfParameterDepartmentSalary(Department targetDepartment, int targetSalary) {
        int counter = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == targetDepartment && targetSalary == employee.getSalary()) {
                counter++;
            }
        }
        Employee[] out = new Employee[counter];
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == targetDepartment && targetSalary == employee.getSalary()) {
                out[i++] = employee;
            }
        }
        return out;
    }

    private Employee[] getEmployeesOfParameterSalary(int targetSalary) {
        int counter = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && targetSalary == employee.getSalary()) {
                counter++;
            }
        }
        Employee[] out = new Employee[counter];
        int i = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && targetSalary == employee.getSalary()) {
                out[i++] = employee;
            }
        }
        return out;
    }
}
