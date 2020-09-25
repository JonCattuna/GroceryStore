/**
 * This class is the shopping bag it holds the array of items and the methods that control the shopping bag
 * each method manipulates the array of items depending on the users input
 * Uses grocery item to control the array and the bag
 * @author Jonathan Cattuna, George Job
 */

public class ShoppingBag 
{
	private GroceryItem[] bag;
	private int size;

	/**
	 * Creates new ShoppingBag object
	 */
	public ShoppingBag()
	{
		bag = new GroceryItem[5];
		size = 0;
	}
	
	/**
	 * @param item GroceryItem to search for in the ShoppingBag
	 * @return index of the GroceryItem in the ShoppingBag, returns -1 if not found
	 */
	private int find(GroceryItem item)
	{
		for(int i = 0; i < size; i++)
		{
			if(bag[i].equals(item))
				return i;
		}
		return -1;
	}
	
	/**
	 * Grows the bag size by 5 when it reachs capacity and holds a capacity variable that is changing per item added
	 */
	private void grow()
	{
		GroceryItem[] temp = new GroceryItem[bag.length + 5];

		for (int i = 0; i < bag.length; i++)
		{
			temp[i] = bag[i];
		}
		bag = temp;
	}
	
	/**
	 * adds one item into the shopping bag array and increases the current 
	 * size of the bag and adds on the end and gets a new index
	 * @param item GroceryItem to be added to the bag
	 */
	public void add(GroceryItem item)
	{
		if(size == bag.length)
		{
			grow();
			bag[size] = item;
			size++;
		}
		else
		{
			bag[size] = item;
			size++;
		}
	}
	
	/**
	 * Removes one object from the array and replaces it with the item in the last index
	 * reorganize shopping bag array but order doesn't matter because of find method.
	 * @param item GroceryItem to be removed from bag 
	 * @return true if removed, false if item not removed
	 */
	public boolean remove(GroceryItem item)
	{
		int itemIndex = find(item);
		if(itemIndex >= 0)
		{
			bag[itemIndex] = bag[size-1];
			bag[size-1] = null;
			size--;
			return true;
		}
		
		return false;
	}
	
	/**
	 * tracks sales price of full cart based on items inside
	 * @return total sales price
	 */
	public double salesPrice()
	{
		double totalSalesPrice=0;
		for(GroceryItem item : bag)
		{
			if(item != null)
				totalSalesPrice += item.getPrice();
		}
		
		return totalSalesPrice;
	}
	
	/**
	 * tracks which items are taxable and which are not and adds tax based on their price
	 * @return total sales tax
	 */
	public double salesTax()
	{
		double totalSalesTax=0;
		for(GroceryItem item : bag)
		{
			if(item != null)
			{
				if(item.isTaxable())
					totalSalesTax += (item.getPrice() * 0.06625);
			}
		}
		return totalSalesTax;
	}
	
	/**
	 * prints all items in current cart, if empty displays "bag is empty"
	 */
	public void print()
	{
		if(size == 0)
		{
			System.out.println("The bag is empty!");
		}
		else
		{
			System.out.println("**You have " + size + " items in the bag.");
			for(GroceryItem item : bag)
			{
				if(item != null)
					System.out.println(item.toString());
			}
			System.out.println("**End of list");
		}
	}
	
	/**
	 * Prints out items when the user tries to check out
	 */
	public void checkoutPrint()
	{
		for(GroceryItem item : bag)
		{
			if(item != null)
				System.out.println(item.toString());
		}
	}

	/**
	 * gets the size of the array
	 * @return size of array
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * clears the array and empties the shopping bag
	 * @return empty shopping bag array
	 */
	public void emptyShoppingBag() 
	{
		for(int i = 0; i < bag.length; i++)
			bag[i] = null;
		size = 0;
	}
	
	/**
	 * Get array length of the array used for the current shopping bag
	 * @return length of array for shopping bag
	 */
	public int getArrayLength()
	{
		return bag.length;
	}
	
	/**
	 * Test Bed Main. Test Cases for the methods in this class are tested here.
	 * @param args
	 */
	public static void main(String args[])
	{
		ShoppingBag testBag = new ShoppingBag();
		testBag.add(new GroceryItem("chicken", 2.99, false));
		
		System.out.println("Test Case 1 Result: ");
		testBag.print();
		System.out.println();
		
		testBag.add(new GroceryItem("chicken", 2.99, false));
		testBag.add(new GroceryItem("chicken", 2.99, false));
		testBag.add(new GroceryItem("chicken", 2.99, false));
		testBag.add(new GroceryItem("chicken", 2.99, false));
		testBag.add(new GroceryItem("chicken", 2.99, false));
		
		System.out.println("Test Case 2 Result: ");
		testBag.print();
		System.out.println();
		
		testBag.remove(new GroceryItem("chicken", 2.99, false));
		
		System.out.println("Test Case 3 Result: ");
		testBag.print();
		System.out.println();
		
		testBag.remove(new GroceryItem("toast", 5.95, false));
		
		System.out.println("Test Case 4 Result: ");
		testBag.print();
		System.out.println();
		
		testBag.emptyShoppingBag();
		
		System.out.println("Test Case 5 Result: ");
		System.out.println("Current bag size before grow: " + testBag.getArrayLength());
		testBag.grow();
		System.out.println("Current bag size after grow: " + testBag.getArrayLength());
		System.out.println();
		
		testBag.add(new GroceryItem("chicken", 2.99, true));
		testBag.add(new GroceryItem("chicken", 2.99, true));
		
		System.out.println("Test Case 6 Result: ");
		System.out.printf("Sales Tax: %.2f\n", testBag.salesTax());
	}
}


