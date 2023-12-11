package view;

import java.util.ArrayList;
import java.util.List;

public class ConsoleView implements View {
    private List<String> menu;

    public ConsoleView(){
        menu = new ArrayList<String>();
        menu.add("1 - create annotation");
        menu.add("2 - invoke three methods via reflection API");
        menu.add("Q - Quit");
    }

    public void printMenu() {
        for (String element : menu)
            System.out.println(element);
    }

    public void printQuestion(){
        System.out.println("Enter command:");
    }
}
