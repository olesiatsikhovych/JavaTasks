package task2.model;

import java.util.List;
import java.util.Map;

public interface Model {
    Map<String, Long> wordCount();                                  //1
    List<String> sortSentenceIncreasing();                          //2
    List<String> findUniqueWord();                                  //3
    List<String> findWordsFromQuestionSentence(int wordLength);     //4
    List<String> changeFirstWordWithLongest();                      //5
    List<String> sortWordsAlphabetical();                           //6
    List<String> sortWordsByPercentageOfVowels();                   //7
    List<String> sortWordsThatStartWithVowel();                     //8
    List<String> sortAllWordsByNumbersOfGivingLetter(String enterLetter);  //9
    Map<String, Long> findNumberOfOccursForAllGivenWords(List<String> listOfEnterWords);    //10
    List<String> deleteSubstringWithMaxLength(List<String> enteredWordsBound);                    //11
    List<String> deletewordsOfGivenLengthWithConsostantLetter(int wordLength);      //12
    String findTheLongestWordWhichIsPalindrome();                    //13
    List<String> changeWordsOfLengthBySubstring(int wordLength, String substring); //14
}
