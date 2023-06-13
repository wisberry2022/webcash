package factorymethod.animal;

public class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("meow~");
    }

    @Override
    public void eat() {
        System.out.println("cat is eating!");
    }
}
