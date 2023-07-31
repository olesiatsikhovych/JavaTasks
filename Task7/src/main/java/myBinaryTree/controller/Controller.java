package myBinaryTree.controller;

import myBinaryTree.model.Cat;
import myBinaryTree.model.MyBinaryTree;
import myBinaryTree.view.View;

import java.util.Scanner;

public class Controller {
    String command;
    Scanner scanner = new Scanner(System.in);
    View view = new View();
    MyBinaryTree myBinaryTree = new MyBinaryTree();

    public void execute(){
        do {
            view.printMenu();
            view.printQuestion();
            command = scanner.nextLine();
            chooseCommand(command);
        }
        while (!command.equals("Q"));
    }

    private void chooseCommand(String command){
        switch (command){
            case "1":
                pressButton1();
                break;
            case "2":
                pressButton2();
                break;
            case "3":
                pressButton3();
                break;
            case "Q":
                System.out.println("Exit");
                break;
            default:
                System.out.println("You entered incorrect command");
                break;
        }
    }

    private void pressButton1(){
        System.out.println("Enter cat id number");
        int catId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter cat name");
        String catName = scanner.nextLine();
        System.out.println("Enter cat age");
        int catAge = Integer.parseInt(scanner.nextLine());
        Cat cat = new Cat(catName, catAge);
        myBinaryTree.put(catId, cat);
    }

    private void pressButton2(){
        System.out.println("Enter cat id number");
        int catId = Integer.parseInt(scanner.nextLine());
        System.out.println(myBinaryTree.get(catId));
    }

    private void pressButton3(){
        System.out.println("Enter cat id number");
        int catId = Integer.parseInt(scanner.nextLine());
        myBinaryTree.remove(catId);
    }
}
