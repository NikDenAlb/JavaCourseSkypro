package _1_IntroductionToTheProfessionAndLanguageSyntax._1_3_Variables2;

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
        System.out.println();
        task8();
    }

    public static void task1() {
        System.out.println("Задача 1");

        double f = Math.random() / Math.nextDown(1.0);
        double x = -2147483648 * (1.0 - f) + 2147483647 * f;
        int intExample = (int) x;

        f = Math.random() / Math.nextDown(1.0);
        x = -128 * (1.0 - f) + 127 * f;
        byte byteExample = (byte) x;

        f = Math.random() / Math.nextDown(1.0);
        x = -32768 * (1.0 - f) + 32767 * f;
        short shortExample = (short) x;

        f = Math.random() / Math.nextDown(1.0);
        x = -9223472036854775808d * (1.0 - f) + 9223472036854775807d * f;
        long longExample = (long) x;

        float floatExample = (float) Math.random();

        double doubleExample = Math.random();

        System.out.println("Значение переменной intExample с типом int равно " + intExample);
        System.out.println("Значение переменной byteExample с типом byte равно " + byteExample);
        System.out.println("Значение переменной shortExample с типом short равно " + shortExample);
        System.out.println("Значение переменной longExample с типом long равно " + longExample);
        System.out.println("Значение переменной floatExample с типом float равно " + floatExample);
        System.out.println("Значение переменной doubleExample с типом double равно " + doubleExample);
    }

    public static void task2() {
        System.out.println("Задача 2");

        var a1 = 27.12f;
        var a2 = 987678965549L;
        var a3 = 2.786f;
        short a4 = 569;
        short a5 = -159;
        short a6 = 27897;
        byte a7 = 67;

        System.out.println("Инициализирована переменная a1 с типом float и значением " + a1);
        System.out.println("Инициализирована переменная a2 с типом long и значением " + a2);
        System.out.println("Инициализирована переменная a3 с типом float и значением " + a3);
        System.out.println("Инициализирована переменная a4 с типом short и значением " + a4);
        System.out.println("Инициализирована переменная a5 с типом short и значением " + a5);
        System.out.println("Инициализирована переменная a6 с типом short и значением " + a6);
        System.out.println("Инициализирована переменная a7 с типом byte и значением " + a7);
    }

    public static void task3() {
        System.out.println("Задача 3");

        byte class1Students = 23; //Людмила Павловна
        byte class2Students = 27; //Анна Сергеевна
        byte class3Students = 30; //Екатерина Андреевна

        short totalPaperLists = 480;
        byte classNumbers = 3;

        short classPaperLists = (short) (totalPaperLists / classNumbers);
        byte extraClassesPaperLists = (byte) (totalPaperLists % classNumbers);
        System.out.println("Каждому классу досталось " + classPaperLists + " листов. При этом запасных осталось " + extraClassesPaperLists);

        short studentClass1PaperLists = (short) (classPaperLists / class1Students);
        byte extraClass1PaperLists = (byte) (classPaperLists % class1Students);
        System.out.println("На каждого ученика 1-го класса рассчитано " + studentClass1PaperLists + " листов. При этом запасных имеется " + extraClass1PaperLists);
        short studentClass2PaperLists = (short) (classPaperLists / class2Students);
        byte extraClass2PaperLists = (byte) (classPaperLists % class2Students);
        System.out.println("На каждого ученика 2-го класса рассчитано " + studentClass2PaperLists + " листов. При этом запасных имеется " + extraClass2PaperLists);
        short studentClass3PaperLists = (short) (classPaperLists / class3Students);
        byte extraClass3PaperLists = (byte) (classPaperLists % class3Students);
        System.out.println("На каждого ученика 3-го класса рассчитано " + studentClass3PaperLists + " листов. При этом запасных имеется " + extraClass3PaperLists);
    }

    public static void task4() {
        System.out.println("Задача 4");

        float baseProdTimeMin = 2;
        float baseProdBottles = 16;

        float speedBottlesPerMin = baseProdBottles / baseProdTimeMin;

        System.out.println("За 20 минут машина произвела " + (int) speedBottlesPerMin * 20 + " штук бутылок");
        System.out.println("За сутки машина произвела " + (int) speedBottlesPerMin * 60 * 24 + " штук бутылок");
        System.out.println("За 3 дня машина произвела " + (int) speedBottlesPerMin * 60 * 24 * 3 + " штук бутылок");
        System.out.println("За 1 месяц из 28 дней машина произвела " + (int) speedBottlesPerMin * 60 * 24 * 28 + " штук бутылок");
        System.out.println("За 1 месяц из 29 дней машина произвела " + (int) speedBottlesPerMin * 60 * 24 * 29 + " штук бутылок");
        System.out.println("За 1 месяц из 30 дней машина произвела " + (int) speedBottlesPerMin * 60 * 24 * 30 + " штук бутылок");
        System.out.println("За 1 месяц из 31 дня машина произвела " + (int) speedBottlesPerMin * 60 * 24 * 31 + " штук бутылок");
    }

    public static void task5() {
        System.out.println("Задача 5");

        short totalTin = 120;
        byte whiteTinPerClass = 2;
        byte brownTinPerClass = 4;

        byte classNumber = (byte) (totalTin / (whiteTinPerClass + brownTinPerClass));
        short totalWhiteTin = (short) (classNumber * whiteTinPerClass);
        short totalBrownTin = (short) (classNumber * brownTinPerClass);

        System.out.println("В школе, где " + classNumber + " классов, нужно " + totalWhiteTin + " банок белой краски и " + totalBrownTin + " банок коричневой краски");
    }

    public static void task6() {
        System.out.println("Задача 6");

        float bananaWeightGram = 80;
        float milk100mlWeightGram = 105;
        float iceCreamBriquetteWeightGram = 100;
        float rawEggWeightGram = 70;

        byte bananaNumber = 5;
        float milk100mlNumber = 2;
        byte iceCreamBriquetteNumber = 2;
        byte rawEggNumber = 4;

        float totalWeightGram = bananaWeightGram * bananaNumber + milk100mlWeightGram * milk100mlNumber + iceCreamBriquetteWeightGram * iceCreamBriquetteNumber + rawEggWeightGram * rawEggNumber;
        float totalWeightKilo = totalWeightGram / 1000;
        System.out.println("Вес завтрака составляет " + totalWeightGram + " грамм или " + totalWeightKilo + " килограмм");
    }

    public static void task7() {
        System.out.println("Задача 7");

        int weightToLoseGram = 7000;
        short dailyLightWeightLoseGram = 250;
        short dailyHardWeightLoseGram = 500;

        short daysLightWay = (short) Math.ceil((float) weightToLoseGram / dailyLightWeightLoseGram);
        System.out.println("Если худеть по " + dailyLightWeightLoseGram + " г в день, похудение займёт " + daysLightWay + " дней");

        short daysHardWay = (short) Math.ceil((float) weightToLoseGram / dailyHardWeightLoseGram);
        System.out.println("Если худеть по " + dailyHardWeightLoseGram + " г в день, похудение займёт " + daysHardWay + " дней");

        float dailyMiddleWeightLoseGram = ((float) dailyHardWeightLoseGram + dailyLightWeightLoseGram) / 2;
        short daysMiddleWay = (short) Math.ceil(weightToLoseGram / dailyMiddleWeightLoseGram);
        System.out.println("В среднем похудение займёт " + daysMiddleWay + " дней");
    }

    public static void task8() {
        System.out.println("Задача 8");

        int currentSalaryMasha = 6776000;
        int currentSalaryDenis = 8369000;
        int currentSalaryKristy = 7623000;
        float salaryIncrease = 0.1f;

        int newSalaryMasha = (int) Math.ceil(currentSalaryMasha + currentSalaryMasha * salaryIncrease);
        int newSalaryDenis = (int) Math.ceil(currentSalaryDenis + currentSalaryDenis * salaryIncrease);
        int newSalaryKristy = (int) Math.ceil(currentSalaryKristy + currentSalaryKristy * salaryIncrease);

        System.out.println("Зарплата Маши после повышения составит " + (float) newSalaryMasha / 100 + " рублей");
        System.out.println("Зарплата Дениса после повышения составит " + (float) newSalaryDenis / 100 + " рублей");
        System.out.println("Зарплата Кристины после повышения составит " + (float) newSalaryKristy / 100 + " рублей");

        int currentYearIncomeMasha = currentSalaryMasha * 12;
        int currentYearIncomeDenis = currentSalaryDenis * 12;
        int currentYearIncomeKristy = currentSalaryKristy * 12;

        int newYearIncomeMasha = newSalaryMasha * 12;
        int newYearIncomeDenis = newSalaryDenis * 12;
        int newYearIncomeKristy = newSalaryKristy * 12;

        System.out.println("Годовой доход Маши после повышения вырос на " + (float) (newYearIncomeMasha - currentYearIncomeMasha) / 100 + " рублей");
        System.out.println("Годовой доход Дениса после повышения вырос на " + (float) (newYearIncomeDenis - currentYearIncomeDenis) / 100 + " рублей");
        System.out.println("Годовой доход Кристины после повышения вырос на " + (float) (newYearIncomeKristy - currentYearIncomeKristy) / 100 + " рублей");
    }
}