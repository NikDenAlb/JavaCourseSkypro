package _1_IntroductionToTheProfessionAndLanguageSyntax._1_T;

import java.util.Arrays;

public class Ticket1 {
    public static void main(String[] args) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        task1();
    }

    public static void task1() {
        System.out.println("task1:");

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("Arrays.toString(reversArray(arr)) = " + Arrays.toString(reversArray(arr)));

        System.out.println("------------------------------------------------------");
    }

    static int[] reversArray(int[] arr) {
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = arr[arr.length - 1 - i];
        }
        return out;
    }
}
