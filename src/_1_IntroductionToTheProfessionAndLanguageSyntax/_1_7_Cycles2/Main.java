package _1_IntroductionToTheProfessionAndLanguageSyntax._1_7_Cycles2;

import java.time.LocalDate;
import java.time.YearMonth;

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
        System.out.println();
        task6();
        System.out.println();
        task7();
        System.out.println();
        task8();
    }

    public static void task1() {
        System.out.println("Задача 1");

        int salarySavings = 15000;
        int totalSavings = 0;
        int monthNeeded = 0;
        while (totalSavings < 2_459_000) {
            totalSavings += salarySavings;
            monthNeeded++;
            System.out.print(totalSavings + " ");
        }
        System.out.println("\nМесяц " + monthNeeded + ", сумма накоплений равна " + totalSavings + " рублей");
    }

    public static void task2() {
        System.out.println("Задача 2");

        int number = 0;

        while (number < 10) {
            System.out.print(++number + " ");
        }
        System.out.println();

        for (; number > 0; number--) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void task3() {
        System.out.println("Задача 3");

        int population = 12_000_000;
        double birthForYear = 0.017;
        double deathForYear = 0.008;
        int yearFromNow = 0;

        while (yearFromNow++ < 10) {
            population += Math.round(population * (birthForYear - deathForYear));
            System.out.println("Год " + yearFromNow + ", численность населения составляет " + population);
        }
    }

    public static void task4() {
        System.out.println("Задача 4");

        int bankAccount = 15_000_00;
        double monthInterest = 0.07;
        int goalAccount = 12_000_000_00;
        int monthFromNow = 0;

        while (bankAccount < goalAccount) {
            bankAccount += Math.round(bankAccount * monthInterest);
            monthFromNow++;
            System.out.print(bankAccount / 100 + "р ");
        }
        System.out.println("\nМесяц " + monthFromNow + ", сумма на вкладе составляет " + bankAccount / 100 + " руб. " + bankAccount % 100 + " коп.");
    }

    public static void task5() {
        System.out.println("Задача 5");

        int bankAccount = 15_000_00;
        double monthInterest = 0.07;
        int goalAccount = 12_000_000_00;
        int monthFromNow = 0;

        while (bankAccount < goalAccount) {
            bankAccount += Math.round(bankAccount * monthInterest);
            monthFromNow++;
            if (monthFromNow % 6 == 0 && bankAccount < goalAccount) {
                System.out.println("Месяц " + monthFromNow + ", сумма на вкладе составляет " + bankAccount / 100 + " руб. " + bankAccount % 100 + " коп.");
            }
        }
        System.out.println("Итоговый месяц " + monthFromNow + ", сумма на вкладе составляет " + bankAccount / 100 + " руб. " + bankAccount % 100 + " коп.");
    }

    public static void task6() {
        System.out.println("Задача 6");

        long bankAccount = 15_000_00;
        double monthInterest = 0.07;
        int goalTime = 9 * 12;
        int checkInterval = 6;
        int currentMonth = 0;

        while (currentMonth++ < goalTime - 1) {
            bankAccount += Math.round(bankAccount * monthInterest);
            if (currentMonth % checkInterval == 0) {
                System.out.println("Месяц " + currentMonth + ", сумма на вкладе составляет " + bankAccount / 100 + " руб. " + bankAccount % 100 + " коп.");
            }
        }
        bankAccount += Math.round(bankAccount * monthInterest);
        System.out.println("Итоговый месяц " + currentMonth + ", сумма на вкладе составляет " + bankAccount / 100 + " руб. " + bankAccount % 100 + " коп.");
    }

    public static void task7() {
        System.out.println("Задача 7");

        //Требуется месяц ёмкостью 31 день. Пусть это будет текущий или следующий месяц
        YearMonth taskMonth = YearMonth.now();
        if (taskMonth.lengthOfMonth() != 31) {
            taskMonth = taskMonth.plusMonths(1);
        }
        System.out.println(taskMonth);

        int firstFridayNumber = 0;
        while (((LocalDate.of(taskMonth.getYear(), taskMonth.getMonth(), ++firstFridayNumber)).getDayOfWeek()).getValue() != 5)
            ;

        for (int i = firstFridayNumber; i <= 31; i += 7) {
            if (i % 7 == firstFridayNumber) {
                System.out.println("Сегодня пятница, " + i + "-е число. Необходимо подготовить отчет");
            }
        }
    }

    public static void task8() {
        System.out.println("Задача 8");

        int cometPeriod = 79;
        int currentYear = LocalDate.now().getYear();

        int lastCometYear = 0;
        for (int i = -200; i < 0; i++) {
            if ((currentYear + i) % cometPeriod == 0) {
                lastCometYear = currentYear + i;
                break;
            }
        }

        for (; lastCometYear < currentYear + 100; lastCometYear += cometPeriod) {
            System.out.println(lastCometYear);
        }
    }
}
