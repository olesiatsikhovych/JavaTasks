package task2.model;

import task2.comparator.VowelPercentageComparator;
import task2.util.FileUtils;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ModelLogic implements Model{

    FileUtils fileUtils = new FileUtils();
    private String filePath = "C:\\Users\\Olesia\\JavaTasks\\JavaTaskRepo\\Task9\\src\\main\\resources\\text1.txt";
    List<String> sentences = fileUtils.readFromFile(filePath);

    @Override
    public Map<String, Long> wordCount() {
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.matches("-?\\d+(\\.\\d+)?"))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public List<String> sortSentenceIncreasing() {
        Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
        return sentences.stream()
                .filter(s -> !s.isEmpty())
                .sorted(compByLength)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findUniqueWord() {
        String firstSentenceInText = sentences.stream().findFirst().orElse("");
        List<String> wordsInFirstSentence = Arrays.asList(firstSentenceInText.split(" "));
        System.out.println("First sentence in text: ");
        System.out.println(firstSentenceInText);

        List<String> firstSentenceWithoutPunctuation = wordsInFirstSentence.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

       List<String> allWordsInOtherSentences = sentences.stream()
               .skip(1)
               .flatMap(s -> Arrays.stream(s.split(" ")))
               .map(w -> w.replaceAll("[,.?!()]", "").toLowerCase())
               .filter(w -> !w.isEmpty())
               .filter(w -> !w.matches("-?\\d+(\\.\\d+)?"))
               .collect(Collectors.toList());

       List<String> uniqueWords = firstSentenceWithoutPunctuation.stream()
               .filter(word -> allWordsInOtherSentences.stream().noneMatch(word::equals))
               .collect(Collectors.toList());

       return uniqueWords;
    }


    @Override
    public List<String> findWordsFromQuestionSentence(int wordLength) {
        Pattern questionPattern = Pattern.compile(".*\\?$");
        return sentences.stream()
                .filter(s -> questionPattern.matcher(s).matches())
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .map(word -> word.replaceAll("[?]", ""))
                .map(s -> s.toLowerCase())
                .distinct()
                .filter(word -> word.length() == wordLength)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> changeFirstWordWithLongest() {
        Comparator<String> compWordsByLength = (aName, bName) -> bName.length() - aName.length();
       String longestWord = sentences.stream()
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .sorted(compWordsByLength).findFirst().get();
        System.out.println("The longest word in this text - '" + longestWord + "'");
        return sentences.stream()
                .map(s -> s.replaceFirst("\\b[A-Za-z]+\\b", longestWord))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> sortWordsAlphabetical() {
        Comparator<String> compWordsByAlphabet = (s1, s2) -> s1.compareTo(s2);
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .map(s -> s.toLowerCase())
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.matches("-?\\d+(\\.\\d+)?"))
                .filter(s -> !s.matches("\\b\\d+(st|nd|rd|th)\\b"))
                .distinct()
                .sorted(compWordsByAlphabet)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> sortWordsByPercentageOfVowels() {
        VowelPercentageComparator vowelPercentageComparator = new VowelPercentageComparator();
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .map(s -> s.toLowerCase())
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.matches("-?\\d+(\\.\\d+)?"))
                .filter(s -> !s.matches("\\b\\d+(st|nd|rd|th)\\b"))
                .distinct()
                .sorted(vowelPercentageComparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> sortWordsThatStartWithVowel() {
        Comparator<String> compWordsByAlphabet = (s1, s2) -> s1.compareTo(s2);
        Pattern pattern = Pattern.compile("^[AEIOUYaeiouy]");
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .filter(s -> pattern.matcher(s).find())
                .map(s -> s.toLowerCase())
                .distinct()
                .sorted(compWordsByAlphabet)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> sortAllWordsByNumbersOfGivingLetter(String enterLetter) {
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .map(s -> s.toLowerCase())
                .filter(s -> !s.matches("\\b\\d+(st|nd|rd|th)\\b"))
                .distinct()
                .filter(s -> s.contains(enterLetter))
                .sorted((word1, word2) -> {
                    long count1 = word1.chars().filter(ch -> ch == enterLetter.charAt(0)).count();
                    long count2 = word2.chars().filter(ch -> ch == enterLetter.charAt(0)).count();
                    return (int)(count2 - count1);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Map <String, Long> findNumberOfOccursForAllGivenWords(List<String> listOfEnterWords) {
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .map(s -> s.toLowerCase())
                .filter(s -> !s.isEmpty())
                .filter(word -> listOfEnterWords.contains(word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public List<String> deleteSubstringWithMaxLength(List<String> enteredWordsBound) {
        String firstBound = enteredWordsBound.get(0);
        String secondBound = enteredWordsBound.get(1);

        Comparator<String> compByLength = (a, b) -> b.length() - a.length();

       List<String> substrings = sentences.stream()
               .filter(s -> {
                   int firstIndex = s.indexOf(firstBound);
                   int secondIndex = s.indexOf(secondBound);
                   return !(firstIndex == -1 || secondIndex == -1);
               })
                       .map(s -> s.substring(s.indexOf(firstBound), s.indexOf(secondBound) + secondBound.length()))
                       .sorted(compByLength)
               .collect(Collectors.toList());
       
        return sentences.stream()
                .map(s -> {
                    if (s.contains(substrings.get(0)))
                       return s.replace(substrings.get(0), "");
                    else
                        return s;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<String> deletewordsOfGivenLengthWithConsostantLetter(int wordLength) {
        Pattern pattern = Pattern.compile("^[BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz]");
        return sentences.stream()
                .map(sentence -> Arrays.stream(sentence.split(" "))
                        .filter(word -> !pattern.matcher(word).find() || word.length() != wordLength)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.toList());
    }

    @Override
    public String findTheLongestWordWhichIsPalindrome() {
      return sentences.stream()
              .map(s -> s.replaceAll("[,.?!()]", ""))
              .flatMap(Pattern.compile(" ")::splitAsStream)
              .map(s -> s.toLowerCase())
              .filter(s -> !s.matches("\\b\\d+(st|nd|rd|th)\\b"))
                .filter(s -> isPalindrome(s))
                .max(Comparator.comparing(String::length))
              .orElse("No palindrome found");
    }

    @Override
    public List<String> changeWordsOfLengthBySubstring(int wordLength, String substring) {
        return sentences.stream()
                .map(s -> s.replaceAll("[,.?!()]", ""))
                .map(sentence -> Arrays.stream(sentence.split(" "))
                .map(s -> s.toLowerCase())
                .filter(s -> !s.matches("\\b\\d+(st|nd|rd|th)\\b"))
                .map(s -> s.length() == wordLength ? substring : s)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.toList());
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
