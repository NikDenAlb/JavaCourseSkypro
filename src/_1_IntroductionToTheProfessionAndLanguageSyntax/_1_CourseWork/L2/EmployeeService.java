package _1_IntroductionToTheProfessionAndLanguageSyntax._1_CourseWork.L2;

import java.util.Objects;

public class EmployeeService {

    public static String toString(Employee[] staffBook) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < staffBook.length; i++) {
            if (staffBook[i] != null)
                if (string.isEmpty()) {
                    string.append("[").append(i).append("] ").append(staffBook[i]);
                } else {
                    string.append("\n" + "[").append(i).append("] ").append(staffBook[i]);
                }
        }
        return string.toString();
    }

    public static int totalSalary(Employee[] staffBook) {
        int totalSalary = 0;
        for (Employee employee : staffBook) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static int[] minimumSalary(Employee[] staffBook) {
        int minimumSalary = Integer.MAX_VALUE;
        int counter = 0;
        for (Employee employee : staffBook) {
            if (employee != null && minimumSalary > employee.getSalary()) {
                minimumSalary = employee.getSalary();
            }
        }
        for (Employee employee : staffBook) {
            if (employee != null && minimumSalary == employee.getSalary()) {
                counter++;
            }
        }
        int[] out = new int[counter];
        int i = 0;
        for (Employee employee : staffBook) {
            if (employee != null && minimumSalary == employee.getSalary()) {
                out[i++] = employee.getId();
            }
        }
        return out;
    }

    public static int[] maximumSalary(Employee[] staffBook) {
        int maximumSalary = 0;
        int counter = 0;
        for (Employee employee : staffBook) {
            if (employee != null && maximumSalary < employee.getSalary()) {
                maximumSalary = employee.getSalary();
            }
        }
        for (Employee employee : staffBook) {
            if (employee != null && maximumSalary == employee.getSalary()) {
                counter++;
            }
        }
        int[] out = new int[counter];
        int i = 0;
        for (Employee employee : staffBook) {
            if (employee != null && maximumSalary == employee.getSalary()) {
                out[i++] = employee.getId();
            }
        }
        return out;
    }

    public static double averageSalary(Employee[] staffBook) {
        int count = 0;
        for (Employee employee : staffBook) {
            if (employee != null) {
                count++;
            }
        }
        if (count == 0) return 0;
        return (double) totalSalary(staffBook) / count;
    }

    public static void printAllFullNames(Employee[] staffBook) {
        int i = 0;
        for (Employee employee : staffBook) {
            if (employee != null) {
                System.out.println(++i + ") " + employee.getFullName());
            }
        }
        if (i == 0) {
            System.out.println("Список сотрудников пуст");
        }
    }

    ///////////////////////L2////////////////////////////////L2///////////////////////////////////////L2////////////////
    public static void increaseSalary(Employee[] staffBook, double percent) {
        for (Employee employee : staffBook) {
            if (employee != null) {
                employee.setSalary((employee.getSalary() + (int) Math.round(employee.getSalary() * percent / 100)));
            }
        }
    }

    public static int[] minimumDepartmentSalary(Employee[] staffBook, Department department) {
        int minimumSalary = Integer.MAX_VALUE;
        int counter = 0;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department && minimumSalary > employee.getSalary()) {
                minimumSalary = employee.getSalary();
            }
        }
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department && minimumSalary == employee.getSalary()) {
                counter++;
            }
        }
        int[] out = new int[counter];
        int i = 0;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department && minimumSalary == employee.getSalary()) {
                out[i++] = employee.getId();
            }
        }
        return out;
    }

    public static int[] maximumDepartmentSalary(Employee[] staffBook, Department department) {
        int maximumSalary = 0;
        int counter = 0;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department && maximumSalary < employee.getSalary()) {
                maximumSalary = employee.getSalary();
            }
        }
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department && maximumSalary == employee.getSalary()) {
                counter++;
            }
        }
        int[] out = new int[counter];
        int i = 0;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department && maximumSalary == employee.getSalary()) {
                out[i++] = employee.getId();
            }
        }
        return out;
    }

    public static int totalDepartmentSalary(Employee[] staffBook, Department department) {
        int totalSalary = 0;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static double averageDepartmentSalary(Employee[] staffBook, Department department) {
        int count = 0;
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }
        if (count == 0) return 0;
        return (double) totalDepartmentSalary(staffBook, department) / count;
    }

    public static void increaseDepartmentSalary(Employee[] staffBook, Department department, double percent) {
        for (Employee employee : staffBook) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((employee.getSalary() + (int) Math.round(employee.getSalary() * percent / 100)));
            }
        }
    }

    public static void printDepartment(Employee[] staffBook, Department department) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < staffBook.length; i++) {
            if (staffBook[i] != null && staffBook[i].getDepartment() == department)
                if (string.isEmpty()) {
                    string.append("[").append(i).append("] ").append(String.format("%s, зарплата %,dр %02dк, id=%d", staffBook[i].getFullName(), staffBook[i].getSalary() / 100, staffBook[i].getSalary() % 100, staffBook[i].getId()));
                } else {
                    string.append("\n" + "[").append(i).append("] ").append(String.format("%s, зарплата %,dр %02dк, id=%d", staffBook[i].getFullName(), staffBook[i].getSalary() / 100, staffBook[i].getSalary() % 100, staffBook[i].getId()));
                }
        }
        System.out.println(Objects.requireNonNullElseGet(string, () -> "В отделе " + department + " нет сотрудников"));
    }

    public static void printAllMoreSalary(Employee[] staffBook, int salary) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < staffBook.length; i++) {
            if (staffBook[i] != null && staffBook[i].getSalary() >= salary)
                if (string.isEmpty()) {
                    string.append("[").append(i).append("] ").append(String.format("%s, зарплата %,dр %02dк, id=%d", staffBook[i].getFullName(), staffBook[i].getSalary() / 100, staffBook[i].getSalary() % 100, staffBook[i].getId()));
                } else {
                    string.append("\n" + "[").append(i).append("] ").append(String.format("%s, зарплата %,dр %02dк, id=%d", staffBook[i].getFullName(), staffBook[i].getSalary() / 100, staffBook[i].getSalary() % 100, staffBook[i].getId()));
                }
        }
        if (!string.isEmpty()) {
            System.out.println(string);
        } else {
            System.out.printf("Сотрудников с зарплатой равной или выше %,dр %02dк нет\n", salary / 100, salary % 100);
        }
    }

    public static void printAllLessSalary(Employee[] staffBook, int salary) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < staffBook.length; i++) {
            if (staffBook[i] != null && staffBook[i].getSalary() < salary)
                if (string.isEmpty()) {
                    string.append("[").append(i).append("] ").append(String.format("%s, зарплата %,dр %02dк, id=%d", staffBook[i].getFullName(), staffBook[i].getSalary() / 100, staffBook[i].getSalary() % 100, staffBook[i].getId()));
                } else {
                    string.append("\n" + "[").append(i).append("] ").append(String.format("%s, зарплата %,dр %02dк, id=%d", staffBook[i].getFullName(), staffBook[i].getSalary() / 100, staffBook[i].getSalary() % 100, staffBook[i].getId()));
                }
        }
        if (!string.isEmpty()) {
            System.out.println(string);
        } else {
            System.out.printf("Сотрудников с зарплатой ниже %,dр %02dк нет\n", salary / 100, salary % 100);
        }
    }
}
