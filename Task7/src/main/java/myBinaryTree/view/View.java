package myBinaryTree.view;

import java.util.LinkedList;
import java.util.List;

public class View {
  private List<String> menu;

    public View() {
        menu = new LinkedList<String>();
        menu.add("1 - Add cat");
        menu.add("2 - Get cat");
        menu.add("3 - Remote cat");
        menu.add("Q - exit");
    }

    public void printMenu(){
        for (String element : menu)
            System.out.println(element);
    }

    public void printQuestion(){
        System.out.println("Enter command");
    }
}
