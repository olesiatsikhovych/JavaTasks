package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOfInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> streamOfInteger = listOfInteger.stream();
        Stream<Integer> streamOfInteger2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> streamOfInteger3 = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Stream<Integer> streamOfInteger4 = Stream.iterate(1, n -> n + 1).limit(10);
        Stream<Integer> streamOfInteger5 = Stream.generate(new Random():: nextInt);

        StreamUtility streamUtility = new StreamUtility(listOfInteger);
        streamUtility.printCountStats();
        streamUtility.printSumBiggerThenAverange();

    }
}
