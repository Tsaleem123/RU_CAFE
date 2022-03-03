package com.example.myapplication;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Method to create the menu item object
 * coffee, which can be stored into a order.
 * Contains functionality for addins, quantity
 * and coffee sizes.
 * @author Muhammad Saleem, Jessie Choucrallah
 *
 */
public class Coffee extends MenuItem implements Customizable
{

    private int addInCount = 0;
    private int sizeCount = 0;
    private int coffeeCount = 1;
    private String size = "Short";
    private ArrayList<String> addInsList = new ArrayList();
    private DecimalFormat df = new DecimalFormat("0.00");


    /**
     * Default Coffee constructor.
     */
    public Coffee() {

    }

    /**
     * Sets the coffee size.
     * @param size  Size to be set.
     */
    public void setSize(String size)
    {
        this.size = size;

    }

    /**
     * Sets the count which will be used to compute
     * the price depending the size.
     * @param sizeCount Size counter to determine coffee size increase.
     */
    public void setBaseCount(int sizeCount)
    {
        this.sizeCount = sizeCount;

    }

    /**
     * Sets the quantity for the coffee item.
     * @param count count for number of coffees.
     */
    public void setQuantity( int count )
    {
        this.coffeeCount = count;
    }

    /**
     * Computes the item price.
     */
    @Override
    public void itemPrice()
    {
        price = (MagicNumbers.BASE_PRICE + ( addInCount * MagicNumbers.ADD_IN_PRICE ) + ( sizeCount * MagicNumbers.INCREASE )) * coffeeCount;

    }

    /**
     * Increases addins count.
     */
    public void addInIncrease()
    {
        addInCount = addInCount + 1;
    }

    /**
     * Decrease addins count.
     */
    public void addInDecrease()
    {
        addInCount = addInCount - 1;
    }

    /**
     * Checks if a coffee is empty.
     * @return string
     */
    public String emptyChecker(){
        if (addInsList.size() == 0)
        {
            return "";

        }
        else
        {
            return addInsList.toString();
        }
    }

    /**
     * Makes a readable string for coffee item.
     * @return string format of coffee
     */
    @Override
    public String toString()
    {
        return "Coffee " + "(" + coffeeCount + ")" + " " + size +" "
                + emptyChecker() + " $" + df.format(price);
    }

    /**
     * Method to add an addin.
     * @param obj Addin string.
     * @return true if coffee addin was added, false otherwise
     */
    @Override
    public boolean add(Object obj)
    {
        addInsList.add((String)obj);
        return true;
    }

    /**
     * Method to remove an addin.
     * @param obj Addin String.
     * @return true if coffee addin was removed, false otherwise
     */
    @Override
    public boolean remove(Object obj)
    {
        addInsList.remove((String)obj);
        return true;
    }


}
