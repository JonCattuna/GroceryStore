/**
 * This class is the shopping bag it holds the array of items and the methods that control the shopping bag
 * each method manipulates the array of items depending on the users input
 * Uses grocery item to control the array and the bag
 * @author Jonathan Cattuna, George Job
 */




import java.text.DecimalFormat;

public class ShoppingBag 
{
	private GroceryItem[] bag;
	private int size;
	
	

	public ShoppingBag()
	{
		bag = new GroceryItem[5];
		size = 0;
	}
	
	
	
	/**
	 * find the index of each item in the shopping bag array
	 * @param item
	 * @return i or -1
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
	 * 
	 * 
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
	 * @param item
	 * 
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
	 * reorganize shopping bag array but order doesnt matter because of find method.
	 * @param item
	 * @return true or false
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
	 * 
	 * @return totalSalesPrice
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
	 * 
	 * @return totalSalesTax
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
	 * 
	 * 
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
	 * 
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
	 *
	 * @return size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * clears the array and empties the shopping bag
	 * 
	 */
	public void emptyShoppingBag() 
	{
		for(int i = 0; i < bag.length; i++)
			bag[i] = null;
		size = 0;
	}
}