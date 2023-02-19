package Day25Assignment;

public abstract class Product {
    private int id;
    private String name;
    private int stock;
    private int price;


    public Product(){}

    public void Product(int id, String name, int price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

}
