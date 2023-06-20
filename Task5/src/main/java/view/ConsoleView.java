package view;

import java.util.LinkedList;

public class ConsoleView implements View {

    private LinkedList<String> menu;

    public ConsoleView() {
        menu = new LinkedList<>();
        menu.add("1 - add new product to list");
        menu.add("2 - print product list");
        menu.add("3 - sort product list by price");
        menu.add("4 - sort product list by amount");
        menu.add("5 - create file with product list");
        menu.add("Q - quit");
    }

    public void printMenu(){
        for(String element : menu)
            System.out.println(element);
        }

        public void printQuestion(){
            System.out.println("Enter command: ");
        }
}