package factorymethod.factory;

import factorymethod.animal.Animal;
import factorymethod.animal.Dog;

public class DogCreator implements Factory {

    @Override
    public Animal creator() {
        return new Dog();
    }
}
