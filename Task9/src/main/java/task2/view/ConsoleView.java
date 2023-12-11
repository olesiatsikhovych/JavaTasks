package task2.view;

import java.util.ArrayList;
import java.util.List;

public class ConsoleView implements View {
    private List<String> menu;

    public ConsoleView() {
        menu = new ArrayList<>();
        menu.add("1 - how much each words occur in text in descending order");
        menu.add("2 - sort all sentence in increasing order by numbers of words");
        menu.add("3 - find word in first sentence that unique for all text");
        menu.add("4 - find and print in all question sentence word given length");
        menu.add("5 - in every sentence change first word with the longest");
        menu.add("6 - sort words in alphabetical order");
        menu.add("7 - sort words by percentage of vowels");
        menu.add("8 - words starts with vowels sort in alphabetical order");
        menu.add("9 - sort all words by numbers of giving letter");
        menu.add("10 - find number of occurs for all given words");
        menu.add("11 - delete substring with maximum length of bounded by given words");
        menu.add("12 - delete all words of given length that start with consonant letter");
        menu.add("13 - find the longest word which is palindrome");
        menu.add("14 - change words of given length by given substring");
        menu.add("Q - Quit");
    }

    @Override
    public void printMenu() {
        for (String element : menu)
            System.out.println(element);
    }

    public void printQuestion(){
        System.out.println("Enter command: ");
    }
}
