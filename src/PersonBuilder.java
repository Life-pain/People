
public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    @Override
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        if (age >= 0) this.age = age;
        else
            throw new IllegalArgumentException("Некорректно введён возраст");
        return this;
    }

    @Override
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name == null) throw new IllegalStateException("Имя человека не введено.");
        if (surname == null) throw new IllegalStateException("Фамилия человека не введена.");
        Person person = null;
        if (age > 0) person = new Person(name, surname, age);
        else
            person = new Person(name, surname);
        if (address != null) person.setAddress(address);
        return person;
    }
}
