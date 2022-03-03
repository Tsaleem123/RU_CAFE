package com.example.myapplication;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
/**
 * Handles the store orders page in the app.
 * @author Muhammad Saleem, Jessie Choucrallah
 */
public class StoreOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private TextView subTotal;
    private TextView salesTax;
    private TextView total;
    private DecimalFormat df = new DecimalFormat("0.00");
    ArrayAdapter<Order> list;

    /**
     * Helper method to get the current price.
     */
    public void textHelper()
    {
        double price = MainActivity.storeOrders.getFinalPrice();
        double salesTaxAmount = price*MagicNumbers.salesTax;
        subTotal.setText("$ " + df.format(price));
        salesTax.setText("S " + df.format(salesTaxAmount));
        total.setText("S " + df.format(price + salesTaxAmount));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("Store Orders");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);
        subTotal = findViewById(R.id.subTotal);
        salesTax = findViewById(R.id.salesTax);
        total = findViewById(R.id.total);
        listView = findViewById(R.id.listView);
        list = new ArrayAdapter<Order>(this, android.R.layout.simple_list_item_1, MainActivity.storeOrders.getOrderList());
        listView.setOnItemClickListener(this);
        listView.setAdapter(list);
        textHelper();

    }

    /**
     * Method to remove item from store order lists.
     * @param parent Adapter view.
     * @param view Store orders view.
     * @param position Position of item in list.
     * @param id Id of item.
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Would you like to remove " + list.getItem(position).toString() + "?").setTitle("Remove Order?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(StoreOrderActivity.this,list.getItem(position).toString() + " removed.", Toast.LENGTH_SHORT).show();
                MainActivity.order.remove(position);
                list.remove(list.getItem(position));
                textHelper();

            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {
                return;
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();



    }


}