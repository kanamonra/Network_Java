package Day25Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager extends Product {
    private List<Integer> productList;
    public ProductManager(){
        this.productList = new ArrayList<>();
    }

    @Override
    public void addProduct(ProductManager product){
        try{
            System.out.println("Please enter following data to add a new product");
            Scanner sc = new Scanner(System.in);
            System.out.println("Product number: ");
            this.productList.add(sc.nextInt());
            System.out.println("Product name: ");
            product.setProductName(sc.nextLine());
            System.out.println("Product price: ");
            product.setProductPrice(sc.nextInt());
            System.out.println("Product stock: ");
            product.setProductStock(sc.nextInt());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateProduct(Product product) {
        super.updateProduct(product);

    }
}
