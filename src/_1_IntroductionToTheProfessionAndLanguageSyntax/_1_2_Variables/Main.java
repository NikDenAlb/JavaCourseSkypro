package _1_IntroductionToTheProfessionAndLanguageSyntax._1_2_Variables;

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
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;
        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
    }

    public static void task2() {
        System.out.println("Задача 2");
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;
        dog += 4;
        cat += 4;
        paper += 4;
        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
    }

    public static void task3() {
        System.out.println("Задача 3");
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;
        dog -= 3.5;
        cat -= 1.6;
        paper -= 7639;
        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
    }

    public static void task4() {
        System.out.println("Задача 4");
        var friend = 19;
        System.out.println("Инициализация: friend = " + friend);
        friend += 2;
        System.out.println("Увеличение на 2: friend = " + friend);
        friend /= 7;
        System.out.println("Деление на 7: friend = " + friend);
    }

    public static void task5() {
        System.out.println("Задача 5");
        var frog = 3.5;
        System.out.println("Инициализация: frog = " + frog);
        frog *= 10;
        System.out.println("Умножение на 10: frog = " + frog);
        frog /= 3.5;
        System.out.println("Деление на 3.5: frog = " + frog);
        frog += 4;
        System.out.println("Увеличение на 4: frog = " + frog);
    }

    public static void task6() {
        System.out.println("Задача 6");
        var aBoxerWeight = 78.2;
        var bBoxerWeight = 82.7;

        var totalWeight = aBoxerWeight + bBoxerWeight;
        System.out.println("Общий вес двух бойцов " + totalWeight + " кг");

        var weightDifference = aBoxerWeight - bBoxerWeight;
        System.out.println("Вес боксёра A больше веса боксёра B на " + weightDifference + " кг");
    }

    public static void task7() {
        System.out.println("Задача 7");
        var aBoxerWeight = 78.2;
        var bBoxerWeight = 82.7;

        var WeightDifferenceAB = aBoxerWeight % bBoxerWeight;
        System.out.println("Остаток от деления веса боксёра b на вес боксёра a: " + WeightDifferenceAB + " кг");

        var WeightDifferenceBA = bBoxerWeight % aBoxerWeight;
        System.out.println("Остаток от деления веса боксёра a на вес боксёра b: " + WeightDifferenceBA + " кг");

        //С операцией % в курсе знакомят неудачно. Как в лекциях, так и на примере этой задачи.
    }

    public static void task8() {
        System.out.println("Задача 8");
        var totalWorkTime = 640;
        var workingHours = 8;

        var numberEmployees = totalWorkTime / workingHours;
        System.out.println("Всего работников в компании — " + numberEmployees + " человек");

        var addNumberEmployees = 94;
        var imagineNumberEmployees = numberEmployees + addNumberEmployees;
        var imagineTotalWorkTime = imagineNumberEmployees * workingHours;
        System.out.println("Если в компании работает " + imagineNumberEmployees + " человек, то всего " + imagineTotalWorkTime + " часов работы может быть поделено между сотрудниками");

        //Задача сделана из желания продемонстрировать более серьёзные вычисления. На данном этапе вообще не стоит так делать.
    }
}