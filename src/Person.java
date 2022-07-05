import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (getAge().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.getSurname());
        personBuilder.setAddress(this.getAddress());
        return personBuilder;
    }

    @Override
    public String toString() {
        return "Person:" +
                "\n name: " + name +
                "\n surname: " + surname +
                "\n age: " + age +
                "\n address: " + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return name.equals(person.name) && surname.equals(person.surname) && age == person.age && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}