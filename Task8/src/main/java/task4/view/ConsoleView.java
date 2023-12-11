package task4.view;

import java.util.LinkedList;
import java.util.List;

public class ConsoleView implements View{
    private List<String> menu;

    public ConsoleView(){
        menu = new LinkedList<>();
        menu.add("1 - print list of unique words");
        menu.add("2 - print sorted list of unique words");
        menu.add("3 - print number of words");
        menu.add("4 - print numbers of each symbol");
        menu.add("Q - close the app");
    }

    public void printMenu(){
        for (String element : menu)
            System.out.println(element);
    }

    public void printQuestion(){
        System.out.println("Enter command: ");
    }
}
