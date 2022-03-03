package com.example.myapplication;
import java.util.ArrayList;
/**
 * Sets up and manages the list of menu items
 * within an order. Also computes their total price.
 * @author Muhammad Saleem, Jessie Choucrallah
 */
public class Order implements Customizable
{
    private ArrayList<MenuItem> items = new ArrayList();
    private double price;
    private int  orderNumber = 0;


    /**
     * Default constructor.
     */
    public Order()
    {

    }

    /**
     * Sets the order number for the current order.
     * @param orderNumber Number for order.
     */
    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    /**
     * Computes the prices of all menu items.
     * @return price of the menu items
     */
    public double getTotalPrice()
    {
        double tempPrice = 0;
        for (int i = 0; i < items.size();i++)
        {
            tempPrice = tempPrice + items.get(i).getPrice();

        }
        price = tempPrice;

        return price;
    }


    /**
     * Gets list of menu items.
     * @return array list of menu items
     */
    public ArrayList getListItems()
    {
        return items;
    }


    /**
     * Removes a menu item from the order.
     * @param obj Menu Item object.
     * @return true if menu item was added, false otherwise
     */
    @Override
    public boolean add(Object obj)
    {
        items.add((MenuItem) obj);
        return true;
    }


    /**
     * Adds a menu item from the order.
     * @param obj Menu Item object.
     * @return true if menu item was removed, false otherwise
     */
    @Override
    public boolean remove(Object obj)
    {
        items.remove(obj);
        return true;
    }

    /**
     * ToString Method to output the human readable text to the order.
     */
    @Override
    public String toString()
    {
        return "# " + orderNumber + items.toString();

    }

    /**
     * Getter method used to get the price.
     *
     * @return price of order
     */
    public double getPrice() {

        return this.price;
    }


}