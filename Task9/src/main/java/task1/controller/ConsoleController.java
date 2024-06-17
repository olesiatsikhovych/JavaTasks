package task1.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task1.model.Model;
import task1.model.ModelLogic;
import task1.view.ConsoleView;
import task1.view.View;

import java.util.Scanner;

public class ConsoleController implements Controller {

    private static final Logger logger = LogManager.getLogger(ConsoleController.class);
    String command;
    Scanner scanner = new Scanner(System.in);
    View view = new ConsoleView();
    Model model = new ModelLogic();


    public void execute() {
        do {
            view.printMenu();
            ((ConsoleView)view).printQuestion();
            command =  scanner.nextLine();
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
            case "6":
                pressButton6();
                break;
            case "Q":
                System.out.println("Close the app");
                break;
            default:
                System.out.println("Incorrect command");
                break;
        }
    }

    private void pressButton1(){
        logger.info("Method 'get aggregated list' started");
        System.out.println("Aggregated list of words: ");
        System.out.println(model.getAggregatedList());
        logger.info("Method 'get aggregated list' finished");
    }

    private void pressButton2(){
        logger.info("Starting change language on English");
        System.out.println("Change menu language on English: ");
        view.englishMenu();
        logger.info("Printed change language on English");
    }

    private void pressButton3(){
        logger.info("Starting change language on Ukraine");
        System.out.println("Change menu language on Ukraine: ");
        view.ukraineMenu();
        logger.info("Printed change language on Ukraine");
    }

    private void pressButton4(){
        logger.info("Method'check entered word' started");
        System.out.println("Does the word start with a capital letter and end with a question mark?");
        System.out.println(model.checkEnteredWord());
        logger.info("Method'check entered word' finished");
    }

    private void pressButton5(){
        logger.info("Method 'split entered sentence' started");
        System.out.println("Split sentence on the words \"the\" or \"you\": ");
        System.out.println(model.splitEnteredSentence());
        logger.info("Method 'split entered sentence' finished");
    }

    private void pressButton6(){
        logger.info("Method 'replace all vowel words' started");
        System.out.println("Replace the vowels with undercores: ");
        System.out.println(model.replaceAllVowelWords());
        logger.info("Method 'replace all vowel words' finished");
    }
}
