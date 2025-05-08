package ie.atu.week6;

import ie.atu.week6.productDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        productDAO productDAO = new productDAO();
        cartDAO cartDAO = new cartDAO();
        orders_detailsDAO orders_detailsDAO = new orders_detailsDAO();
        ordersDAO ordersDAO = new ordersDAO();
        loginDAO loginDAO = new loginDAO();

        while (true) {
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

            switch (choice) {
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
                case 2:
                    List<Product> products = productDAO.selectAllProducts();
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scan.nextInt();
                    scan.nextLine();
                    productDAO.deleteProduct(deleteId);
                    System.out.println("Product deleted.");
                    break;

                case 4:
                    System.out.print("Enter your user ID: ");
                    int userId = scan.nextInt();

                    System.out.print("Enter product ID to add to cart: ");
                    int productId = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scan.nextInt();
                    scan.nextLine();

                    cartDAO.addtoCart(userId, productId, quantity);
                    System.out.println("Product added to cart.");
                    break;

                case 5:
                    System.out.print("Enter user ID to view cart: ");
                    int viewUserId = scan.nextInt();
                    scan.nextLine();

                    List<CartItem> cartItems = cartDAO.getCartByUserId(viewUserId);
                    if (cartItems.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (CartItem item : cartItems) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}