import controller.ConsoleController;
import controller.Controller;
import view.ConsoleView;
import view.View;

public class App {
    public static void main(String[] args) {
        Controller controller = new ConsoleController();
        controller.execute();
    }
}
