package others;

/**
 * Created by dieterbiedermann on 28.08.16.
 */
public class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(this.getName() + " sagt 'Miau'");
    }
}
