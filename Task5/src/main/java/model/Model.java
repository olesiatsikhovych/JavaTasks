package model;

import java.awt.*;
import java.util.LinkedList;

public interface Model {
void addNewProduct(String name, int id, int price, int amount);
LinkedList<Product> getProductList();
LinkedList<Product> sortProductListByPrice();
LinkedList<Product> sortProductListByAmount();
void createProductFile();

}
