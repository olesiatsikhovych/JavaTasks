package task2;

public class Main {
    public static void main(String[] args) {
        Command command = string -> System.out.println(string);
        command.execute("This is example of Lambda function");

        Main main = new Main();
        main.print(Anonymous :: print, "This is example of Method reference");

        Command command1 = new Command() {
            @Override
            public void execute(String string) {
                System.out.println("This is Anonymous class");
            }
        };
        command1.execute("String");

        CommandImpl commandImpl = new CommandImpl();
        commandImpl.execute("Regular class method execution");
    }
   public void print(Command c, String s){
        c.execute(s);
    }
}
