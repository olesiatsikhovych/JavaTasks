package model;

import model.comparator.AmountComparator;
import model.comparator.PriceComparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ProductLogic implements Model {

  LinkedList<Product> productList = new LinkedList<>();

    @Override
    public void addNewProduct(String name, int price, int amount, int id) {
    productList.add(new Product(name, price, amount, id));
    }

    @Override
    public LinkedList<Product> getProductList() {
        return productList;
    }

    @Override
    public LinkedList<Product> sortProductListByPrice() {
        LinkedList<Product> sortedProducts;
       sortedProducts = productList;
       PriceComparator priceComparator = new PriceComparator();
       sortedProducts.sort(priceComparator);
        return sortedProducts;
    }

    @Override
    public LinkedList<Product> sortProductListByAmount() {
        LinkedList<Product> sortedProducts;
        sortedProducts = productList;
        AmountComparator amountComparator = new AmountComparator();
        sortedProducts.sort(amountComparator);
        return sortedProducts;
    }

    @Override
    public void createProductFile() {
        File file = new File("listOfProducts.txt");
        try {
            PrintWriter printWriter = new PrintWriter(file);
           for (Product product : productList)
           printWriter.println(product);
           printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception");
            System.out.println(e);
        }
    }

//    @Override
//    public void createProductFile() {
//        File file = new File("listOfProducts.txt");
//        try(PrintWriter printWriter = new PrintWriter(file)) {
//            for (Product product : productList)
//                printWriter.println(product);
//        } catch (FileNotFoundException e) {
//           System.out.println(e);
//        }
//    }
}
