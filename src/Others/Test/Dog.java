package Others.Test;

/**
 * Created by dieterbiedermann on 28.08.16.
 */
public class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(this.getName() + " sagt 'Wau'");
    }
}

