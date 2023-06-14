package Other;

import java.util.Date;

public class Pet {

    private String name;
    private String gender;
    private int age;
    private Date birth;

    private Pet(String name, String gender, int age, Date birth) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birth = birth;
    }

    @Override
    public String toString() {

        return "name: " + name + " " + "gender: " + gender + " " + "age: " + age + " " + "birth: " + birth;

    }

    public static class PetBuilder {

        private String name;
        private String gender;
        private int age;
        private Date birth;

        public PetBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public PetBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PetBuilder setBirth(Date birth) {
            this.birth = birth;
            return this;
        }

        public Pet builder() {
            return new Pet(name, gender, age, birth);
        }

    }

}
