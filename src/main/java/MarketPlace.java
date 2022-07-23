import java.util.ArrayList;
import java.util.List;

public class MarketPlace {
    private final List<Product> products = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
    }

    public void addUser(String firstName, String lastName, double amountOfMoney) {
        users.add(new User(firstName, lastName, amountOfMoney));
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    public void showUsers() {
        for (User user : users) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }

    public User searchUser(String idUser) {
        User result = null;
        for (User user : users) {
            if (user.getId().equals(idUser)) {
                result = user;
                break;
            }
        }
        return result;
    }

    public Product searchProduct(String idProduct) {
        Product result = null;
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(idProduct)) {
                result = product;
                break;
            }
        }
        return result;
    }

    public void buyProduct(String idUser, String idProduct) {
        var user = searchUser(idUser);
        var product = searchProduct(idProduct);

        if ((user.getAmountOfMoney() - product.getPrice()) < 0) {
            throw new IllegalStateException("You don't have enough money");
        }

        user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
        user.addProductForUser(product);
        System.out.println("Purchase successful");
    }

    public void showUserProducts(String idUser) {
        var user = searchUser(idUser);
        //Check for empty list
        if (!user.getUserProducts().isEmpty()) {
            //Show product
            for (Product product : user.getUserProducts()) {
                System.out.println(product.getName());
            }
        }
    }

    public void showUsersBoughtProduct(String idProduct) {
        var product = searchProduct(idProduct);
        //User in users
        for (User user : users) {
            //Check for empty
            if (!user.getUserProducts().isEmpty()) {
                //Product of user
                for (Product productOfUser : user.getUserProducts()) {
                    if (productOfUser.equals(product)) {
                        System.out.println(user.getFirstName() + " " + user.getLastName());
                        break;
                    }
                }
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteUser(String idUser) {
        var user = searchUser(idUser);
        if (user != null) {
            users.remove(user);
        } else {
            System.out.println("User not found.");
        }
    }

    public void deleteProduct(String idProduct) {
        var product = searchProduct(idProduct);
        if (product != null) {
            products.remove(product);
            for (User user : users) {
                user.removeProduct(product);
            }
        } else {
            System.out.println("Product not found.");
        }
    }
}



