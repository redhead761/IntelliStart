import java.util.ArrayList;
import java.util.List;

public class MarketPlace {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addProduct(String name, double price) {
        if (price > 0) {
            products.add(new Product(name, price));
        } else {
            System.out.println("Price сan not be less than zero.");
        }
    }

    public void addUser(String firstName, String lastName, double amountOfMoney) {
        if (amountOfMoney > 0) {
            users.add(new User(firstName, lastName, amountOfMoney));
        } else {
            System.out.println("Amount of money сan not be less than zero.");
        }
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
            }
        }
        return result;
    }

    public Product searchProduct(String idProduct) {
        Product result = null;
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(idProduct)) {
                result = product;
            }
        }
        return result;
    }

    public void buyProduct(String idUser, String idProduct) throws BuyException {
        var user = searchUser(idUser);
        var product = searchProduct(idProduct);

        if ((user.getAmountOfMoney() - product.getPrice()) < 0) {
            throw new BuyException("You don't have enough money");
        }

        user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
        user.addProductForUser(product);
        product.addUserBoughtProduct(user);
        System.out.println("Purchase successful");
    }

    class BuyException extends Exception{
        public BuyException(String message){
            super (message);
        }
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
        //Check for empty list
        if (!product.getUsersBoughtProduct().isEmpty()) {
            //Show users
            for (User user : product.getUsersBoughtProduct()) {
                System.out.println(user.getFirstName() + " " + user.getLastName());
            }
        }

    }

}
