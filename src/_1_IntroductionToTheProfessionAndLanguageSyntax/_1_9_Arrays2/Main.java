package _1_IntroductionToTheProfessionAndLanguageSyntax._1_9_Arrays2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static int[] generateRandomArray(int length) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000_00) + 100_000_00;
        }
        return arr;
    }

    public static void task1() {
        System.out.println("Задача 1");
        int[] payoutMonth = generateRandomArray(5);
        System.out.println("Задан массив:\n" + Arrays.toString(payoutMonth));

        int totalPayoutMonth = 0;
        for (int i : payoutMonth) {
            totalPayoutMonth += i;
        }

        System.out.println("Сумма трат за месяц составила " + totalPayoutMonth / 100 + " руб. " + totalPayoutMonth % 100 + " коп.");
    }

    public static void task2() {
        System.out.println("\nЗадача 2");
        int[] payoutMonth = generateRandomArray(5);
        System.out.println("Задан массив:\n" + Arrays.toString(payoutMonth));

        int maxPayout = 0;
        int minPayout = payoutMonth[0];
        for (int i : payoutMonth) {
            if (i > maxPayout) {
                maxPayout = i;
            }
            if (i < minPayout) {
                minPayout = i;
            }
        }

        System.out.println("Максимальная выплата составила " + maxPayout / 100 + " руб. " + maxPayout % 100 + " коп.");
        System.out.println("Минимальная выплата составила " + minPayout / 100 + " руб. " + minPayout % 100 + " коп.");
    }

    public static void task3() {
        System.out.println("\nЗадача 3");
        int[] payoutMonth = generateRandomArray(5);
        System.out.println("Задан массив:\n" + Arrays.toString(payoutMonth));

        int totalPayoutMonth = 0;
        for (int i : payoutMonth) {
            totalPayoutMonth += i;
        }
        double averagePayout = (double) totalPayoutMonth / payoutMonth.length;

        System.out.printf("Средняя выплата составила %.2f руб.\n", averagePayout / 100);
    }

    public static void task4() {
        System.out.println("\nЗадача 4");
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        for (int i = 0; i < reverseFullName.length; i++) {
            System.out.print(reverseFullName[reverseFullName.length - 1 - i]);
        }
    }
}
