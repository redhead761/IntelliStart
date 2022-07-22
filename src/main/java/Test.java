import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        MarketPlace marketPlace = new MarketPlace();

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
                System.out.print("Please, enter id user: ");
                String idUser = scanner.nextLine();

                System.out.print("Please enter id product: ");
                String idProduct = scanner.nextLine();

                marketPlace.buyProduct(idUser, idProduct);
            } else if (userInput.equals("6")) {
                System.out.print("Please, enter id user: ");
                String idUser = scanner.nextLine();

                marketPlace.showUserProducts(idUser);
            } else if (userInput.equals("7")) {
                System.out.print("Please enter id product: ");
                String idProduct = scanner.nextLine();

                marketPlace.showUsersBoughtProduct(idProduct);
            } else if (userInput.equals("8")) {
                break;
            } else {
                System.out.println("You entered incorrect value.");
            }
        }
    }
}
