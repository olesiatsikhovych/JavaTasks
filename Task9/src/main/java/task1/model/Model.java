package task1.model;

import java.util.List;

public interface Model {
    List<String> getAggregatedList();
    boolean checkEnteredWord();
    List<String> splitEnteredSentence();
    String replaceAllVowelWords();
}
