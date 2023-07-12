package arrays;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListAndArray {
    private String[] array =new String[10];
    private ArrayList<String> list = new ArrayList<String>();
    long timeArrayAdd100k;
    long timeListAdd100k;

    public void addStrings(String[] array, String newString){
        int arrayLength = array.length;
        int newSize = arrayLength * 2;

        if (arrayLength == newSize){
            String[] newArray = new String[newSize];
            System.arraycopy(array, 0, newArray, 0, arrayLength);
            array[arrayLength] = newString;
}
    }

    public void add100kStringsToArray(){
        Date startArray = new Date();
        for (int i = 0; i < 100000; i++){
            String newString = "String " + i;
            addStrings(array, newString);
        }
        Date endArray = new Date();
        long arrayTime = endArray.getTime() - startArray.getTime();
        timeArrayAdd100k = arrayTime;
        System.out.println("Час затрачений на add100kStringsToArray: ");
        System.out.println(arrayTime + " мс");

    }

    public void add100kStringsToList(){
        Date startList = new Date();
        for (int i = 0; i < 100000; i++){
            String newString = "String " + i;
            list.add(newString);
        }
        Date endList = new Date();
        long listTime = endList.getTime() - startList.getTime();
        timeListAdd100k = listTime;
        System.out.println("Час затрачений на add100kStringsToList: ");
        System.out.println(listTime + " мс");
    }

    public void compareTime(){
        if(timeListAdd100k < timeArrayAdd100k){
            System.out.println("List заповнюється швидше на: ");
            System.out.println(timeArrayAdd100k - timeListAdd100k + " мс");
        }
        else{
            System.out.println("Array заповнюється швидше на: ");
            System.out.println(timeListAdd100k - timeArrayAdd100k + " мс");
        }
    }
}
