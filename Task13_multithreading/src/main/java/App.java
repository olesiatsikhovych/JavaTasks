import controller.ConsoleController;
import controller.Controller;
import model.Model;
import model.ModelLogic;

public class App {
    public static void main(String[] args) {

        Model model = new ModelLogic();
        Controller controller = new ConsoleController(model);
        controller.execute();
    }
}
