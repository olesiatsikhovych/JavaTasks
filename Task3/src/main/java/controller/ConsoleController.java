package controller;

import model.House;
import model.HouseManager;
import view.ConsoleView;
import view.View;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleController implements Controller {
    String command;
    Scanner scanner = new Scanner(System.in);
    View view = new ConsoleView();
    HouseManager houseManager = new HouseManager();

    public void execute() {
        do {
            view.printMenu();
            ((ConsoleView) view).printQuestion();
            command = scanner.nextLine();
            chooseCommand(command);
        }
        while (!command.equals("Q"));
    }

    private void chooseCommand(String command) {

        switch (command) {
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
            case "Q":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Incorrect command");
                break;
        }
    }

    private void pressButton1() {
       printCollection(houseManager.getHouseList());
    }

    private void pressButton2() {
        System.out.println("Input maximum price:");
        int maximumPrice = Integer.parseInt(scanner.nextLine());
        printCollection(houseManager.sortHousesByPrice(maximumPrice));
    }

    private void pressButton3() {
        System.out.println("Input maximum distance to kindergarten:");
        int maximumDisToKindergarten = Integer.parseInt(scanner.nextLine());
        printCollection(houseManager.sortHousesByDistanceToKindergarten(maximumDisToKindergarten));
    }

    private void pressButton4() {
        System.out.println("Input maximum distance to school:");
        int maximumDisToSchool = Integer.parseInt(scanner.nextLine());
        printCollection(houseManager.sortHousesByDistanceToSchool(maximumDisToSchool));
    }

    private void pressButton5() {
        System.out.println("Input maximum distance to playground:");
        int maximumDisToPlayground = Integer.parseInt(scanner.nextLine());
        printCollection(houseManager.sortHousesByDistanceToPlayground(maximumDisToPlayground));
    }

    private void printCollection(LinkedList<House> houses){
        for (House house : houses){
            System.out.println(house);
        }
    }
}
