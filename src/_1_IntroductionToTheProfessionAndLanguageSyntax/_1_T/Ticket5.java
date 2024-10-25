package _1_IntroductionToTheProfessionAndLanguageSyntax._1_T;

import java.util.Arrays;

public class Ticket5 {
    public static void main(String[] args) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        task5();
    }

    public static void task5() {
        System.out.println("task5:");

        System.out.println("oddAnd3to7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) = " + Arrays.toString(oddAnd3to7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));

        System.out.println("------------------------------------------------------");
    }

    static int[] oddAnd3to7(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i]++;
            }
        }
        int[] out = new int[5];
        System.arraycopy(arr, 2, out, 0, out.length);
        return out;
    }
}
