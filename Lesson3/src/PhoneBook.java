import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan Chaykin
 * Date: 23.12.2018
 * Time: 13:44
 */
public class PhoneBook {

    HashMap<String, List<Person>> phonebook = new HashMap<>();

    public void add(String lastName, String firstName, String phoneNumber){
        Person person = new Person(lastName, firstName, phoneNumber);
        List<Person> personList = new ArrayList<>();
        if (phonebook.containsKey(lastName)) {
            personList = phonebook.get(lastName);
        }
        personList.add(person);
        phonebook.put(lastName, personList);
    }

    public void get(String lastName){
        List<Person> personList = phonebook.get(lastName);
        personList.forEach(System.out::println);
    }

}
