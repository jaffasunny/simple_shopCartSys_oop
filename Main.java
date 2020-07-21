package oopAssignment04;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	static Scanner inScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int inputInt;
		String nameString;
		double priceDouble;
		int quantityInt;
		Inventory oInventory = new Inventory();
		Order oOrder = new Order(); 
		
		boolean flag = true;
		
		do {
			menu();
			inputInt = inScanner.nextInt();
			if(inputInt == 1) {
				itemList();
				inputInt = inScanner.nextInt();
				if(inputInt == 1) {
					System.out.println("---------Clothes---------");
					System.out.print("Enter Name: ");
					nameString = inScanner.next();
					System.out.print("Enter Price: ");
					priceDouble = inScanner.nextDouble();
					System.out.print("Enter Quantity: ");
					quantityInt = inScanner.nextInt();
					
					Item clothObjClothes = new Clothes(nameString, priceDouble, quantityInt);
					oInventory.addInventory(clothObjClothes);
				}
				else if(inputInt == 2) {
					System.out.println("---------Electronics---------");
					System.out.print("Enter Name: ");
					nameString = inScanner.next();
					System.out.print("Enter Price: ");
					priceDouble = inScanner.nextDouble();
					System.out.print("Enter Quantity: ");
					quantityInt = inScanner.nextInt();
					
					Item electroObj = new Electronics(nameString, priceDouble, quantityInt);
					oInventory.addInventory(electroObj);
				}
				else if (inputInt == 3) {
					System.out.println("---------Cosmetics---------");
					System.out.print("Enter Name: ");
					nameString = inScanner.next();
					System.out.print("Enter Price: ");
					priceDouble = inScanner.nextDouble();
					System.out.print("Enter Quantity: ");
					quantityInt = inScanner.nextInt();
					
					Item cosmeObj = new Cosmetics(nameString, priceDouble, quantityInt);
					oInventory.addInventory(cosmeObj);
				}
			}
			else if (inputInt == 2) {
				System.out.println("You can add to your cart from the following");
				System.out.println(oInventory.getItems());
				
				System.out.print("Enter Name: ");
				nameString = inScanner.next();
				System.out.print("Enter Quantity: ");
				quantityInt = inScanner.nextInt();
				
				placeOrder(oInventory, nameString, oOrder, quantityInt);
				System.out.println("\n");

				boolean flag2 = true;
				while (flag2){	
					System.out.println("Enter");
					System.out.println("1. For Adding more Items to cart");
					System.out.println("2. For Completing Order");
					System.out.print("> ");
					inputInt = inScanner.nextInt();
					System.out.println();
					if(inputInt == 1) {
						System.out.println(oInventory.getItems());
						System.out.print("Enter Name: ");
						nameString = inScanner.next();
						System.out.print("Enter Quantity: ");
						quantityInt = inScanner.nextInt();
						placeOrder(oInventory, nameString, oOrder, quantityInt);
					}
					else if(inputInt == 2) {
						System.out.println("Your Order Details:");
						System.out.println("-------------------");
						System.out.println(oOrder.toString());
						flag2 = false;
					}
					else {
						System.out.println("Error: Wrong Option while adding more cart!");
					}
				} 
			}
			else if (inputInt == 3) {
				System.out.println("Total Items list in Inventory: ");
				System.out.println("-------------------------------");
				System.out.println(oInventory.getItems());
			}
			else if (inputInt == 4) {
				System.out.println("Your Order details.");
				System.out.println("-------------------");
				System.out.println(oOrder.getOrderItems());
			}
			else if (inputInt == 5) {
				System.out.println("All Details");
				System.out.println("-----------");
				oInventory.getItems();
				System.out.println(oInventory.getItems());
				System.out.println(oOrder.toString());
				
			}
			else if (inputInt == 6) {
				System.out.println("---------------------");
				System.out.println("Hope to see you soon!");
	            System.out.println("Tata!");
				flag=false;
			}
			else {
				System.out.println("Error: Sorry wrong Menu Option!");
			}
		} while (flag);
		
	}
	
	public static void placeOrder(Inventory oInventory, String nameString, Order oOrder, int quantityInt) {
		for(Item item : oInventory.getItems()) {
//			System.out.println(item);
			if(item.getName().equals(nameString)) {
				oOrder.addItem(new Clothes(item.getName(), item.getPrice(), quantityInt));
				oOrder.calcOrderTotal();
				 System.out.println("\nOrder Total:" + oOrder.getOrderTotal());
				 System.out.println(oOrder.getOrderItems());
				 quantityInt = item.getQuantity() - quantityInt;
				 item.setQuantity(quantityInt); 
			}
			else if (item.getName().equals(nameString)) {
				oOrder.addItem(new Electronics(item.getName(), item.getPrice(), quantityInt));
				oOrder.calcOrderTotal();
				System.out.println("\nOrder Total:" + oOrder.getOrderTotal());
				System.out.println(oOrder.getOrderItems());
				quantityInt = item.getQuantity() - quantityInt;
				item.setQuantity(quantityInt);				
			}
			else if (item.getName().equals(nameString)) {
				oOrder.addItem(new Cosmetics(item.getName(), item.getPrice(), quantityInt));
				oOrder.calcOrderTotal();
				System.out.println("\nOrder Total:" + oOrder.getOrderTotal());
				System.out.println(oOrder.getOrderItems());
				quantityInt = item.getQuantity() - quantityInt;
				item.setQuantity(quantityInt);				
			}
		}
	}
	
	public static void menu() {
		System.out.println("============================");
		System.out.println("Welcome to Inventory System!");
		System.out.println("============================");
		System.out.println("1. Add Inventory");
		System.out.println("2. Add Order");
		System.out.println("3. Show Inventory");
		System.out.println("4. Show Orders");
		System.out.println("5. Show All Details");
		System.out.println("6. Exit System\n");
		
		System.out.print("> ");
	}
	
	public static void itemList() {
		System.out.println("You can add Items from the following");
		System.out.println("1. Clothes");
		System.out.println("2. Electronics");
		System.out.println("3. Cosmetics\n");
		System.out.print("> ");
	}
}

