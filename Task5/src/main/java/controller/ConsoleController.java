package controller;

import model.Product;
import model.ProductLogic;
import view.ConsoleView;
import view.View;

import java.util.LinkedList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleController implements Controller {
    String command;
    View view = new ConsoleView();
    Scanner scanner = new Scanner(System.in);
    ProductLogic productLogic = new ProductLogic();
   private static final Logger logger = LogManager.getLogger(ConsoleController.class);

    public void execute() {
        do{
            view.printMenu();
            view.printQuestion();
           command = scanner.nextLine();
           logger.debug("Введена команда: {}", command);
            chooseCommand(command);
        }
        while (!command.equals("Q"));

    }

    private void chooseCommand(String command){
        switch (command){
            case "1":
                pressButton1();
                logger.info("Натиснуто кнопку 1");
                break;
            case "2":
                pressButton2();
                logger.info("Натиснуто кнопку 2");
                break;
            case "3":
                pressButton3();
                logger.info("Натиснуто кнопку 3");
                break;
            case "4":
                pressButton4();
                logger.info("Натиснуто кнопку 4");
                break;
            case "5":
                pressButton5();
                logger.info("Натиснуто кнопку 5");
                break;
            case "Q":
                System.out.println("Exit");
                logger.info("Вихід");
                break;
            default:
                logger.warn("Невірна команда: {}",command);
                System.out.println("Incorrect command");
        }
    }

    private void pressButton1(){
        System.out.println("Please, add new product to list");
        System.out.println("Name(String):");
        String name = scanner.nextLine();
//        logger.debug("Виклик методу pressButton1");
          logger.trace("Повідомлення рівня trace");
          logger.debug("Повідомлення рівня debug");
          logger.info("Повідомлення рівня info");
          logger.warn("Повідомлення рівня warn");
          logger.error("Повідомлення рівня error");
          logger.fatal("Повідомлення рівня fatal");
        System.out.println("Price(Integer):");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Amount(Integer):");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Id(Integer):");
        int id = Integer.parseInt(scanner.nextLine());
        productLogic.addNewProduct(name, price, amount, id);
        logger.info("Додано новий продукт: {}", name);
    }

    private void pressButton2(){
        logger.debug("Виклик методу pressButton2");
        printCollection(productLogic.getProductList());
        logger.info("Виведено список продуктів");
    }

    private void pressButton3(){
        logger.debug("Виклик методу pressButton3");
        printCollection(productLogic.sortProductListByPrice());
        logger.info("Відсортовано список продктів за ціною");
    }

    private void pressButton4(){
        logger.debug("Виклик методу pressButton4");
        printCollection(productLogic.sortProductListByAmount());
        logger.info("Відсортовано список продуктів за кількістю");
    }

    private void pressButton5(){
        logger.debug("Виклик методу pressButton5");
        productLogic.createProductFile();
        logger.info("Створено файл зі списком продуктів");
    }

    private void printCollection(LinkedList<Product> products){
        logger.debug("Виклик методу printCollection");
        for( Product product : products){
        System.out.println(product);
}
        logger.info("Виведено колекцію продуктів");
    }

}
