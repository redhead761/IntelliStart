import java.util.Scanner;

public class Test {

    public String SearchIdOfProduct(MarketPlace marketPlace, String name) {
        String result = "Product not found";
        for (Product product : marketPlace.getProducts()) {
            if (product.getName().equals(name)) {
                result = product.getId();
            }
        }
        return result;
    }

    public String SearchIfOfUser(MarketPlace marketPlace, String firstName, String lastName) {
        String result = "User not found";
        for (User user : marketPlace.getUsers()) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                result = user.getId();
            }
        }
        return result;
    }

    public static void main(String[] args) throws MarketPlace.BuyException {

        MarketPlace marketPlace = new MarketPlace();
        Test test = new Test();

        while (true) {
            System.out.println("Please, input number:\n" +
                    "1.Add product\n" +
                    "2.Add user\n" +
                    "3.Display list of all users\n" +
                    "4.Display list of all products\n" +
                    "5.Buy product\n" +
                    "6.Display list of user products\n" +
                    "7.Display list of users that bought product\n" +
                    "8.Close");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                System.out.print("Please enter name's product: ");
                String name = scanner.nextLine();

                System.out.print("Please enter price's product: ");
                try {
                    double price = scanner.nextDouble();
                    marketPlace.addProduct(name, price);
                } catch (Exception e) {
                    System.out.println("You entered invalid value.");
                }
            } else if (userInput.equals("2")) {
                System.out.print("Please enter your first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Please enter your last name: ");
                String lastName = scanner.nextLine();

                System.out.print("Please enter your amount of money: ");
                try {
                    double amountOfMoney = scanner.nextDouble();
                    marketPlace.addUser(firstName, lastName, amountOfMoney);
                } catch (Exception e) {
                    System.out.print("You entered invalid value.");
                }
            } else if (userInput.equals("3")) {
                marketPlace.showUsers();
            } else if (userInput.equals("4")) {
                marketPlace.showProducts();
            } else if (userInput.equals("5")) {
                System.out.print("Please, enter first name's user: ");
                String firstName = scanner.nextLine();
                System.out.print("Please, enter last name`s user: ");
                String lastName = scanner.nextLine();

                String idUser = test.SearchIfOfUser(marketPlace, firstName, lastName);

                System.out.print("Please enter name`s product: ");
                String name = scanner.nextLine();
                String idProduct = test.SearchIdOfProduct(marketPlace, name);

                try {
                    marketPlace.buyProduct(idUser, idProduct);
                }
                catch (MarketPlace.BuyException ex){
                    System.out.println(ex.getMessage());
                }
            } else if (userInput.equals("6")) {
                System.out.print("Please, enter first name's user: ");
                String firstName = scanner.nextLine();
                System.out.print("Please, enter last name`s user: ");
                String lastName = scanner.nextLine();

                String idUser = test.SearchIfOfUser(marketPlace, firstName, lastName);

                marketPlace.showUserProducts(idUser);
            } else if (userInput.equals("7")) {
                System.out.print("Please enter name`s product: ");
                String name = scanner.nextLine();
                String idProduct = test.SearchIdOfProduct(marketPlace, name);

                marketPlace.showUsersBoughtProduct(idProduct);
            } else if (userInput.equals("8")) {
                break;
            } else {
                System.out.println("You entered incorrect value.");
            }
        }
    }
}
