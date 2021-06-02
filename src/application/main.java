package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date dateBirth = sdf.parse(sc.nextLine());
		System.out.printf("\nEnter order data: ");
		String orderStatus = sc.nextLine();

		Client client = new Client(name, email, dateBirth);
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);

		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		for (int i = 1; i <= items; i++) {
			System.out.printf("Enter #%d item data:\n", i);
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(quantity, product);
			order.addItem(orderItem);
		}
		System.out.println(order);
	}
}
