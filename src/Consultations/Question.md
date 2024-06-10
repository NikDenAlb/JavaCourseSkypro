## Список вопросов для консультации

---
### Вопрос 1
Тернарный оператор. Как правильно оформить задачу? Тернарный оператор не получается нормально конкатенировать,
складывается впечатление, что хранить большие строчки будет выгоднее для читабельности
```java
    public static void method2(int clientOS, int clientDeviceYear) {
    int yearNow = YearMonth.now().getYear();
    if (clientDeviceYear > yearNow || clientDeviceYear < 2000) {
        throw new IllegalArgumentException("Неподходящее значение, выберите существующий год производства вашего устройства");
    }
    if (clientOS != 0 && clientOS != 1) {
        throw new IllegalArgumentException("Неподходящее значение, выберите 0 или 1");
    }
    if (clientOS == 0) {
        System.out.println(clientDeviceYear < 2015
                ? "Установите облегченную версию приложения для iOS по ссылке"
                : "Установите версию приложения для iOS по ссылке");
    } else {
        System.out.println(clientDeviceYear < 2015
                ? "Установите облегченную версию приложения для Android по ссылке"
                : "Установите версию приложения для Android по ссылке");
    }
}
```
```java
    public static void method1(int clientOS) {
    if (clientOS != 0 && clientOS != 1) {
        throw new IllegalArgumentException("Неподходящее значение, выберите 0 или 1");
    }
    System.out.print("Установите версию приложения для ");
    System.out.println(clientOS == 0
            ? "iOS по ссылке"
            : "Android по ссылке");
}
```
---
### Вопрос 2
Error: Could not find or load main class ?onsultations.Main

Caused by: java.lang.ClassNotFoundException: ?onsultations.Main

---
### Вопрос 3
task3(). Почему предупреждение на ```int number```?