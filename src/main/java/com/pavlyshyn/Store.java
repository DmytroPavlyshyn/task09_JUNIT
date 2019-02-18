package com.pavlyshyn;


import java.util.HashMap;
import java.util.Map;

public class Store {
    private String name;
    private final Integer id;
    private Map<String, Integer> productPrice;
    private Calculator calculator;

    public Store(String name, Integer id, Map<String, Integer> productPrice,Calculator calculator) {
        this.name = name;
        this.id = id;
        this.productPrice = productPrice;
        this.calculator = calculator;
    }

    public Store(String name, Integer id, Map<String, Integer> productPrice) {
        this.name = name;
        this.id = id;
        this.productPrice = productPrice;
    }

    public Store(String name, Integer id) {
        this(name,id,new HashMap<>());
    }
    public String getName() {
        return name;
    }


    public Integer getId() {
        return id;
    }

    public Map<String, Integer> getProductPrice() {
        return productPrice;
    }
    public void put(String name, int price){
        if(name.equals(this.name)){
            throw new RuntimeException("Can't store be product");
        }
        productPrice.put(name,price);
    }
    public void remove(String name){
        productPrice.remove(name);
    }
    public void removeAll(){
        productPrice.clear();
    }
    public Integer findProductPrice(String productName){
        return productPrice.get(productName);
    }
    public int getNumberOfProducts(){
        return productPrice.size();
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int calculatePrice(String name, int count){
        return calculator.calculatePrice(count,productPrice.get(name));
    }
}
