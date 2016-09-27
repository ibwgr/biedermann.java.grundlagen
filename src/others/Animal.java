package others;

/**
 * Created by dieterbiedermann on 28.08.16.
 */
public class Animal {
    String name;

    Animal(String name){
        setName(name);
    }

    public void makeSound(){

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
