import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AssEx1 {
	public static void main(String[] args) {
		String filePath = "statement.txt"; // declare stuff
		FileWriter fw;
		BufferedWriter buf = null;
		Scanner scan = new Scanner(System.in);
		String customerName;
		while (true) {
			System.out.println("enter customer name: ");
			customerName = scan.nextLine(); // customer name = set of any characters
			if ((customerName.trim().length() > 0)) {
				break;
			}
		}
		double customerBalance = 0; // declared outside the try/catch block as to be used after
		while (true) {
			try {
				System.out.println("enter customer balance: ");
				customerBalance = scan.nextDouble();
				scan.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Wrong entry! It should be a number.");
				scan.nextLine(); // consuming the invalid token left after last entry
			}
		}
		int customerBalanceInPence = (int) (customerBalance * 100); // converting pounds into pence
		Customer customer = new Customer(customerName, customerBalanceInPence);
		System.out.println("Welcome " + customer.toString());
		try { // prepare to write customer details into a file later when 'flush'
			fw = new FileWriter(filePath);
			buf = new BufferedWriter(fw);
			buf.write(customer.toString());
			buf.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) { // keyboard input of all wines
			System.out.println("enter wine name or press enter to exit: ");
			String wineName = scan.nextLine(); // wine name is allowed to be just space characters
			if (!(wineName.trim().length() > 0)) { // if keyboard input is blank -> break out of the loop
				break;
			} else {
				int wineQuantity = 0; // to create object Wine value of the args is needed
				Wine wine = new Wine(wineName, wineQuantity, 0);
				while (true) {
					try {
						System.out.println("enter quantity: (negative for returns)");
						int quantityInput = scan.nextInt();
						wine.quantityException(quantityInput);
						wine.setWineQuantity(quantityInput);
						break;
					} catch (InputMismatchException e) {
						System.out.println("Wrong entry! Quantity is a whole number.");
						scan.nextLine();
					} catch (Exception e) {
						System.out.println("Quantity cannot be zero");
						scan.nextLine();
					}
				}
				double winePrice = 0;
				while (true) {
					try {
						System.out.println("enter wine price: ");
						double priceInput;
						priceInput = scan.nextDouble();
						wine.priceException(priceInput);
						winePrice = priceInput;
						wine.setWinePrinceInPence(winePrice);
						break;
					} catch (InputMismatchException e) {
						System.out.println("Wrong entry! Enter a number.");
						scan.nextLine();
					} catch (Exception e) {
						System.out.println("Price must be always positive!");
						scan.nextLine();
					}
				}
				scan.nextLine();
				customer.balanceUpdate(wine.getWinePriceInPence(), wine.getWineQuantity());
				wine.WineGetCustomerBalance(customer.getCustomerBalance());
				System.out.println(customer);
				try { // preparing to write info after every cycle
					buf.write(wine.toString());
					buf.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try { // write all prepared info at once as that is quicker and more efficient
			buf.flush();
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}