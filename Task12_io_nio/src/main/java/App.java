import serde.controller.ConsoleController;
import serde.controller.Controller;
import serde.model.ConsoleModel;
import serde.model.Model;

public class App {
    public static void main(String[] args) {
        Model model = new ConsoleModel();
        Controller controller = new ConsoleController(model);
        controller.executeMainMenu();
    }
}
