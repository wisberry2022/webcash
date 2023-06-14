import java.util.Date;

public class PersonBuilder {

    private String name;
    private String gender;
    private int age;
    private Date birth;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setBirth(Date birth) {
        this.birth = birth;
        return this;
    }

    public Person build() {
        return new Person(name, gender, age, birth);
    }


}
