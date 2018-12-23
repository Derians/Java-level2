/**
 * Created by Ivan Chaykin
 * Date: 23.12.2018
 * Time: 13:37
 */
public class Person {

    private String LastName;
    private String FirstName;
    private String PhoneNumber;

    public Person(String lastName, String firstName, String phoneNumber) {
        LastName = lastName;
        FirstName = firstName;
        PhoneNumber = phoneNumber;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    @Override
    public String toString() {
        return LastName + " " + FirstName + ", PhoneNumber = " + PhoneNumber;
    }
}
