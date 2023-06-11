package factory;

import animal.Animal;
import animal.Cat;
import animal.Dog;

public class AnimalFactory {

    public static Animal getAnimalFactory(String type) {
        if(type.equals("Cat")) {
            return new Cat();
        }else if(type.equals("Dog")) {
            return new Dog();
        }
        return null;
    }

}
