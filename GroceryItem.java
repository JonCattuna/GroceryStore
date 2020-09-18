import java.text.DecimalFormat;

public class GroceryItem 
{
	private String name;
	private double price;
	private boolean taxable;
	
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
		if((name.equals(item.name) && price == item.price && taxable == item.taxable)
			return true;
		else
			return false;
	}
	public String toString()
	{
		String pattern = "$#.00";
		DecimalFormat priceFormatter = new DecimalFormat(pattern);
		return name + " " + Double.toString(price) + " " + Boolean.toString(taxable);
	}

}
