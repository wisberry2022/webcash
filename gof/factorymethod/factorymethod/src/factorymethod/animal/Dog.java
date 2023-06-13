package factorymethod.animal;

public class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("bowow!");
    }

    @Override
    public void eat() {
        System.out.println("dog is eating!");
    }
}
