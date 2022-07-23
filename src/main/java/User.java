import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private double amountOfMoney;
    private final List<Product> userProducts = new ArrayList<>();

    public User(@NotNull String firstName, @NotNull String lastName, double amountOfMoney) {
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("First and last name cannot be empty");
        }
        if (amountOfMoney < 0) {
            throw new IllegalArgumentException("Amount of money cannot be less 0.");
        }
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

    public String getLastName() {
        return lastName;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        if (amountOfMoney >= 0) {
            this.amountOfMoney = amountOfMoney;
        } else {
            throw new IllegalArgumentException("Amount of money сan not be less than zero.");
        }
    }

    public void addProductForUser(Product product) {
        userProducts.add(product);
    }

    public void removeProduct(Product product) {
        userProducts.remove(product);
    }
}
