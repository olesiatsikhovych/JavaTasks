package controller;

import model.Model;
import model.ModelLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.ConsoleView;
import view.View;

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
            ((ConsoleView) view).printQuestion();
            command = scanner.nextLine();
            chooseCommand(command);
        }
        while (!command.equals("Q"));
    }

    private void chooseCommand(String command) {
        switch (command) {
            case "1":
                pressButton1();
                break;
            case "2":
                pressButton2();
                break;
            case "Q":
                System.out.println("Close the app");
                break;
        }
    }

    private void pressButton1() {
        logger.info("Method 'createAnnotation' started");
        model.createAnnotation();
        logger.info("Method 'createAnnotation' finished");
    }

    private void pressButton2() {
        logger.info("Method 'invokeThreeMethods' started");
        model.invokeThreeMethods();
        logger.info("Method 'invokeThreeMethods' finished");
    }
}
