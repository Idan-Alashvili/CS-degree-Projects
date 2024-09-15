package doubleLinkedList;
import java.util.Scanner;
// Assignment: 5
// Author: Idan Alashvili, ID: 326117629
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> check = new DoubleLinkedList<>();
        check.addFirst(1);
        check.addLast(2);
        check.addLast(3);
        check.addLast(4);
        check.addLast(5);
        Scanner scanner = new Scanner(System.in);
        menu m;
        do {
            System.out.println("""
                    1: isEmpty
                    2: size
                    3: addFirst
                    4: addLast
                    5: remove
                    6: clear
                    7: contains
                    8: printForward
                    9: printBackward""");
            int choice;
            do {
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();

                if (choice < 1 || choice > 9) {
                    System.out.println("Error!");
                }
            }
            while (choice < 1 || choice > 9);

            m = menu.values()[choice - 1];

            switch (m) {
                case isEmpty:
                    if (check.isEmpty()) System.out.println("The DoubleLinked list is empty!");
                    else System.out.println("The DoubleLinked list is not empty!");
                    break;
                case size:
                    System.out.println("The DoubleLinked list size is " + check.size());
                    break;
                case addFirst:
                    System.out.println("Add the object you want to be first in DoubleLinked list.");
                    check.addFirst(scanner.nextInt());
                    break;
                case addLast:
                    System.out.println("Add the object you want to be last in DoubleLinked list.");
                    check.addLast(scanner.nextInt());
                    break;
                case remove:
                    System.out.println("Type the element you want to replace at first place in list.");
                    check.remove(scanner.nextInt());
                    System.out.println("The first element have been replaced.");
                    break;
                case clear:
                    check.clear();
                    System.out.println("The list is now clear.");
                    break;
                case contains:
                    System.out.println("Type the element you want to check in DoubleLinked list:");
                    if (check.contains(scanner.nextInt())) System.out.println("The element is in the list.");
                    else  System.out.println("The element is not in the list.");
                    break;
                case printForward:
                    check.printForward();
                    break;
                case printBackward:
                    check.printBackward();
                    break;
            }
        } while (m != menu.endProject);
    }
}

