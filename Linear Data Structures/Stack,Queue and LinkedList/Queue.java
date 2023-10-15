import java.util.Scanner;
import java.util.List;


public class Queue {
    static LinkedList list;

    Queue() {
        list = new LinkedList();
    }
    public static void Enqueue(int x) {
        LinkedList.Node newNode = new LinkedList.Node(x);
        newNode.next=list.head;
        list.head = newNode;

    }






    public static void main(String[] args) {
        //create a new list
        Queue queue = new Queue();

        //Create variable to read from keyboard
        Scanner in = new Scanner(System.in);
        int option, x;

        do {
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Insert an element to the beginning of the stack");
            System.out.println("2: remove the the first element of the stack");
            System.out.println("3: What number is the head of your stack?");
            System.out.println("4: Is the stack empty?");

            option = in.nextInt();
            if (option == 1) {
                System.out.println("What number do you want to insert?");
                x = in.nextInt();
                queue.Enqueue(x);


            }
            if(option == 2) {

            }
            if(option == 3) {
            }
            if(option == 4) {
            }

        } while (option != 0);
    }
}
