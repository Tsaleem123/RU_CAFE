package com.example.myapplication;


import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class allows the user to order 3 different types of donuts with various flavors for each.
 * @author Muhammad Saleem, Jessie Choucrallah
 */
public class Donut extends MenuItem implements Customizable {
    protected final double DONUT_PRICE = 1.39;
    String flavor = "";
    private int donutCount = 1;
    private ArrayList<String> flavors = new ArrayList();
    private DecimalFormat df = new DecimalFormat("0.00");


    /**
     * method to set the flavor of the donut
     * @param flavorName to set the flavor name of the donut
     */

    public void setFlavor(String flavorName)
    {
        flavor = flavorName;

    }

    /**
     * method to set the donut count
     * @param donutCount keeps track of the amount of donuts
     */
    public void setCount(int donutCount)
    {
        this.donutCount = donutCount;
    }


    /**
     * ToString Method to output the human readable text to the order.
     * @return string text of donut order
     */
    @Override
    public String toString()
    {
        return flavor + " " + "(" + donutCount +")" + " " + "$" + df.format(price);
    }

    /**
     * method to calculate the price
     */
    @Override
    public void itemPrice()
    {
        price = DONUT_PRICE * donutCount;
    }
    /**
     * Method to add a flavor
     * @param obj from our Customizable interface
     * @return true if donut was added, false otherwise
     */
    @Override
    public boolean add(Object obj)
    {
        flavors.add((String)obj);
        return true;
    }

    /**
     * Method to remove a flavor
     * @param obj from our Customizable interface
     * @return true if donut was removed, false otherwise
     */
    @Override
    public boolean remove(Object obj)
    {
        flavors.remove((String)obj);
        return true;
    }
}