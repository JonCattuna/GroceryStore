
public class ShoppingBag 
{
	private GroceryItem[] bag;
	private int size;
	
	//increase capactiy 5 everyitme size is = to capaticty
	//add +1 remove -1 from size not capacitiy
	//Holds all methods that affect the shopping bag

	public ShoppingBag()
	{
		
	}
	
	//Finds the index of ceratin objects within the shopping bag array
	//used in every method to save time locating objects
	private int find(GroceryItem item)
	{
		int index = -1;
		for(int i = 0; i < bag.size(); i++)
		{
			if( bag[i].equals(item))
			{
				index = i;
				break;
			}
			
		}
		return index;
	}
	//Grows the bag size by 5 when it reachs capacity
	//holds a capacity variable that is changing per item added
	private int grow()
	{
		
	}
	
	//adds one item into the shopping bag array and increases the current size of the bag
	//adds on the end and gets a new index
	public void add(GroceryItem item)
	{
		
	}
	
	//Removes one object from the array and replaces it with the item in the last index
	//reorganize shopping bag array but order doesnt matter because of find method.
	public boolean remove(GroceryItem item)
	{
		int i = 0;
		
		for (i = 0; i < size; i++)
		{
			if(find(item) == bag[i])
			{
				
			}
		}
		
		
	}
	
	//tracks sales price of full cart based on items inside
	public double salesPrice()
	{
		
	}
	
	//tracks which items are taxable and which are not and adds tax based on their price
	public double salesTax()
	{
		
	}
	
	//prints all items in current cart, if empty displays "bag is empty"
	public void print()
	{
		if(bag.size() == 0)
		{
			System.out.println("The bag is empty");
		}
		else
		{
			System.out.println("You have " + bag.size() + " items in the bag");
			for(item : bag)
			{
				System.out.println(item.toSTring());
			}
		}
	}

}