class Inventory{
	ArrayList<Item> inventoryItems = new ArrayList<Item>();
	ArrayList<Order> inventoryOrders = new ArrayList<Order>();
	
	public void addInventory(Item Item) {
		inventoryItems.add(Item);
	}
	
	public ArrayList<Item> getItems() {
		return inventoryItems;
	}
	
	public ArrayList<Order> getOrders() {
		return inventoryOrders;
	}
	
	@Override
	public String toString() {
		return "Type: " + getItems() +
				"Orders: " + getOrders();
	}
}

class Order{
	private String prodName;
	private double orderTotal;

	ArrayList<Item> orderItems = new ArrayList<Item>();
	
	public void addItem(Item oItem) {
		orderItems.add(oItem);
	}
	
	public void removeItem(Item oItem) {
		orderItems.remove(oItem);
	}
	
	public ArrayList<Item> getOrderItems() {
		return orderItems;
	}
	
	public void calcOrderTotal() {
		orderTotal = 0.0;
		for (Item item : orderItems) {
			orderTotal = orderTotal + (item.getPrice() * item.getQuantity());
		}
	}
	
	public double getOrderTotal() {
		return orderTotal;
	}
	
	@Override
	public String toString() {
		return "Order Total: " + getOrderTotal() + "\n" + getOrderItems() ;
	}
}

abstract class Item{
	private String name;
	private double price;
	private int quantity;
	
	public Item () {}
	
	public Item(String name,double price,int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
//	@Override
//	public String toString() {
//		return "Name of Item: " + name +
//				"\nPrice of Item: " + price +
//				"\nNumber of Item " + quantity + "\n";
//	}
	
	@Override
	public abstract String toString();
}

class Clothes extends Item{
	public Clothes(String name, double price, int quantity) {
		super(name, price, quantity);
	}
	@Override
	public String toString() {
		return "TYPE: Clothes , Item-Name: " + super.getName() + ", Item-Price: " + super.getPrice() + ", Item-Quantity: " + super.getQuantity() + "\n";
	}
}

class Electronics extends Item{
	public Electronics(String name, double price, int quantity) {
		super(name, price, quantity);
	}
	@Override
	public String toString() {
		return "TYPE: Electronics , Item-Name: " + super.getName() + ", Item-Price: " + super.getPrice() + ", Item-Quantity: " + super.getQuantity() + "\n";
	}
}

class Cosmetics extends Item{
	public Cosmetics(String name, double price, int quantity) {
		super(name, price, quantity);
	}
	@Override
	public String toString() {
		return "TYPE: Cosmetics , Item-Name: " + super.getName() + ", Item-Price: " + super.getPrice() + ", Item-Quantity: " + super.getQuantity() + "\n";
	}
}