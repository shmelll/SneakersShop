package ru.javavision.Models;

public class Product {
    private String name;
    private Integer price;
    private String avaibleSizes;
    private Integer id;
    private static Integer sumPrice=0;

    public static void setSumPrice(Integer sumPrice) {
        Product.sumPrice+= sumPrice;
    }

    public Product(String name, Integer price, String avaibleSizes, Integer id) {

        this.name = name;
        this.price = price;
        this.avaibleSizes = avaibleSizes;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAvaibleSizes() {
        return avaibleSizes;
    }

    public void setAvaibleSizes(String avaibleSizes) {
        this.avaibleSizes = avaibleSizes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String CountPrice(){
        String str= Integer.toString(sumPrice);
        return str;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", avaibleSizes='" + avaibleSizes + '\'' +
                ", id=" + id +
                '}';
    }
}
