package _2_JavaCore._2_3_OOP2;

public class Truck extends Car {

    public Truck(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void service() {
        super.service();
        checkTrailer();
    }

    private void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}
