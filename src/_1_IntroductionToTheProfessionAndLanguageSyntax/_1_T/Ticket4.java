package _1_IntroductionToTheProfessionAndLanguageSyntax._1_T;

import java.util.HashSet;
import java.util.Set;

public class Ticket4 {
    public static void main(String[] args) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        task4();
    }

    public static void task4() {
        System.out.println("task4:");

        System.out.println("concatUniques(new String[]{\"11\", \"22\", \"22\", \"333\", \"333\", \"333\"}) = " + concatUniques(new String[]{"11", "22", "22", "333", "333", "333"}));

        System.out.println("------------------------------------------------------");
    }

    static String concatUniques(String[] array) {
        Set<String> uniques = new HashSet<>();
        StringBuilder out = new StringBuilder();

        for (String str : array) {
            if (uniques.add(str)) {
                if (!out.isEmpty()) {
                    out.append(", ");
                }
                out.append(str);
            }
        }
        return out.toString();
    }
}
