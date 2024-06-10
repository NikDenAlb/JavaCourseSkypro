import java.time.YearMonth;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.println("Задача 1");
        try {
            method1(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            method1(2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        method1(0);
        method1(1);
    }

    public static void method1(int clientOS) {
        if (clientOS != 0 && clientOS != 1) {
            throw new IllegalArgumentException("Неподходящее значение, выберите 0 или 1");
        }
        System.out.print("Установите версию приложения для ");
        System.out.println(clientOS == 0
                ? "iOS по ссылке"
                : "Android по ссылке");
    }

    public static void task2() {
        System.out.println("Задача 2");
        try {
            method2(-1, 2015);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            method2(1, 2030);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            method2(1, 1999);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        method2(1, 2014);
        method2(1, 2015);
        method2(0, 2014);
        method2(0, 2015);
        method2(0, 2000);
    }

    public static void method2(int clientOS, int clientDeviceYear) {
        int yearNow = YearMonth.now().getYear();
        if (clientDeviceYear > yearNow || clientDeviceYear < 2000) {
            throw new IllegalArgumentException("Неподходящее значение, выберите существующий год производства вашего устройства");
        }
        if (clientOS != 0 && clientOS != 1) {
            throw new IllegalArgumentException("Неподходящее значение, выберите 0 или 1");
        }


        if (clientOS == 0) {
            System.out.println(clientDeviceYear < 2015
                    ? "Установите облегченную версию приложения для iOS по ссылке"
                    : "Установите версию приложения для iOS по ссылке");
        } else {
            System.out.println(clientDeviceYear < 2015
                    ? "Установите облегченную версию приложения для Android по ссылке"
                    : "Установите версию приложения для Android по ссылке");
        }


        String version = clientDeviceYear < 2015 ? "облегченную " : "";
        String cOS = clientOS == 0 ? "iOS" : "Android";
        String s = "Установите " + version + "версию приложения для " + cOS + " по ссылке";
        System.out.println(s);


        ///////////////////////////////////////////////////////////////////
        //нельзя нормально конкатенировать
//        if (clientOS == 0) {
//            System.out.println("Установите " + clientDeviceYear < 2015
//                    ? "Установите облегченную версию приложения для iOS по ссылке"
//                    : "Установите версию приложения для iOS по ссылке");
//        } else {
//            System.out.println(clientDeviceYear < 2015
//                    ? "Установите облегченную версию приложения для Android по ссылке"
//                    : "Установите версию приложения для Android по ссылке");
//        }
        /////////////////////////////////////////////////////////////////////
    }

    public static void task3() {
        System.out.println("Задача 2");
        System.out.println("Введите число:");
        int number;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                number = sc.nextInt();
                sc.close();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите число повторно:");
            }
        }
        if (number >= 0 && number <= 100) {
            System.out.println("Спасибо! Вы ввели число " + number);
        } else {
            throw new IllegalArgumentException(number + " - число не в заданном диапазоне");
        }
    }
}
