package _1_IntroductionToTheProfessionAndLanguageSyntax._1_6_Cycles;

public class Main {

    public static void main(String[] args) {
        task1Star();
        System.out.println();
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
        System.out.println();
        task9();
        System.out.println();
        task10();
    }

    public static void task1Star() {
        System.out.println("Задача 1*");

        String s = "i";
        char a = s.charAt(0);
        char b = (char) ((int) a + 10);
        System.out.println("От " + a + " до " + b);

        for (char i = a; i != b; i++) {
            System.out.println((int) (i) - (int) (a) + 1);
        }
    }

    public static void task1() {
        System.out.println("Задача 1");

        for (int i = 0; i <= 9; i++) {
            System.out.println(i + 1);
        }
    }

    public static void task2() {
        System.out.println("Задача 2");

        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }

    public static void task3() {
        System.out.println("Задача 3");

        for (int i = 0; i <= 17; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void task4() {
        System.out.println("Задача 4");

        for (int i = 10; i >= -10; i--) {
            System.out.println(i);
        }
    }

    public static void task5() {
        System.out.println("Задача 5");

        int v = 0;

        for (int i = 1904; i < 2096; i++) {
            if (i % 4 == 0) {
                v = i;
                break;
            }
        }

        for (; v <= 2096; v += 4) {
            if (v % 400 == 0 || v % 100 != 0) {
                System.out.println(v + " год является високосным");
            }
        }
    }

    public static void task6() {
        System.out.println("Задача 6");

        for (int i = 7; i <= 98; i += 7) {
            System.out.println(i);
        }
    }

    public static void task7() {
        System.out.println("Задача 7");

        for (int i = 1; i <= 512; i *= 2) {
            System.out.println(i);
        }
    }

    public static void task8() {
        System.out.println("Задача 8");

        int salarySavings = 29000;
        int totalSavings = 0;
        for (int i = 0; i < 12; i++) {
            totalSavings += salarySavings;
            System.out.println("Месяц " + (i + 1) + ", сумма накоплений равна " + totalSavings + " рублей");
        }
    }

    public static void task9() {
        System.out.println("Задача 9");

        int salarySavings = 29000_00;
        long totalSavings = 0;
        double monthInterest = 0.01;

        for (int i = 0; i < 12; i++) {
            totalSavings += Math.round(totalSavings * monthInterest) + salarySavings;
            System.out.println("Месяц " + (i + 1) + ", сумма накоплений равна " + totalSavings / 100 + " руб. " + totalSavings % 100 + " коп.");
        }
    }

    public static void task10() {
        System.out.println("Задача 10");

        for (int i = 0; i < 10; i++) {
            System.out.println("2 * " + (i + 1) + " = " + 2 * (i + 1));
        }
    }
}
