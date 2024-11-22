package _1_IntroductionToTheProfessionAndLanguageSyntax._1_4_ConditionalOperator;

public class Main {
    public static void main(String[] args) {
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
    }

    public static void task1() {
        System.out.println("Задача 1");

        double f = Math.random() / Math.nextDown(1.0);
        double x = 122 * f;
        byte ageHuman = (byte) x;

        System.out.print("Если возраст человека равен " + ageHuman + ", то ");
        if (ageHuman >= 18) {
            System.out.println("он совершеннолетний");
        } else {
            System.out.println("он не достиг совершеннолетия, нужно подождать " + (18 - ageHuman) + " год/года/лет");
        }
    }

    public static void task2() {
        System.out.println("Задача 2");

        float pointOfCold = 5;

        double f = Math.random() / Math.nextDown(1.0);
        double x = -93.2 * (1.0 - f) + 70.7 * f;
        float temperature = (float) Math.round(x * 10) / 10;

        System.out.print("На улице " + temperature + " градус/градуса/градусов ");

        if (temperature >= pointOfCold) {
            System.out.println("можно идти без шапки");
        } else {
            System.out.println("нужно надеть шапку");
        }
    }

    public static void task3() {
        System.out.println("Задача 3");

        byte penaltySpeed = 60;

        double f = Math.random() / Math.nextDown(1.0);
        double x = 1 * (1.0 - f) + 490.484 * f;
        short vehicleSpeed = (short) Math.round(x);

        System.out.print("Если скорость " + vehicleSpeed + " км/ч, то ");

        if (vehicleSpeed <= penaltySpeed) {
            System.out.println("можно ездить спокойно");
        } else {
            System.out.println("придется заплатить штраф");
        }
    }

    public static void task4() {
        System.out.println("Задача 4");

        double f = Math.random() / Math.nextDown(1.0);
        double x = 80 * f;
        byte ageHuman = (byte) Math.round(x);

        System.out.print("Если возраст человека равен " + ageHuman + ",");

        if (ageHuman < 2) {
            System.out.println(" то ему пора спать.");
        } else if (ageHuman <= 6) {
            System.out.println(" то ему нужно ходить в детский сад.");
        } else if (ageHuman < 18) {
            System.out.println("  то ему нужно ходить в школу.");
        } else if (ageHuman < 24) {
            System.out.println("  то его место в университете");
        } else if (ageHuman == 24) {
            System.out.println(" то ему нужно искать работу.");
        } else {
            System.out.print(" то ему пора ходить на работу");
            if (ageHuman >= 65) {
                System.out.println(", но он уже может отдохнуть.");
            } else System.out.println(".");
        }
    }

    public static void task5() {
        System.out.println("Задача 5");

        double f = Math.random() / Math.nextDown(1.0);
        double x = 17 * f;
        byte ageHuman = (byte) Math.round(x);

        System.out.print("Если возраст ребенка равен " + ageHuman + ",");

        if (ageHuman < 5) {
            System.out.println(" то он не может кататься на аттракционе.");
        } else if (ageHuman < 14) {
            System.out.println(" то он может кататься на аттракционе только в сопровождении взрослого.");
        } else {
            System.out.println(" то он может кататься на аттракционе без сопровождения взрослого.");
        }
    }

    public static void task6() {
        System.out.println("Задача 6");

        short seatPlaces = 60;
        short totalPlaces = 102;

        double f = Math.random() / Math.nextDown(1.0);
        double x = 102 * f;
        short passengersNumber = (short) Math.round(x);
        short standPlaces = (short) (totalPlaces - seatPlaces);

        System.out.print("В вагоне " + passengersNumber + " пассажир/пассажира/пассажиров");

        short a;
        short b;
        String aS;
        String bS;

        if (standPlaces < seatPlaces) {

            a = standPlaces;
            b = seatPlaces;
            aS = "сидячее";
            bS = "стоячее";

            if (passengersNumber < a) {
                System.out.println(", в нём точно есть " + aS + " и " + bS + " место.");
            } else if (passengersNumber < b) {
                System.out.println(", в нём точно ещё есть " + bS + " место.");
            } else if (passengersNumber < totalPlaces) {
                System.out.println(", в нём точно ещё есть место, но, возможно, все сидячие или все стоячие места заняты.");
            } else System.out.println(". Вагон уже полностью забит");
        } else if (standPlaces > seatPlaces) {

            a = seatPlaces;
            b = standPlaces;
            aS = "стоячее";
            bS = "сидячее";

            if (passengersNumber < a) {
                System.out.println(", в нём точно есть " + aS + " и " + bS + " место.");
            } else if (passengersNumber < b) {
                System.out.println(", в нём точно ещё есть " + bS + " место.");
            } else if (passengersNumber < totalPlaces) {
                System.out.println(", в нём точно ещё есть место, но, возможно, все сидячие или все стоячие места заняты.");
            } else System.out.println(". Вагон уже полностью забит");
        } else {

            a = seatPlaces;
            aS = "стоячее";
            bS = "стоячее";

            if (passengersNumber < a) {
                System.out.println(", в нём точно есть " + aS + " и " + bS + " место.");
            } else if (passengersNumber < totalPlaces) {
                System.out.println(", в нём точно ещё есть место, но, возможно, все сидячие или все стоячие места заняты.");
            } else System.out.println(". Вагон уже полностью забит");
        }
    }

    public static void task7() {
        System.out.println("Задача 7");

        double f = Math.random() / Math.nextDown(1.0);
        double x = 3 * f;
        int one = (int) Math.round(x);

        f = Math.random() / Math.nextDown(1.0);
        x = 3 * f;
        int two = (int) Math.round(x);

        f = Math.random() / Math.nextDown(1.0);
        x = 3 * f;
        int three = (int) Math.round(x);

        System.out.println(one + " " + two + " " + three);

        if (one > two && one > three) {
            System.out.println("Наибольшее число one равно " + one);
        } else if (two > one && two > three) {
            System.out.println("Наибольшее число two равно " + two);
        } else if (three > two && three > one) {
            System.out.println("Наибольшее число three равно " + three);
        } else if (one == two && one > three) {
            System.out.println("Наибольшие числа one и two равны " + one);
        } else if (one == three && one > two) {
            System.out.println("Наибольшие числа one и three равны " + one);
        } else if (three > one) {
            System.out.println("Наибольшие числа two и three равны " + two);
        } else
            System.out.println("Все 3 числа одинаковы и равны " + three);
    }
}
