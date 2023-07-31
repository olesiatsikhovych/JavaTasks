package arrays;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListAndArray {
    private String[] array = new String[10];
    private ArrayList<String> list = new ArrayList<String>();
    long timeArrayAdd100k;
    long timeListAdd100k;

    public void add100kStringsToArray(){
        Date startArrayTime = new Date();
        for (int i = 0; i < 100000; i++){
            String newString = "String " + i;
            addStrings(newString, i);
        }
        Date endArrayTime = new Date();
        long arrayTime = endArrayTime.getTime() - startArrayTime.getTime();
        timeArrayAdd100k = arrayTime;
        System.out.println("Час затрачений на add100kStringsToArray: ");
        System.out.println(arrayTime + " мс");
    }

    public void add100kStringsToList(){
        Date startListTime = new Date();
        for (int i = 0; i < 100000; i++){
            String newString = "String " + i;
            list.add(newString);
        }
        Date endListTime = new Date();
        long listTime = endListTime.getTime() - startListTime.getTime();
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

    private void addStrings(String newString, int index){
        if (index < array.length){
            array[index] = newString;
        }
        else {
            array = copyArray(array);
            array[index] = newString;
        }
    }

    private String[] copyArray(String[] src) {
        String[] result = new String[src.length * 2];
        for (int i = 0; i < src.length; i++){
            result[i] = src[i];
        }
        return result;
    }
}

