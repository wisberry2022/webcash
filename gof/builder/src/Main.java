import Other.Pet;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Person inseo = new Person("inseo", "male", 28, new Date());

        System.out.println(inseo);

        Person donghyun = new PersonBuilder()
                .setName("donghyun")
                .setGender("male")
                .setAge(30)
                .setBirth(new Date())
                .build();

        System.out.println(donghyun);

        Pet choco = new Pet.PetBuilder()
                .setName("choco")
                .setAge(5)
                .setGender("female")
                .setBirth(new Date())
                .builder();

        System.out.println(choco);
    }
}