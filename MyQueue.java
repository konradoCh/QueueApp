package Projekt1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class MyQueue {

    private final ArrayDeque<Person> myQueue = new ArrayDeque<>();
    private final ArrayDeque<Person> myVipQueue = new ArrayDeque<>();

    public void writeCommand(String command) {
        if (command.contains("ADD PERSON")) {
            System.out.println(command);
            add_person(command.substring(command.indexOf('(') + 1, command.indexOf(')')));
            System.out.println();
        } else if (command.contains("PROCESS")) {
            System.out.println(command);
            process();
            System.out.println();
        } else if (command.contains("LEAVE PERSON")) {
            System.out.println(command);
            leave(command.substring(command.indexOf('(') + 1, command.indexOf(')')));
            System.out.println();
        } else {
            System.out.println("Wrong command, try again.");
        }
    }

    public void add_person(String person) {
        Person person1;
        if (person.contains("VIP")) {
            person1 = createVipPerson(person);
            System.out.println(person1 + " came to the queue: " + myVipQueue.offer(person1));
        } else {
            person1 = createPerson(person);
            System.out.println(person1 + " came to the queue: " + myQueue.offer(person1));
        }
        printQueue();
    }

    public void leave(String person) {
        if (person.charAt(person.length() - 2) != '_') {
            person = person + "_1";
        }
        for (Person person1 : myQueue) {
            if (person1.toString().equals(person)) {
                myQueue.remove(person1);
                System.out.println("Leaving queue: " + person);
                printQueue();
                return;
            }
        }
        System.out.println(person + " is not in the queue.");
    }

    public void process() {
        if (myQueue.isEmpty() && myVipQueue.isEmpty()) {
            System.out.println("No items in the queue.");
            return;
        }
        if (!myVipQueue.isEmpty()) {
            System.out.println("Processing queue: " + myVipQueue.poll() + " arrived at the store");
        } else {
            System.out.println("Processing queue: " + myQueue.poll() + " arrived at the store");
        }
        printQueue();
    }

    public void printQueue() {
        List<Person> connectedList = new LinkedList<>(myVipQueue);
        connectedList.addAll(myQueue);
        System.out.println("Queue: " + connectedList);
    }

    private Person createPerson(String person){
        if (!person.contains("_")) {
            throw new IllegalArgumentException("Illegal argument: " + person);
        }
        int counter = 1;
        String name = person.substring(0, person.indexOf('_'));
        String surName = person.substring(person.indexOf('_') + 1);

        if (myQueue.isEmpty()) {
            return new Person(name, surName, counter);
        }

        for (Person person1 : myQueue) {
            if (person1.getName().equals(name) && person1.getSurname().equals(surName)) {
                counter = person1.getCounter() + 1;
            }
        }
        return new Person(name, surName, counter);
    }

    private Person createVipPerson(String person) {
        int counter = 1;
        String name = person.substring(0, person.indexOf('_'));
        String surName = person.substring(person.indexOf('_') + 1, person.indexOf(','));

        for (Person person1 : myQueue) {
            if (person1.getName().equals(name) && person1.getSurname().equals(surName)) {
                counter = person1.getCounter() + 1;
            }
        }
        return new Person(name, surName, counter, true);
    }
}
