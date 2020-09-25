/**
 * This class is the object that is used in all other classes
 * also controls the format of the output
 * rewitten equals method and tostring
 * @author Jonathan Cattuna, George Job
 */

import java.text.DecimalFormat;

public class GroceryItem 
{
	private String name;
	private double price;
	private boolean taxable;
	
	/**
	 * Creates Grocery item objects which are manipulated all through the project taking in name price and taxable
	 * @param item name
	 * @param item price
	 * @param taxable status
	 */
	public GroceryItem(String name, double price, boolean taxable)
	{
		this.name = name;
		this.price = price;
		this.taxable = taxable;
	}
	
	
	/**
	 * Take the Scan and will have a price/name/taxable 
	 * and pull pieces apart in toString then move them to the other classes
	 * @param item to be compared
	 * @return true or false if it is equal
	 */
	public boolean equals(GroceryItem item)
	{
		if((name.equals(item.name) && price == item.price && taxable == item.taxable))
			return true;
		else
			return false;
	}
	
	/**
	 * Formats the output to display the correct amount of decimals and display the price item and tax status
	 * @return a new format for output
	 */
	public String toString()
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		if(taxable)
			return "·" + name + ": $" + df.format(price) + " : is taxable";
		else
			return "·" + name + ": $" + df.format(price) + " : tax free";
	}

	/**
	 * Price getter
	 * @return item price
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * takes in the price and formats it for output
	 * @return price formatted
	 */
	public String getStringPrice()
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		return df.format(price);
	}
	
	/**
	 * checks taxable
	 * @return true or false if taxable
	 */
	public boolean isTaxable()
	{
		return taxable;
	}
	
	/**
	 * Name getter
	 * @return item name
	 */
	public String getName()
	{
		return name;
	}
}