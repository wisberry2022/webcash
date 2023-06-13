package factorymethod.factory;

import factorymethod.animal.Animal;
import factorymethod.animal.Cat;

public class CatCreator implements Factory {

    private static int createNum = 0;

    @Override
    public Animal creator() {
        createNum++;
        return new Cat();
    }

    public int getCreateNum() {
        return createNum;
    }
}
