import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {
    private final String id;
    private String name;
    private double price;
    private List<User> usersBoughtProduct = new ArrayList<>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public List<User> getUsersBoughtProduct() {
        return usersBoughtProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price сan not be less than zero.");
        }
    }

    public void addUserBoughtProduct(User user) {
        usersBoughtProduct.add(user);
    }
}

