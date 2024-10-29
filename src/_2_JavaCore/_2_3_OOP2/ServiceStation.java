package _2_JavaCore._2_3_OOP2;

public class ServiceStation {

    public void check(Bicycle vehicle) {
        System.out.println("Обслуживаем " + vehicle.getModelName());
        vehicle.service();
    }
}
