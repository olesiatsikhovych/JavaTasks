import controller.ConsoleController;
import controller.Controller;
import model.HouseManager;

public class App {
    public static void main(String[] args) {
        Controller controller = new ConsoleController();
        controller.execute();
    }
}
