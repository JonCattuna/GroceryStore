import java.util.Scanner;

public class Shopping 
{
	private ShoppingBag shoppingBag;
	
	public Shopping()
	{
		shoppingBag = new ShoppingBag();
	}
	//Create scanner and take in user input
	//send it over to grocery item as a string
	private GroceryItem parseCommand(String[] cmdArray)
	{
		String name = cmdArray[1];
		Float price = Float.parseFloat(cmdArray[2]);
		boolean taxable = Boolean.parseBoolean(cmdArray[3]);
		return new GroceryItem(name, price, taxable);
	}
	
	
	//creates the scanner that takes command line input
	//uses a switch case and for each input of "A" "R" "P" "C" "Q" performs the corresponding method from shopping bag
	public void run()
	{
		while(true)
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.println(keyboard.nextLine());
			String cmd = keyboard.nextLine();
			String[] cmdArray = cmd.split(" ");
			//System.out.println(cmdArray[0]);
			
			switch(cmdArray[0].toUpperCase())
			{
				case "A":
					System.out.println("Add ");
					GroceryItem item = parseCommand(cmdArray);
					shoppingBag.add(item);
					System.out.println(item.toString());
					break;
					
				case "R":
					System.out.println("Remove ");
					GroceryItem itemRemove = parseCommand(cmdArray);
					shoppingBag.remove(itemRemove);
					break;
					
				case "P":
					System.out.println("Print ");
					//GroceryItem printer = parseCommand(cmdArray);
					shoppingBag.print();
					break;
					
				case "C":
					System.out.println("Checking out");
					//Display total items in cart
					//display price
					//display tax
					break;
					
				case "Q":
					System.out.println("Quit");
					//Perform same commands as "C" unless bag is empty
					break;
					
				default:
					System.out.println("Invalid command");
					
			}
		}
		
	}
}
