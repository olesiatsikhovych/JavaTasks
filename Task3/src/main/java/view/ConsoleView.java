package view;

import java.util.*;

public class ConsoleView implements View{

    private List<String> menu;

    public ConsoleView() {
      menu = new LinkedList<String>();
      menu.add("1 - print house list");
      menu.add("2 - sort house list by price");
      menu.add("3 - sort house list by distance to kindergarten");
      menu.add("4 - sort house list by distance to school");
      menu.add("5 - sort house list by distance to playground");
      menu.add("Q - exit");
    }
    public void printMenu() {
        for(String element : menu)
        System.out.println(element);
    }

    public void printQuestion(){
        System.out.println("Enter command:");
    }


}
