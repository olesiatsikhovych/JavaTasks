package task2.comparator;

import java.util.Comparator;

public class VowelPercentageComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        double vowelPercentage1 = calculateVowelPercentage(o1);
        double vowelPercentage2 = calculateVowelPercentage(o2);
        return Double.compare(vowelPercentage1, vowelPercentage2);
    }

    private double calculateVowelPercentage(String s){
        int totalCharacters = s.length();
        System.out.printf("For word: %s total characters is: %s \n",s, totalCharacters);
//        int vowelCount = s.replaceAll("([^aeiouAEIOU0-9\\W]+)", "").length();
        int vowelCount = s.replaceAll("[^aeiouyAEIOUY]", "").length();
        System.out.printf("For word: %s vowel characters is: %s \n",s, vowelCount);
        double vowelPercentage = (double)vowelCount / totalCharacters;
        System.out.printf("For word: %s vowel percenage is: %s \n",s, vowelPercentage);
        return vowelPercentage;
    }
}
