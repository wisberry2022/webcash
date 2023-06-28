package animal;

public class RubberDuck extends Duck {

    @Override
    public void quack() {
        System.out.println("꽥꽥 소리가 나지 않습니다");
    }

    @Override
    public void fly() {
        System.out.println("날지 않습니다!");
    }

    @Override
    public void display() {
        System.out.println("C 모양입니다!");
    }
}
