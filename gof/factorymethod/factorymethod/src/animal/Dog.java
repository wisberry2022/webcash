package animal;

public class Dog implements Animal{

    @Override
    public void sound() {
        for(int i=0; i<5; i++) {
            System.out.println("Bowwow!");
        }
    }

    @Override
    public void eat() {
        System.out.println("dog is eating...");
    }
}
