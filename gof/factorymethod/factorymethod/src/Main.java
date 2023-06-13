import factorymethod.animal.Animal;
import factorymethod.factory.AnimalFactory;
import factorymethod.factory.CatCreator;
import factorymethod.factory.Factory;

public class Main {
    public static void main(String[] args) {

        CatCreator catManager = (CatCreator)AnimalFactory.createFactory("cat");
        Animal cat = catManager.creator();

        Animal cat2 = catManager.creator();

        int num = catManager.getCreateNum();
        
        cat.eat();
        cat.sound();
        System.out.println("고양이가 생성된 수 " + num);

       Factory dogManager = AnimalFactory.createFactory("dog");
       Animal dog = dogManager.creator();
       dog.eat();
       dog.sound();

    }
}