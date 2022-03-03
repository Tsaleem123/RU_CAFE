package com.example.myapplication;

/**
 * The classes implementing Customizable interface, such as StoreOrders, Coffee, and Order
 * promise to provide the add() and remove() behaviors.
 * @author Muhammad Saleem, Jessie Choucrallah
 */

public interface Customizable
{
    /**
     * adds the add-ins for coffee class, adds the menu items for order class, adds the orders for StoreOrders
     * @param obj
     * @return boolean
     */
    boolean add(Object obj);
    /**
     * removes the add-ins for coffee class, removes the menu items for order class, removes the orders for StoreOrders
     * @param obj
     * @return boolean
     */
    boolean remove(Object obj);
}