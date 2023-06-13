package factorymethod.factory;

public class AnimalFactory {

    public static Factory createFactory(String name) {
        if(name.equals("cat")) {
            return new CatCreator();
        }else if(name.equals("dog")) {
            return new DogCreator();
        }
        return null;
    }

}
