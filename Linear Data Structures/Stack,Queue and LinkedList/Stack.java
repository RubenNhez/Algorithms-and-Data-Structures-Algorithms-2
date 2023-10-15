//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Stack {

    static LinkedList list;

    Stack() {
        list = new LinkedList();
    }

    public static void push(int x) {
        LinkedList.Node newNode = new LinkedList.Node(x);
        newNode.next=list.head;
        list.head = newNode;
    }
    public static void pop() {
        if(list.head == null) {
            System.out.println("The stack is empty");
        }
            else {
                list.head = list.head.next;
            }
    }
    public static void peek() {
        if(list.head == null) {
            System.out.println("The stack is empty");
        }
        else {
                System.out.println("The last element inserted in the stack is " + list.head.data);
        }
    }
    public static boolean isEmpty() {
        boolean Empty = false;
        if(list.head == null) {
            Empty = true;
            System.out.println("Is the stack empty " + Empty);
        }
        else {
            Empty = false;
            System.out.println("Is the stack empty " + Empty);
        }
        return Empty;
    }

        //Stack Implementation
//        public static LinkedList push(LinkedList list, int data) {
//            // We create the new node
//            Node newNode = new Node(data);
//
//            //Now we link the node to the list
//            newNode.next = list.head;
//            list.head = newNode;
//
//            // Return the modified list
//            return list;
//        }
//        public static LinkedList pop(LinkedList list) {
//            if(list.head == null){
//                System.out.println("Stack is empty");
//
//            }
//            else{
//                list.head = list.head.next;
//            }
//            return list;
//        }
//        public static LinkedList peek(LinkedList list) {
//            if(list.head == null){
//                System.out.println("Stack is empty");
//
//            }
//            else {
//                System.out.println("The last element inserted in the stack is " + list.head.data);
//            }
//            return list;
//        }



        public static void main(String[] args) {
            //create a new list
            Stack stack = new Stack();

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
                    stack.push(x);
                    stack.list.printList(list);
                }
                if(option == 2) {
                    stack.pop();
                    stack.list.printList(list);
                }
                if(option == 3) {
                    stack.peek();
                }
                if(option == 4) {
                    stack.isEmpty();
                }

            } while (option != 0);
        }

    }
