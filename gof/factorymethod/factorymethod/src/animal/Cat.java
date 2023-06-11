package animal;

public class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("Meow!");
    }

    @Override
    public void eat() {
        System.out.println("cat is eating...");
    }
}
