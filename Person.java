package Projekt1;

public class Person implements Comparable<Person> {
    private final String name;
    private final String surname;
    private final int counter;
    private boolean isVip;

    public Person(String name, String surname, int counter) {
        this(name, surname, counter, false);
    }

    public Person(String name, String surname, int counter, boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVip = isVip;
    }

    @Override
    public int compareTo(Person person) {
        int value = Boolean.compare(person.isVip, this.isVip);
        if (value != 0) {
            return value;
        }
        return 0;
    }

    @Override
    public String toString() {
        String person = name + "_" + surname + "_" + counter;
        if (isVip == true) {
            return person + "_VIP";
        }
        return person;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCounter() {
        return counter;
    }
}
