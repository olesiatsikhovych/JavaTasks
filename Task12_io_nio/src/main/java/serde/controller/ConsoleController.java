package serde.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serde.model.Model;
import serde.view.GameMenu;
import serde.view.GameMenuImplementation;
import serde.view.MainMenu;
import serde.view.MainMenuImplementation;

import java.util.Scanner;


public class ConsoleController implements Controller {

    private static final Logger logger = LogManager.getLogger(ConsoleController.class);

    String commandMain;
    String commandGame;
    Scanner scanner = new Scanner(System.in);
    MainMenu mainMenu = new MainMenuImplementation();
    GameMenu gameMenu = new GameMenuImplementation();
    Model model;

    public ConsoleController(Model model) {
        this.model = model;
    }

    public void executeMainMenu(){
        do{
            mainMenu.printMainMenu();
            ((MainMenuImplementation) mainMenu).printQuestionMainMenu();
            commandMain = scanner.nextLine();
            chooseCommandMainMenu(commandMain);
        }
        while (!commandMain.equals("3"));
    }

    public void executeGameMenu(){
        do {
            gameMenu.printGameMenu();
            ((GameMenuImplementation) gameMenu).printQuestionGameMenu();
            commandGame = scanner.nextLine();
            chooseCommandGameMenu(commandGame);
        }
        while (!commandGame.equals("4"));
    }

    private void chooseCommandMainMenu(String commandMain){
        switch (commandMain){
            case "1":
                pressButton1Main();
                break;
            case "2":
                pressButton2Main();
                break;
            case "3":
                System.out.println("Exit app");
                break;
            default:
                System.out.println("Incorrect command");
                break;
        }
    }

    private void chooseCommandGameMenu(String commandGame){
        switch (commandGame){
            case "1":
                pressButton1GameMenu();
                break;
            case "2":
                pressButton2GameMenu();
                break;
            case "3":
                pressButton3GameMenu();
                break;
            case "4":
                System.out.println("Back to Main Menu");
                break;
            default:
                System.out.println("Incorrect command");
                break;
        }
    }

    private void pressButton1Main() {
        model.startNewGame();
        executeGameMenu();
    }

    private void pressButton2Main(){
        logger.info("Method 'loadGame' started");
        model.loadGame("game.ser");
        logger.info("Method 'loadGame' finished");
        if (model != null){
            executeGameMenu();
        }
    }

    private void pressButton1GameMenu(){
        logger.info("Method 'hitMonster' started");
        model.hitMonster();
        logger.info("Method 'hitMonster' finished");
    }

    private void pressButton2GameMenu(){
        logger.info("Method 'collectTreasures' started");
        model.collectTreasures();
        logger.info("Method 'collectTreasures' finished");
    }

    private void pressButton3GameMenu(){
        logger.info("Method 'saveGame' started");
        System.out.println(model.saveGame("game.ser"));
        logger.info("Method 'saveGame' finished");
    }
}
