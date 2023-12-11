package task4.model;

import java.util.List;
import java.util.Map;

public interface Model {
    List<String> enterWords();
    List<String> uniqueWords();
    List<String> sortedListUniqueWords();
    Map<String, Long> numberWords();
    Map<String, Long> numberCharacter();
    List<String> getEnteredWordsList();
}
