package _1_IntroductionToTheProfessionAndLanguageSyntax._1_10_Strings;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.println("Задача 1");

        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";

        String fullName = lastName + ' ' + firstName + ' ' + middleName;
        String fullName2 = String.join(" ", firstName, middleName, lastName);

        System.out.println("ФИО сотрудника — " + fullName);
        System.out.println("Alternative way — " + fullName2);
    }

    public static void task2() {
        System.out.println("\nЗадача 2");

        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + ' ' + firstName + ' ' + middleName;

        System.out.println("Данные ФИО сотрудника для заполнения отчета — " + fullName.toUpperCase());
    }

    public static void task3() {
        System.out.println("\nЗадача 3");

        String fullName = "Иванов Семён Семёнович";
        System.out.println("fullName = " + fullName);

        fullName = fullName.replace('ё', 'е');
        System.out.println("Данные ФИО сотрудника — " + fullName);
    }
}
