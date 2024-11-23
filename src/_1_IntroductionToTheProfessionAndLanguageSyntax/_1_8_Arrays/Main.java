package _1_IntroductionToTheProfessionAndLanguageSyntax._1_8_Arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
    }

    public static void task1() {
        System.out.println("Задача 1");

        int[] array1 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array1));

        double[] array2 = {1.57, 7.654, 9.986};
        System.out.println(Arrays.toString(array2));

        double[] array3 = {1.57, 7.654, 9.986}; //массив создан при помощи комбинации ctrl+d
        System.out.println(Arrays.toString(array3));
    }

    public static void task2() {
        System.out.println("Задача 2");

        int[] array1 = new int[]{1, 2, 3};
        double[] array2 = {1.57, 7.654, 9.986};
        double[] array3 = array2;

        System.out.print("Первый массив: ");
        for (int i = 0; i < array1.length - 1; i++) {
            System.out.print(array1[i] + ", ");
        }
        System.out.println(array1[array1.length - 1]);

        System.out.print("Второй массив: ");
        for (int i = 0; i < array2.length - 1; i++) {
            System.out.print(array2[i] + ", ");
        }
        System.out.println(array2[array2.length - 1]);

        System.out.print("Третий массив: ");
        for (int i = 0; i < array3.length - 1; i++) {
            System.out.print(array3[i] + ", ");
        }
        System.out.println(array3[array3.length - 1]);
    }

    public static void task3() {
        System.out.println("Задача 3");

        int[] array1 = new int[]{1, 2, 3};
        double[] array2 = {1.57, 7.654, 9.986};
        double[] array3 = array2;

        System.out.print("Первый массив: ");
        for (int i = 0; i < array1.length - 1; i++) {
            System.out.print(array1[array1.length - 1 - i] + ", ");
        }
        System.out.println(array1[0]);

        System.out.print("Второй массив: ");
        for (int i = 0; i < array2.length - 1; i++) {
            System.out.print(array2[array2.length - 1 - i] + ", ");
        }
        System.out.println(array2[0]);

        System.out.print("Третий массив: ");
        for (int i = array3.length - 1; i > 0; i--) {
            System.out.print(array3[i] + ", ");
        }
        System.out.println(array3[0]);
    }

    public static void task4() {
        System.out.println("Задача 4");
        int[] array = {1, 2, 3};

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[i]++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
