package arrays;

import java.util.ArrayList;

public class MyArrayList {
    ArrayList<Integer> list1 = new ArrayList<Integer>(){{
        add(1);
        add(3);
        add(2);
        add(4);
        add(2);
        add(4);
        add(2);
        add(4);
        add(5);
        add(5);
}};
    ArrayList<Integer> list2 = new ArrayList<Integer>(){{
        add(3);
        add(3);
        add(2);
        add(2);
        add(4);
        add(4);
        add(4);
        add(4);
        add(5);
        add(5);
}};

    public void createArrayByMatches(){
        ArrayList<Integer> arrayByMatches = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i).equals(list2.get(i))){
                arrayByMatches.add(list1.get(i));
            }
        }
        System.out.println("Лист співпадаючих цілих чисел: ");
        for (Integer match : arrayByMatches){
            System.out.print(match + " ");
        }
        System.out.println(" ");
    }

    public void createArrayUnMatches(){
        ArrayList<Integer> arrayUnMatches = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++){
            if (!list1.get(i).equals(list2.get(i))){
                arrayUnMatches.add(list2.get(i));
            }
        }
        System.out.println("Лист неспівпадаючих цілих чисел: ");
        for (Integer match : arrayUnMatches){
            System.out.print(match + " ");
        }
        System.out.println(" ");
    }

    public void deleteDuplicates(){
        ArrayList<Integer> unique = new ArrayList<Integer>();
        for (Integer integer : list1){
            if (!list2.contains(integer)){
                unique.add(integer);
            }
        }
        System.out.println("Лист унікальних чисел: ");
        for (Integer integer : unique){
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
