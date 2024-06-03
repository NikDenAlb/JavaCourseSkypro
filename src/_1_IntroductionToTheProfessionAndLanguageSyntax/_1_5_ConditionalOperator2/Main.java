package _1_IntroductionToTheProfessionAndLanguageSyntax._1_5_ConditionalOperator2;

import java.time.YearMonth;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        System.out.println();
        task5();
    }

    public static void task1() {
        System.out.println("Задача 1");
        System.out.println("Введите 0 если у пользователя iOS, 1 — если Android");

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        byte clientOS;
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        Scanner sc = new Scanner(System.in);
        try {
            clientOS = sc.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном формате, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            clientOS = (byte) Math.round(f);
            System.out.println(clientOS);
        }

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 1) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        else {
            System.out.println("К сожалению, вы не смогли ввести в заданном диапазоне, программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            clientOS = (byte) Math.round(f);
            System.out.println(clientOS);
            if (clientOS == 0) {
                System.out.println("Установите версию приложения для iOS по ссылке");
            } else if (clientOS == 1) {
                System.out.println("Установите версию приложения для Android по ссылке");
            }
        }
    }

    public static void task2() {
        System.out.println("Задача 2");

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        byte clientOS;
        int clientDeviceYear;
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        System.out.println("Введите 0 если у пользователя iOS, 1 — если Android)");

        Scanner sc = new Scanner(System.in);
        try {
            clientOS = sc.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном формате, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            clientOS = (byte) Math.round(f);
            System.out.println(clientOS);
        }
        if (clientOS != 0 && clientOS != 1) {
            System.out.println("К сожалению, вы не смогли ввести в заданном диапазоне, программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            clientOS = (byte) Math.round(f);
            System.out.println(clientOS);
        }
        int yearNow = YearMonth.now().getYear();
        System.out.println("Введите год создания телефона (от 2010 до " + yearNow + ")");
        sc = new Scanner(System.in);
        try {
            clientDeviceYear = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном формате, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            clientDeviceYear = (short) Math.round(2010 * (1.0 - f) + yearNow * f);
            System.out.println(clientDeviceYear);
        }
        if (clientDeviceYear < 2010 || clientDeviceYear > yearNow) {
            System.out.println("К сожалению, вы не смогли ввести данные в заданном диапазоне, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            clientDeviceYear = (short) Math.round(2010 * (1.0 - f) + yearNow * f);
            System.out.println(clientDeviceYear);
        }

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        if (clientOS == 0 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (clientOS == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 1) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }

    public static void task3() {
        System.out.println("Задача 3");
        System.out.println("Введите год григорианского календаря (1582+) для проверки на високосность");

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        int year;
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        Scanner sc = new Scanner(System.in);
        try {
            year = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном формате, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            year = (short) Math.round(32767 * f);
            System.out.println(year);
        }
        if (year < 1582) {
            System.out.println("К сожалению, вы не смогли ввести данные в заданном диапазоне, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            year = (int) Math.round(32767 * f);
            System.out.println(year);
        }

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        if (year % 400 == 0) {
            System.out.println(year + "-й год является високосным");
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + "-й год является високосным");
        } else {
            System.out.println(year + "-й год не является високосным");
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }

    public static void task4() {
        System.out.println("Задача 4");
        System.out.println("Введите сколько километров до офиса");

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        int deliveryDistance;
        byte deliverTime = 0;
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        Scanner sc = new Scanner(System.in);
        try {
            deliveryDistance = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном формате, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            deliveryDistance = (int) Math.round(120 * f);
            System.out.println(deliveryDistance);
        }
        if (deliveryDistance < 0) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном диапазоне, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            deliveryDistance = (int) Math.round(120 * f);
            System.out.println(deliveryDistance);
        }

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        deliverTime += 1;
        if (deliveryDistance > 20) {
            deliverTime += 1;
        }
        if (deliveryDistance > 60) {
            deliverTime += 1;
        }
        if (deliveryDistance > 100) {
            System.out.println("Свыше 100 км доставки нет.");
        } else {
            System.out.println("Потребуется дней: " + deliverTime + ".");
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }

    public static void task5() {
        System.out.println("Задача 5");
        System.out.println("Введите номер месяца для проверки сезона");

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        int monthNumber;
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        Scanner sc = new Scanner(System.in);
        try {
            monthNumber = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("К сожалению, вы не смогли ввести данные в правильном формате, тогда программа попробует угадать");
            double f = Math.random() / Math.nextDown(1.0);
            monthNumber = (int) Math.round(12 * f);
            System.out.println(monthNumber);
        }

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                System.out.println(monthNumber + "-й месяц принадлежит к сезону зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println(monthNumber + "-й месяц принадлежит к сезону весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(monthNumber + "-й месяц принадлежит к сезону лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(monthNumber + "-й месяц принадлежит к сезону осень");
                break;
            default:
                throw new IllegalStateException("Вы сломали программу, введя некорректный номер месяца: " + monthNumber);
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }
}