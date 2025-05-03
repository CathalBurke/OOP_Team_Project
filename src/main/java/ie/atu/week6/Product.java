package ie.atu.week6;

public class Product {
    private int productID;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int categoryID;

    public Product(int productID, String productName, String productDescription, double productPrice, int categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.categoryID = categoryID;
    }

    public Product(String productName, String productDescription, double productPrice, int categoryID) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Product {" +
                "ID=" + productID +
                ", Name='" + productName + "'" +
                ", Description='" + productDescription + "'" +
                ", Price=€" + productPrice +
                ", CategoryID=" + categoryID +
                '}';
    }
}
