package task3;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamUtility {
    private Supplier<Stream<Integer>> supplier;

    public StreamUtility(List<Integer> integers){
        this.supplier = () -> integers.stream();
    }

   public void printCountStats(){
        Integer max = supplier.get().max(Integer::compare).get();
        Integer min = supplier.get().min(Integer::compare).get();
        Double avarage = supplier.get().mapToInt(integerList -> integerList).average().orElse(0.0);
        Integer sumByReduce = supplier.get().reduce(0, Integer::sum);
        Integer sumByMethod = supplier.get().mapToInt(Integer::intValue).sum();

       System.out.println("Max value - " + max);
       System.out.println("Min value - " + min);
       System.out.println("Average - " + avarage);
       System.out.println("Sum by reduce - " + sumByReduce);
       System.out.println("Sum by method - " + sumByMethod);
    }

    public void printSumBiggerThenAverange(){
        Double average = supplier.get().mapToInt(integerList -> integerList).average().orElse(0.0);
        Integer sum = supplier.get().filter(i -> i > average).mapToInt(i -> i).sum();

        System.out.println("Sum bigger than average - " + sum);

    }
}

