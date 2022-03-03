package com.example.myapplication;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Handles the main page for the app.
 * @author Muhammad Saleem, Jessie Choucrallah
 */
public class MainActivity extends AppCompatActivity
{
    public static Order order = new Order();
    public static StoreOrders storeOrders = new StoreOrders();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("RU Cafe");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts up the coffee page for ordering coffee.
     * @param view Main view.
     */
    public  void coffeeActivityClick(View view)
    {
        Intent intent = new Intent(this,CoffeeActivity.class);
        startActivity(intent);
    }
    /**
     * Starts up the order page for managing an order.
     * @param view Main view.
     */
    public  void orderActivityClick(View view)
    {
        Intent intent = new Intent(this,OrderActivity.class);
        startActivity(intent);

    }
    /**
     * Starts up the donut page for ordering donuts.
     * @param view Main view.
     */
    public  void donutActivityClick(View view)
    {
        Intent intent = new Intent(this,DonutOrderActivity.class);
        startActivity(intent);

    }
    /**
     * Starts up the store orders page for managing orders.
     * @param view Main view.
     */
    public  void storeOrdersActivityClick(View view)
    {
        Intent intent = new Intent(this,StoreOrderActivity.class);
        startActivity(intent);

    }

    /**
     * Method to reset an order once it's been stored.
     */
    public static void orderReset()
    {
        order = new Order();
    }




}