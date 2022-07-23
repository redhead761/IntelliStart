import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Product {
    private final String id;
    private final String name;
    private final double price;

    public Product(@NotNull String name, double price) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot less 0");
        }
        this.name = name;
        this.price = price;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

