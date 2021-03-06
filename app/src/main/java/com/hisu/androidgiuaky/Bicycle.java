package com.hisu.androidgiuaky;

import java.io.Serializable;

public class Bicycle implements Serializable {
    private int imageUrl;
    private String name;
    private String desc;
    private double price;
    private double discount;
    private double discountPercentage;

    /*
        0: Trending
        1: popular
        2: recommend
     */
    private int type;

    public Bicycle(int imageUrl, String name, String desc, double price, double discount, double discountPercentage, int type) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.discount = discount;
        this.discountPercentage = discountPercentage;
        this.type = type;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
