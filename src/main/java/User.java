import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;
    private List<Product> userProducts = new ArrayList<>();

    public User(String firstName, String lastName, double amountOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public List<Product> getUserProducts() {
        return userProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        if (amountOfMoney > 0) {
            this.amountOfMoney = amountOfMoney;
        } else {
            System.out.println(("Amount of money сan not be less than zero."));
        }
    }

    public void addProductForUser(Product product) {
        userProducts.add(product);
    }
}
