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
    public void setProductID(int id){
        this.id = id;
    }
    public int getProductID(){
        return id;
    }

    public void setProductName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setProductPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }

    public void setProductStock(int stock){
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }

    public void addProduct(Product product){}

    public abstract void addProduct(ProductManager product);

    public void updateProduct(Product product){}

    public String toString(){
        return String.format("Product ID: %d\nProduct name= %s\nPrice='%d'\nStock=%d\n]", id, name, price, stock);
    }

}
