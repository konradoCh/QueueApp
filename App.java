package Projekt1;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue myQueue = new MyQueue();

        instructions();

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if ("exit".equals(command)) {
                System.out.println("This is the end of program.");
                return;
            }
            myQueue.writeCommand(command);
        }
    }

    private static void instructions() {
        System.out.println("");
        System.out.println("This is program to manage a queue.");
        System.out.println("You can add person to queue by command ADD PERSON(name_surname)");
        System.out.println("You can remove person from queue by command LEAVE PERSON(name_surname)");
        System.out.println("or You can process queue by command PROCESS");
        System.out.println("You can also add a VIP person to queue and this person goes to start of the queue - command ADD PERSON(name_surname, VIP)");
        System.out.println("Write your command or enter \"exit\" to end program: ");
    }
}
