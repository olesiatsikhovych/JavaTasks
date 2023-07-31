package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        ArrayListAndArray arrayListAndArray = new ArrayListAndArray();
        arrayListAndArray.add100kStringsToArray();
        arrayListAndArray.add100kStringsToList();
        arrayListAndArray.compareTime();

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.createArrayByMatches();
        myArrayList.createArrayUnMatches();
        myArrayList.deleteDuplicates();

        ComparableString comparableString = new ComparableString();
        ArrayList<String> arrayList = new ArrayList<String>();
        comparableString.fillArrayList(arrayList);
        System.out.println();
        Collections.sort(arrayList);
        System.out.println("Відсортований ArrayList: " + arrayList);
        System.out.println("Шукане число: 5");
        System.out.println("Індекс шуканого числа:");
        System.out.println(comparableString.binarySearch(arrayList,"5"));
    }
}
