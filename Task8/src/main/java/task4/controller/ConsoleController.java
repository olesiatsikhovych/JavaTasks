package task4.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task4.model.Model;
import task4.model.ModelLogic;
import task4.view.ConsoleView;
import task4.view.View;

import java.util.Scanner;

public class ConsoleController implements Controller{

    private static final Logger logger = LogManager.getLogger(ConsoleController.class);
    String command;
    Scanner scanner = new Scanner(System.in);
    View view = new ConsoleView();
    Model model = new ModelLogic();


    @Override
    public void execute() {
       model.enterWords();
        logger.info("Input words: " + model.getEnteredWordsList());
        do {
            view.printMenu();
            ((ConsoleView) view).printQuestion();
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
            case "Q":
                System.out.println("Close the app");
                break;
            default:
                logger.error("Incorrect command");
                break;
        }
    }

    private void pressButton1(){
        logger.info("List of unique words started");
        System.out.println("List of unique words: ");
        System.out.println(model.uniqueWords());
        logger.info("List of unique words finished");
    }

    private void pressButton2(){
        logger.info("Sorted list of unique words started");
        System.out.println("Sorted list of unique words: ");
        System.out.println(model.sortedListUniqueWords());
        logger.info("Sorted list of unique words finished");
    }

    private void pressButton3(){
        logger.info("Number of words started");
        System.out.println("Number of words: ");
        System.out.println(model.numberWords());
        logger.info("Number of words finished");
    }

    private void pressButton4(){
        logger.info("Number of each character started");
        System.out.println("Number of each character: ");
        System.out.println(model.numberCharacter());
        logger.info("Number of each character finished");
    }
}
