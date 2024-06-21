package _1_IntroductionToTheProfessionAndLanguageSyntax._1_11_Methods;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.println("Задача 1");

        for (int yearForCheck = 2010; yearForCheck < LocalDate.now().getYear(); yearForCheck++) {
            if (checkLeapYear(yearForCheck)) {
                System.out.println(yearForCheck + " год — високосный год");
            } else {
                System.out.println(yearForCheck + " год — невисокосный год");
            }

        }
    }

    private static boolean checkLeapYear(int year) {
        return (year & 15) == 0 ? (year & 3) == 0 : (year & 3) == 0 && year % 100 != 0;
    }

    public static void task2() {
        System.out.println("\nЗадача 2");

        printAppSuggestion((byte) 1, 2010);
        printAppSuggestion((byte) 0, 2011);
        printAppSuggestion((byte) 1, 2016);
        printAppSuggestion((byte) 0, 2017);
        printAppSuggestion((byte) 1, 2015);
    }

    private static void printAppSuggestion(byte clientOS, int clientDeviceYear) {
        if (clientOS == 0 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (clientOS == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    public static void task3() {
        System.out.println("\nЗадача 3");

        printDelivery(5);
        printDelivery(25);
        printDelivery(45);
        printDelivery(65);
        printDelivery(101);
    }

    private static void printDelivery(int deliveryDistance) {
        if (deliveryDays(deliveryDistance) == -1) {
            System.out.println("Доставки нет");
        } else {
            System.out.println("Cрок доставки " + deliveryDays(deliveryDistance) + " день/дня/дней");
        }
    }

    private static int deliveryDays(int deliveryDistance) {
        byte deliverTime = 1;
        if (deliveryDistance > 20) {
            deliverTime += 1;
        }
        if (deliveryDistance > 60) {
            deliverTime += 1;
        }
        if (deliveryDistance > 100) {
            return -1;
        } else {
            return deliverTime;
        }
    }
}