package _1_IntroductionToTheProfessionAndLanguageSyntax._1_T;

import java.util.Arrays;

public class Ticket3 {
    public static void main(String[] args) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        task3();
    }

    public static void task3() {
        System.out.println("task3:");

        System.out.println("Arrays.toString(split(\"Fregys\")) = " + Arrays.toString(split("Fregys")));
        System.out.println("Arrays.toString(split(\"12\")) = " + Arrays.toString(split("12")));
        System.out.println("Arrays.toString(split(\"123\")) = " + Arrays.toString(split("123")));

        System.out.println("------------------------------------------------------");
    }

    static String[] split(String str) {
        if (str == null || str.length() < 2) {
            throw new IllegalArgumentException("String must contain at least two characters");
        }
        String[] out = new String[2];
        out[0] = str.substring(0, str.length() / 2);
        out[1] = str.substring(str.length() / 2);
        return out;
    }
}
