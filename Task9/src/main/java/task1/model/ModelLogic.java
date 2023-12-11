package task1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelLogic implements Model {

    Scanner scanner = new Scanner(System.in);
    List<String> aggregatedList = new ArrayList<>();

    @Override
    public List<String> getAggregatedList() {
        String inputWord;
        do {
            System.out.println("Enter some word: ");
            System.out.println("If you want to go to menu - press ENTER");
            inputWord = scanner.nextLine();
            if (!inputWord.isEmpty()){
                aggregatedList.add(inputWord);
            }
        }
        while (!inputWord.equals(""));
        return aggregatedList;
    }

    @Override
    public boolean checkEnteredWord() {
        System.out.println("Enter some sentence: ");
        String inputSentence = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[A-Z].*\\?$");
        Matcher matcher = pattern.matcher(inputSentence);
        return matcher.matches();
    }

    @Override
    public List<String> splitEnteredSentence() {
        System.out.println("Enter a sentence: ");
        String inputSentence = scanner.nextLine();
        String regex = "\\b(the|you)\\b";
        String[] fragments = inputSentence.split(regex);
        List<String> splitList = new ArrayList<>();
        for (String fragment : fragments){
            if(!fragment.isEmpty()){
                splitList.add(fragment.trim());
            }
        }
        return splitList;
    }

    @Override
    public String replaceAllVowelWords() {
        System.out.println("Enter a word: ");
        String inputWord = scanner.nextLine();
        String regex = "[aeiouAEIOU]";
        String replaceWord = inputWord.replaceAll(regex, "_");
        return replaceWord;
    }
}
