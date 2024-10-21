package controller;

import model.Model;
import view.ConsoleView;
import view.View;

import java.util.Scanner;


public class ConsoleController implements Controller{

    String command;
    Scanner scanner = new Scanner(System.in);
    View view =  new ConsoleView();
    Model model;

    public ConsoleController(Model model){
        this.model = model;
    }

    public void execute(){
        do {
            view.printMainMenu();
            ((ConsoleView) view).printQuestionMainMenu();
            command = scanner.nextLine();
            chooseCommand(command);
        }
        while (!command.equals("Q"));
    }

    private void chooseCommand(String command){
        switch (command){
            case "1":
                pressButton1();
                break;
            case "2":
                pressButton2();
                break;
            case "3":
                pressButton3();
                break;
            case "4":
                pressButton4();
                break;
            case "5":
                pressButton5();
                break;
            case "6":
                pressButton6();
                break;
            case "Q":
                System.out.println("Exit app");
                break;
            default:
                System.out.println("Incorrect command");
                break;
        }
    }

    private void pressButton1(){
        model.startPingPong();
    }

    private void pressButton2(){
        model.produceFibonacciSequence();
    }

    private void pressButton3(){
        model.produceFibonacciSequenceWithExecutors();
    }

    private void pressButton4(){
        model.produceFibonacciSequenceWithCallable();
    }

    private void pressButton5(){
        System.out.println("Press numbers of Thread to sleep: ");
        Scanner scanner = new Scanner(System.in);
        model.createSleeper( scanner.nextInt());
    }

    private void pressButton6(){
        model.createCommunicatedPipes();
    }
}
