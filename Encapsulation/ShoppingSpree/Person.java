package Encapsulatio_Ex.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.setProducts(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(!name.trim().isEmpty()) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if(money >= 0) {
            this.money = money;
        }else {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }
    public double getMoney() {
        return money;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void buyProduct (Product product){
        //1. Ako ima dostatachno pari za da kupi producta:
        if(getMoney() >= product.getCost()){
            getProducts().add(product);
            this.money = getMoney() - product.getCost();
        }else {
            throw new IllegalArgumentException(String.format("%s can't afford %s",getName(),product.getName()));
        }
    }
}
