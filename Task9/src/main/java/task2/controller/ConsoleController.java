package task2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task2.model.Model;
import task2.model.ModelLogic;
import task2.util.FileUtils;
import task2.view.ConsoleView;
import task2.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleController implements Controller{

    private static final Logger logger = LogManager.getLogger(ConsoleController.class);
    String command;
    Scanner scanner = new Scanner(System.in);
    View view = new ConsoleView();
    Model model = new ModelLogic();

    @Override
    public void execute(){
        do {
            view.printMenu();
            ((ConsoleView)view).printQuestion();
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
            case "7":
                pressButton7();
                break;
            case "8":
                pressButton8();
                break;
            case "9":
                pressButton9();
                break;
            case "10":
                pressButton10();
                break;
            case "11":
                pressButton11();
                break;
            case "12":
                pressButton12();
                break;
            case "13":
                pressButton13();
                break;
            case "14":
                pressButton14();
                break;
            case "Q":
                System.out.println("Close the app");
                break;
            default:
                System.out.println("Incorrect command");
                break;
        }
    }

    private void pressButton1() {
        logger.info("Method 'word count' started");
        System.out.println("Map with unique words and how often it occur in text: ");
        System.out.println(model.wordCount());
        logger.info("Method 'word count' finished");
    }

    private void pressButton2(){
        logger.info("Method 'sort sentence increasing' started");
        System.out.println("Sorting sentences by increasing: ");
        model.sortSentenceIncreasing().stream().forEach(s -> System.out.println(s));
        logger.info("Method 'sort sentence increasing' finished");
    }

    private void pressButton3(){
        logger.info("Method 'find unique word' started");
        System.out.println(model.findUniqueWord());
        logger.info("Method 'find unique word' finished");
    }

    private void pressButton4(){
        logger.info("Method 'find words from question sentence' started");
        System.out.println("What word length do you want to get?");
        int wordLength = Integer.parseInt(scanner.nextLine());
        System.out.println("You want to get words which created from " + wordLength + " letters...");
        List<String> uniqueQuestionWords = model.findWordsFromQuestionSentence(wordLength);
        if(uniqueQuestionWords.isEmpty()) {
            System.out.println("There is no such long word");
        }
        else {
            System.out.println(uniqueQuestionWords);
        }
        logger.info("Method 'find words from question sentence' finished");
    }

    private void pressButton5(){
        logger.info("Method 'change first word with longest' started");
        System.out.println("Changing the first word of each sentence with the longest word for whole text: ");
        model.changeFirstWordWithLongest().stream().forEach(s -> System.out.println(s));
        logger.info("Method 'change first word with longest' finished");
    }

    private void pressButton6(){
        logger.info("Method 'sort words alphabetical' started ");
        System.out.println("Sorting unique words in alphabetical order: ");
        model.sortWordsAlphabetical().stream().forEach(s -> System.out.println(s));
        logger.info("Method 'sort words alphabetical' finished ");
    }

    private void pressButton7(){
        logger.info("Method 'sort words by percentage of vowels' started");
        System.out.println("List of sorted words by percentage of vowels: ");
        model.sortWordsByPercentageOfVowels().stream().forEach(s -> System.out.println(s));
        logger.info("Method 'sort words by percentage of vowels' finished");
    }

    private void pressButton8(){
        logger.info("Method 'sort words that start with vowel' started");
        System.out.println("Sorting words that start with vowel in alphabetical order: ");
        model.sortWordsThatStartWithVowel().stream().forEach(s -> System.out.println(s));
        logger.info("Method 'sort words that start with vowel' finished");
    }

    private void pressButton9(){
        logger.info("Method'sort all words by numbers of giving letter' started");
        System.out.println("Which letter you want to use for sorting? Please, enter it: ");
        String enterLetter = scanner.nextLine().toLowerCase();
        System.out.println("You want to use '" + enterLetter + "'");
        List<String> sortedByNumberLetter = model.sortAllWordsByNumbersOfGivingLetter(enterLetter);
        sortedByNumberLetter.stream().forEach(s -> System.out.println(s));
        logger.info("Method'sort all words by numbers of giving letter' finished");
    }

    private void pressButton10(){
        logger.info(" Method 'find number of occurs for all given words' started");
        List<String> listOfEnterWords = new ArrayList<>();
        String enterWord;
      do{
          System.out.println("Please, enter some words: ");
          System.out.println("If you want to get result of occurs for all given words");
          enterWord = scanner.nextLine();
          if (!enterWord.isEmpty()){
              listOfEnterWords.add(enterWord);
          }
      }
      while (!enterWord.equals(""));
        System.out.println("List of words which you entered: ");
        System.out.println(listOfEnterWords);
        System.out.println(model.findNumberOfOccursForAllGivenWords(listOfEnterWords));
        logger.info(" Method 'find number of occurs for all given words' finished");
    }

    private void pressButton11(){
        logger.info("Method 'delete substring with max length' started");
        List<String> enteredWordsBound = new ArrayList<>();
        String inputWord;
        do {
            System.out.println("Please, enter two words: ");
            inputWord = scanner.nextLine();
            if (!inputWord.isEmpty()){
                enteredWordsBound.add(inputWord);
            }
        }
        while (enteredWordsBound.size() < 2);
        System.out.println("List of words which you input: ");
        System.out.println(enteredWordsBound);
        System.out.println("Text after deleting the longest substring: ");
        model.deleteSubstringWithMaxLength(enteredWordsBound).stream().forEach(s -> System.out.println(s));
        logger.info("Method 'delete substring with max length' finished");
    }

    private void pressButton12(){
        logger.info("Method 'delete words of given length with consostant letter' started");
        System.out.println("Enter some word length: ");
        int wordLength = Integer.parseInt(scanner.nextLine());
        System.out.println("You input length " + wordLength);
       model.deletewordsOfGivenLengthWithConsostantLetter(wordLength).stream().forEach(s -> System.out.println(s));
        logger.info("Method 'delete words of given length with consostant letter' finished");
    }

    private void pressButton13(){
        logger.info("Method 'find the longest word which is palindrome' started");
        System.out.println("The longest palinrome in text: ");
        System.out.println(model.findTheLongestWordWhichIsPalindrome());
        logger.info("Method 'find the longest word which is palindrome' finished");
    }

    private void pressButton14(){
        logger.info("Method 'change words of length by substring' started");
        System.out.println("Enter some word length: ");
        int wordLength = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter substring with which you want to replace words: ");
        String substring = scanner.nextLine();
        System.out.println("You input length: '" + wordLength + "', substring: '" + substring + "'");
        System.out.println("Replace all words with given length by given substring: ");
        model.changeWordsOfLengthBySubstring(wordLength, substring).stream().forEach(s -> System.out.println(s));
        logger.info("Method 'change words of length by substring' finished");
    }
}
