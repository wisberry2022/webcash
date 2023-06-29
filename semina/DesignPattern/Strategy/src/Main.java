import animal.Duck;
import animal.MallardDuck;
import animal.ModelDuck;
import behavior.FlyRocketPowered;

public class Main {
    public static void main(String[] args) {

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

    }
}