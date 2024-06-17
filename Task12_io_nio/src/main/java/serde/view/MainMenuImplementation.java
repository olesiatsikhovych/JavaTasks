package serde.view;

import java.util.LinkedList;
import java.util.List;

public class MainMenuImplementation implements MainMenu {

    private List<String> menuMain;

    public MainMenuImplementation() {
        menuMain = new LinkedList<String>();
        menuMain.add("1 - Start new game");
        menuMain.add("2 - Load game");
        menuMain.add("3 - Exit game");
    }
    public void printMainMenu(){
        for (String element : menuMain)
            System.out.println(element);
    }

    public void printQuestionMainMenu(){
        System.out.println("Enter command from MainMenu");
    }
}
