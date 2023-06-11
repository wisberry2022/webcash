import animal.Animal;
import factory.AnimalFactory;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Animal cat = AnimalFactory.getAnimalFactory("Cat");
        cat.sound();
        cat.eat();

        Animal dog = AnimalFactory.getAnimalFactory("Dog");
        dog.sound();
        dog.eat();

        Calendar
    }
}