package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ComparableString {

    public void fillArrayList(ArrayList<String> arrayList){
        Random random = new Random();
        System.out.println("Рандомно створений ArrayList: ");
        for (int i = 0; i < 10; i++){
            String randomString = Integer.toString(random.nextInt(11));
            arrayList.add(randomString);
            System.out.print(arrayList.get(i) + " ");
        }
    }

    public int binarySearch(ArrayList<String> arrayList, String key){

        int low = 0;
        int high = arrayList.size() -1;

        while (low <= high){
            int middle = low + (high - low) / 2;
            String middleElement = arrayList.get(middle);

            if (middleElement.equals(key)){
                return middle;
            }
            if (middleElement.compareTo(key) < 0){
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return -1;
   }

}
