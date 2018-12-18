/**
 * Created by Ivan Chaykin
 * Date: 11.12.2018
 * Time: 11:31
 */
public class Person {

    private String name;

    private double swimSpeed;
    private double runSpeed;
    private double jumpLength;

    Person(String name, double swimSpeed, double runSpeed, double jumpLength) {
        this.name = name;
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.jumpLength = jumpLength;
    }

    public String getName() {
        return name;
    }

    public double getSwimSpeed() {
        return swimSpeed;
    }

    public double getRunSpeed() {
        return runSpeed;
    }

    public double getJumpLength() {
        return jumpLength;
    }
}
