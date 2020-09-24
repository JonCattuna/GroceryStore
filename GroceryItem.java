import java.text.DecimalFormat;

public class GroceryItem 
{
	private String name;
	private double price;
	private boolean taxable;
	
	//Creates Grocery item objects which are manipulated all through the project taking in name price and taxable
	public GroceryItem(String name, double price, boolean taxable)
	{
		this.name = name;
		this.price = price;
		this.taxable = taxable;
	}
	
	
	//Take the Scan and will have a price/name/taxable
	//pull pieices apart in toString then move them to the other classes
	public boolean equals(GroceryItem item)
	{
		if((name.equals(item.name) && price == item.price && taxable == item.taxable))
			return true;
		else
			return false;
	}
	//Formats the output to display the correct amount of decimals and display the price item and tax status
	public String toString()
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		if(taxable)
			return name + ": " + df.format(price) + " : is taxable";
		else
			return name + ": " + df.format(price) + " : tax free";
	}

	public double getPrice()
	{
		return price;
	}
	
	public boolean isTaxable()
	{
		return taxable;
	}
}