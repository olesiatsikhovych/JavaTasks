package view;

import java.util.LinkedList;
import java.util.List;

public class ConsoleView implements View{

    private List<String> mainMenu;

    public ConsoleView(){
        mainMenu = new LinkedList<String>();
        mainMenu.add("1 - Start ping-pong program");
        mainMenu.add("2 - Produce a Fibonacci numbers sequence");
        mainMenu.add("3 - Produce Fibonacci sequence with Executors");
        mainMenu.add("4 - Produce Fibonacci sequence with Callable");
        mainMenu.add("5 - Create a sleeper program");
        mainMenu.add("6 - Create two communicated pipes");
        mainMenu.add("Q - Exit");
    }

    public void printMainMenu() {
        for (String element : mainMenu)
            System.out.println(element);
    }

    public void printQuestionMainMenu(){
        System.out.println("Enter command from MainMenu");
    }
}
