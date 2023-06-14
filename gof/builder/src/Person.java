import java.util.Date;

public class Person {

    private String name;
    private String gender;
    private int age;
    private Date birth;

    public Person(String name, String gender, int age, Date birth) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birth = birth;
    }

    @Override
    public String toString() {

        return "name: " + name + " " + "gender: " + gender + " " + "age: " + age + " " + "birth: " + birth;

    }

}
