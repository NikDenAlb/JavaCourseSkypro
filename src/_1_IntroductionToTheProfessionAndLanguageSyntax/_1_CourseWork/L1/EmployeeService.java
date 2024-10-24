package _1_IntroductionToTheProfessionAndLanguageSyntax._1_CourseWork.L1;

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
}
