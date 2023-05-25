package controller;

import model.Product;
import model.ProductLogic;
import view.ConsoleView;
import view.View;

import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleController implements Controller {
    String command;
    View view = new ConsoleView();
    Scanner scanner = new Scanner(System.in);
    ProductLogic productLogic = new ProductLogic();

    public void execute() {
        do{
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
            case "4":
                pressButton4();
                break;
            case "5":
                pressButton5();
                break;
            case "Q":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Incorrect command");

        }
    }

    private void pressButton1(){
        System.out.println("Please, add new product to list");
        System.out.println("Name(String):");
        String name = scanner.nextLine();
        System.out.println("Price(Integer):");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Amount(Integer):");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Id(Integer):");
        int id = Integer.parseInt(scanner.nextLine());
        productLogic.addNewProduct(name, price, amount, id);
    }

    private void pressButton2(){
        printCollection(productLogic.getProductList());
    }

    private void pressButton3(){
printCollection(productLogic.sortProductListByPrice());
    }

    private void pressButton4(){
printCollection(productLogic.sortProductListByAmount());
    }

    private void pressButton5(){
productLogic.createProductFile();
    }

    private void printCollection(LinkedList<Product> products){
for( Product product : products){
    System.out.println(product);
}
    }

}
