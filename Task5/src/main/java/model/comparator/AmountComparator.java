package model.comparator;

import model.Product;

import java.util.Comparator;

public class AmountComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getAmount(), o2.getAmount());
    }
}
