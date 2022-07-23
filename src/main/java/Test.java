import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public @Nullable String searchIdOfProduct(@NotNull MarketPlace marketPlace, String name) {
        String result = null;
        for (Product product : marketPlace.getProducts()) {
            if (product.getName().equals(name)) {
                result = product.getId();
                break;
            }
        }
        return result;
    }

    public @Nullable String searchIdOfUser(@NotNull MarketPlace marketPlace, String firstName, String lastName) {
        String result = null;
        for (User user : marketPlace.getUsers()) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                result = user.getId();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        MarketPlace marketPlace = new MarketPlace();
        Test test = new Test();

        label:
        while (true) {
            System.out.println("Please, input number:\n" +
                    "1.Add product\n" +
                    "2.Add user\n" +
                    "3.Display list of all users\n" +
                    "4.Display list of all products\n" +
                    "5.Buy product\n" +
                    "6.Display list of user products\n" +
                    "7.Display list of users that bought product\n" +
                    "8.Delete user\n" +
                    "9.Delete product\n" +
                    "10.Close");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1": {
                    onAddProductSelected(marketPlace, scanner);
                    break;
                }
                case "2": {
                    onAddUserSelected(marketPlace, scanner);
                    break;
                }
                case "3":
                    marketPlace.showUsers();
                    break;
                case "4":
                    marketPlace.showProducts();
                    break;
                case "5": {
                    onBuyProductSelected(marketPlace, test, scanner);
                    break;
                }
                case "6": {
                    onDisplayUsersProduct(marketPlace, test, scanner);
                    break;
                }
                case "7": {
                    onDisplayUsersBoughtProduct(marketPlace, test, scanner);
                    break;
                }
                case "8": {
                    onDeleteUser(marketPlace, test, scanner);
                    break;
                }
                case "9": {
                    onDeleteProduct(marketPlace, test, scanner);
                    break;
                }
                case "10":
                    break label;
                default:
                    System.out.println("You entered incorrect value.");
                    break;
            }
        }
    }

    private static void onDeleteProduct(MarketPlace marketPlace, Test test, Scanner scanner) {
        System.out.print("Please enter name`s product: ");
        String name = scanner.nextLine();
        String idProduct = test.searchIdOfProduct(marketPlace, name);

        marketPlace.deleteProduct(idProduct);
    }

    private static void onDeleteUser(MarketPlace marketPlace, Test test, Scanner scanner) {
        System.out.print("Please, enter first name's user: ");
        String firstName = scanner.nextLine();
        System.out.print("Please, enter last name`s user: ");
        String lastName = scanner.nextLine();

        String idUser = test.searchIdOfUser(marketPlace, firstName, lastName);

        marketPlace.deleteUser(idUser);
    }

    private static void onDisplayUsersBoughtProduct(MarketPlace marketPlace, Test test, Scanner scanner) {
        System.out.print("Please enter name`s product: ");
        String name = scanner.nextLine();
        String idProduct = test.searchIdOfProduct(marketPlace, name);

        marketPlace.showUsersBoughtProduct(idProduct);
    }

    private static void onDisplayUsersProduct(MarketPlace marketPlace, Test test, Scanner scanner) {
        System.out.print("Please, enter first name's user: ");
        String firstName = scanner.nextLine();
        System.out.print("Please, enter last name`s user: ");
        String lastName = scanner.nextLine();

        String idUser = test.searchIdOfUser(marketPlace, firstName, lastName);

        marketPlace.showUserProducts(idUser);
    }

    private static void onBuyProductSelected(MarketPlace marketPlace, Test test, Scanner scanner) {
        System.out.print("Please, enter first name's user: ");
        String firstName = scanner.nextLine();
        System.out.print("Please, enter last name`s user: ");
        String lastName = scanner.nextLine();

        String idUser = test.searchIdOfUser(marketPlace, firstName, lastName);

        System.out.print("Please enter name`s product: ");
        String name = scanner.nextLine();
        String idProduct = test.searchIdOfProduct(marketPlace, name);

        try {
            marketPlace.buyProduct(idUser, idProduct);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("User or product not found");
        }
    }

    private static void onAddUserSelected(MarketPlace marketPlace, Scanner scanner) {
        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter your amount of money: ");
        try {
            double amountOfMoney = scanner.nextDouble();
            marketPlace.addUser(firstName, lastName, amountOfMoney);
        } catch (InputMismatchException e) {
            System.out.print("You entered invalid value.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void onAddProductSelected(MarketPlace marketPlace, Scanner scanner) {
        System.out.print("Please enter name's product: ");
        String name = scanner.nextLine();

        System.out.print("Please enter price's product: ");
        try {
            double price = scanner.nextDouble();
            marketPlace.addProduct(name, price);
        } catch (InputMismatchException e) {
            System.out.println("You entered invalid value.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
