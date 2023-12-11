package task1.view;

import java.util.*;

public class ConsoleView implements View {

    private Locale locale = new Locale("uk");
    private ResourceBundle bundle = ResourceBundle.getBundle("MyMenu", locale);
    private List<String> menu;

    public ConsoleView() {
        createMenu();
    }

    public void printMenu() {
        for (String element : menu)
            System.out.println(element);
    }

    public void printQuestion() {
        System.out.println("Enter command: ");
    }

    public void englishMenu() {
        locale = new Locale("en");
        bundle = ResourceBundle.getBundle("MyMenu", locale);
        createMenu();
    }

    public void ukraineMenu() {
        locale = new Locale("uk");
        bundle = ResourceBundle.getBundle("MyMenu", locale);
        createMenu();
    }

    private List<String> createMenu() {
        menu = new ArrayList<String>();
        menu.add(bundle.getString("1"));
        menu.add(bundle.getString("2"));
        menu.add(bundle.getString("3"));
        menu.add(bundle.getString("4"));
        menu.add(bundle.getString("5"));
        menu.add(bundle.getString("6"));
        menu.add(bundle.getString("Q"));
        return menu;
    }
}

