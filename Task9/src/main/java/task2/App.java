package task2;

import task2.controller.ConsoleController;
import task2.controller.Controller;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Controller controller = new ConsoleController();
        controller.execute();
    }
}
