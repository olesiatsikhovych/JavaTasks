package task1;

        import task1.controller.ConsoleController;
        import task1.controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller controller = new ConsoleController();
        controller.execute();
    }
}
