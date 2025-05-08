package ie.atu.week6;

public class CartItem {
    private int productId;
    private String productName;
    private String productDescription;
    private double price;
    private int quantity;
    private double totalPrice;

    public CartItem(int productId, String productName, String productDescription, double price, int quantity, double totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return String.format("Product {ID=%d, Name='%s', Description='%s', Price=€%.2f, Quantity=%d, Total=€%.2f}",
                productId, productName, productDescription, price, quantity, totalPrice);
    }
}
