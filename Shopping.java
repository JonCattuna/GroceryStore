/**
 * This class hold the scanner and takes in the users input
 * controls the output of the project and takes in all user input
 * @author Jonathan Cattuna, George Job
 */

import java.util.Scanner;

public class Shopping 
{
	private ShoppingBag shoppingBag;
	
	/**
	 * Creates new shopping bag
	 */
	public Shopping()
	{
		shoppingBag = new ShoppingBag();
	}
	
	/**
	 * Create scanner and take in user input
	 * send it over to grocery item as a string
	 * @param cmdArray: parsed input from user
	 * @return GroceryItem created from user input
	 */
	private GroceryItem parseCommand(String[] cmdArray)
	{
		String name = cmdArray[1];
		Float price = Float.parseFloat(cmdArray[2]);
		boolean taxable = Boolean.parseBoolean(cmdArray[3]);
		return new GroceryItem(name, price, taxable);
	}
	
	/**
	 * Checks out the shopping bag and displays the price and items
	 */
	public void checkout()
	{
		int shoppingBagSize = shoppingBag.getSize();
		if(shoppingBagSize > 0)
		{
			System.out.println("**Checking out " + shoppingBagSize + " item(s):");
			shoppingBag.checkoutPrint();
			System.out.printf("*Sales total: $%.2f\n", shoppingBag.salesPrice());
			System.out.printf("*Sales tax: $%.2f\n", shoppingBag.salesTax());
			System.out.printf("*Total amount paid: $%.2f\n", (shoppingBag.salesPrice() + shoppingBag.salesTax()));
			shoppingBag.emptyShoppingBag();
		}
		else
		{
			System.out.println("Unable to check out, the bag is empty!");
		}
	}
	
	/**
	 * creates the scanner that takes command line input uses a switch case and for each input of "A" "R" "P" "C" "Q" performs the corresponding method from shopping bag
	 */
	public void run()
	{
		System.out.println("Let's start shopping!");
		boolean currentlyShopping = true;
		while(currentlyShopping)
		{
			Scanner keyboard = new Scanner(System.in);
			String cmd = keyboard.nextLine();
			String[] cmdArray = cmd.split(" ");
			
			switch(cmdArray[0])
			{
				case "A":
					GroceryItem item = parseCommand(cmdArray);
					shoppingBag.add(item);
					System.out.println(item.getName() + " added to the bag.");
					break;
					
				case "R":
					GroceryItem itemRemove = parseCommand(cmdArray);
					if(shoppingBag.remove(itemRemove))
						System.out.println(itemRemove.getName() + " " + itemRemove.getStringPrice() + " removed.");
					else
						System.out.println("Unable to remove, this item is not in the bag.");
					break;
					
				case "P":
					shoppingBag.print();
					break;
					
				case "C":
					checkout();
					break;
					
				case "Q":
					if(shoppingBag.getSize() > 0)
					{
						checkout();
						System.out.println("Thanks for shopping with us!");
					}
					else
					{
						System.out.println("Thanks for shopping with us!");
					}
					
					currentlyShopping = false;
					break;
					
				default:
					System.out.println("Invalid command");
					
			}
		}
	}
}