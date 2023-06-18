public class Person {

    private int age;
    private String name;
    private String gender;

    public Person(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "age: " + age + " name: " + name + " gender: " + gender + "\n";
    }

}
