package task4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModelLogic implements Model {

    Scanner scanner = new Scanner(System.in);
    String inputWord;
    private List<String> enteredWordsList = new ArrayList<>();

    @Override
    public List<String> enterWords() {
        do {
            System.out.println("Enter some word: ");
            System.out.println("If you want to go to menu - press ENTER");
            inputWord = scanner.nextLine();
            if (!inputWord.isEmpty()) {
                enteredWordsList.add(inputWord);
            }
        }
            while (!inputWord.equals(""));
            return enteredWordsList;
    }

    @Override
    public List<String> uniqueWords() {
        return enteredWordsList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> sortedListUniqueWords() {
        return enteredWordsList.stream().distinct().sorted().collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> numberWords() {
        return enteredWordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public Map<String, Long> numberCharacter() {
        return enteredWordsList.stream().flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
    }

    @Override
    public List<String> getEnteredWordsList() {
        return enteredWordsList;
    }
}
