package _1_IntroductionToTheProfessionAndLanguageSyntax._1_T;

public class Ticket2 {
    public static void main(String[] args) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        task2();
    }

    public static void task2() {
        System.out.println("task2:");

        System.out.println("isPalindrome(\"Кука бука\") = " + isPalindrome("Кука бука"));
        System.out.println("isPalindrome(\"3656247277\") = " + isPalindrome("3656247277"));
        System.out.println("isPalindrome(\"Фрактик киткарф\") = " + isPalindrome("Фрактик киткарф"));

        System.out.println("------------------------------------------------------");
    }

    static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is null or empty");
        }
        for (int i = 0, j = str.length() - 1; i <= j;){
            if (!Character.isAlphabetic(str.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(str.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
