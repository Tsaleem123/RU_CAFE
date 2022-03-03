package com.example.myapplication;

import java.util.ArrayList;

/**
 * Class to manage the list of orders and compute their price.
 * @author Muhammad Saleem, Jessie Choucrallah
 */

public class StoreOrders implements Customizable
{
    private int orderNumberCounter = 1;
    private ArrayList<Order> orderList = new ArrayList<>();
    private double price;

    /**
     * Method to get the order list.
     * @return arraylist of orders
     */
    public ArrayList<Order> getOrderList()
    {
        return orderList;
    }

    /**
     * Computes price for all orders.
     * @return final price of orders
     */
    public double getFinalPrice()
    {
        double tempPrice = 0;
        for (int i = 0; i < orderList.size();i++)
        {
            tempPrice = tempPrice + orderList.get(i).getPrice();

        }
        price = tempPrice;

        return price;
    }

    /**
     * Sets the current order number.
     * @param order Order for which the number is being set.
     */
    public void setOrderNumber(Order order)
    {
        order.setOrderNumber(orderNumberCounter);
        orderNumberCounter++;

    }


    /**
     * Method to add an order.
     * @param obj Order object
     * @return true if order was added, false otherwise
     */
    @Override
    public boolean add( Object obj ) {

        if ( obj instanceof Order)
        {
            setOrderNumber((Order) obj);
            orderList.add((Order)obj );
            return true;
        }

        return false;
    }


    /**
     * Method to remove an order.
     * @param obj Order object
     * @return true if order was removed, false otherwise
     */
    @Override
    public boolean remove( Object obj ) {

        if( obj instanceof Order)
        {
            orderList.remove((Order)obj );

            return true;
        }

        return false;
    }

    /**
     * Returns the string format of orderList.
     * @return string of orderlist
     */
    @Override
    public String toString()
    {
        return orderList.toString();

    }

}