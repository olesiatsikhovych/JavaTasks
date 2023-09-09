package task4;

import task4.controller.ConsoleController;
import task4.controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller controller = new ConsoleController();
        controller.execute();
    }
}
