package animal;

import behavior.FlyBehavior;
import behavior.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack() {
        System.out.println("꽥꽥!");
    }

    public void swim() {
        System.out.println("헤엄칩니다!");
    }

    public void performFly() {
        System.out.println("오리 날다");
    }

    public abstract void display();

}
