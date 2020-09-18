
public class ShoppingBag 
{
	private GroceryItem[] bag;
	private int size;
	
	//increase capactiy 5 everyitme size is = to capaticty
	//add +1 remove -1 from size not capacitiy
	public ShoppingBag()
	{
		
	}
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
	private int grow()
	{
		
	}
	public void add(GroceryItem item)
	{
		
	}
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
	public double salesPrice()
	{
		
	}
	public double salesTax()
	{
		
	}
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
