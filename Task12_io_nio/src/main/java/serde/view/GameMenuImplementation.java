package serde.view;

import java.util.LinkedList;
import java.util.List;

public class GameMenuImplementation implements GameMenu {

    private List<String> menuGame;

    public GameMenuImplementation(){
        menuGame = new LinkedList<String>();
        menuGame.add("1 - Hit monster");
        menuGame.add("2 - Collect treasures");
        menuGame.add("3 - Save game");
        menuGame.add("4 - Back to Main Menu");
    }

    public void printGameMenu() {
        for (String element : menuGame)
            System.out.println(element);
    }

    public void printQuestionGameMenu(){
        System.out.println("Enter command from GameMenu");
    }
}
