package _2_JavaCore._2_1_Memory;

import java.util.Arrays;

/*
Задача 1:
33. Такое значение мы присвоили переменной при инициализации и не меняли его.

Задача 2:
33. Такое значение мы присвоили переменной при инициализации и не присваивали ей другое значение.
Задачи 1 и 2 демонстрируют сохранность данных в переменных.

Задача 3:
[3, 4]. Такое значение мы присвоили переменной массива при инициализации и не присваивали ей другое значение.

Задача 4:
[99, 4]. Второе значение мы присвоили массиву при инициализации, а первое было переписано в ходе работы метода
changeValueAlt.
Задачи 3 и 4 демонстрируют, что если не менять данные в переменных, то они останутся прежними, а если изменять - примут
новое значение.

Задача 5:
Lyapis Trubetskoy. Такое значение мы присвоили полям объекта после создания и не меняли их.

Задача 5:
Ilya Lagutenko. Такое значение было присвоено полям объекта в ходе работы метода changePersonAlt.
Задачи 5 и 6 также демонстрируют, что если не менять данные в переменных, то они останутся прежними, а если изменять -
примут новое значение.
 */

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println("---------------------------------------------");
        task2();
        System.out.println("---------------------------------------------");
        task3();
        System.out.println("---------------------------------------------");
        task4();
        System.out.println("---------------------------------------------");
        task5();
        System.out.println("---------------------------------------------");
        task6();
        System.out.println("---------------------------------------------");
    }

    static void task1() {
        System.out.println("Task 1:");

        int value = 33;
        changeValue(value);
        System.out.println("value = " + value);
    }

    static void task2() {
        System.out.println("Task 2:");

        Integer value = 33;
        changeValue(value);
        System.out.println("value = " + value);
    }

    static void task3() {
        System.out.println("Task 3:");

        Integer[] value = {3, 4};
        changeValue(value);
        System.out.println("value = " + Arrays.toString(value));
    }

    static void task4() {
        System.out.println("Task 4:");

        Integer[] value = {3, 4};
        changeValueAlt(value);
        System.out.println("value = " + Arrays.toString(value));
    }

    static void task5() {
        System.out.println("Task 5:");

        Person person = new Person();
        person.setName("Lyapis");
        person.setSurname("Trubetskoy");
        changePerson(person);
        System.out.println("person = " + person);
    }

    static void task6() {
        System.out.println("Task 6:");

        Person person = new Person();
        person.setName("Lyapis");
        person.setSurname("Trubetskoy");
        changePersonAlt(person);
        System.out.println("person = " + person);
    }

    static void changeValue(int value) {
        value = 22;
    }

    static void changeValue(Integer value) {
        value = 22;
    }

    static void changeValue(Integer[] value) {
        value = new Integer[]{1, 2};
    }

    static void changeValueAlt(Integer[] value) {
        value[0] = 99;
    }

    static void changePerson(Person person) {
        person = new Person();
        person.setName("Ilya");
        person.setSurname("Lagutenko");
    }

    static void changePersonAlt(Person person) {
        person.setName("Ilya");
        person.setSurname("Lagutenko");
    }
}