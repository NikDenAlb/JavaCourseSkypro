package _2_JavaCore._2_3_OOP2;

public class Car extends Bicycle {
    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void service() {
        super.service();
        checkEngine();
    }

    private void checkEngine() {
        System.out.println("Проверяем двигатель");
    }
}
