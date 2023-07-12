package arrays;

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
        comparableString.fillArrayList(comparableString.arrayList);
        System.out.println();
        Collections.sort(comparableString.arrayList);
        System.out.println("Відсортований ArrayList: " + comparableString.arrayList);
        System.out.println("Шукане число: 5");
        System.out.println("Індекс шуканого числа:");
        System.out.println(comparableString.binarySearch(comparableString.arrayList,"5"));
    }
}
