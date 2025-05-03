package ie.atu.week6;
import ie.atu.week6.productDAO;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        productDAO productDAO = new productDAO();
        cartDAO cartDAO = new cartDAO();

        while(true){
            System.out.println("---E-commerce Platform---");
            System.out.println("1. Add a product");
            System.out.println("2. View all products");
            System.out.println("3. Delete a product");
            System.out.println("4. Add to cart");
            System.out.println("5. View a cart by user's id");
            System.out.println("0. Exit interface");
            System.out.println("Choose an option");

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Product Name: ");
                    String name = scan.nextLine();
                    System.out.println("Product Description: ");
                    String description = scan.nextLine();
                    System.out.println("Product Price: ");
                    double price = scan.nextDouble();
                    System.out.println("Category ID: ");
                    int catID = scan.nextInt();

                    Product product = new Product(name, description, price, catID);
                    productDAO.insertProducts(product);
                    break;
            }
        }
    }
}