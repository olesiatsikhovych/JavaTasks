import controller.ConsoleController;
import controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller controller = new ConsoleController();
        controller.execute();
    }
}
