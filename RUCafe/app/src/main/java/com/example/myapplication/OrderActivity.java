package com.example.myapplication;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
/**
 * Handles the order page in the app.
 * @author Muhammad Saleem, Jessie Choucrallah
 */
public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private TextView subTotal;
    private TextView salesTax;
    private TextView total;
    private DecimalFormat df = new DecimalFormat("0.00");
    ArrayAdapter<MenuItem> list;

    /**
     * Helper method to display the current price.
     */
    public void textHelper(){
        double price = MainActivity.order.getTotalPrice();
        double salesTaxAmount = price*MagicNumbers.salesTax;
        subTotal.setText("$ " + df.format(price));
        salesTax.setText("S " + df.format(salesTaxAmount));
        total.setText("S " + df.format(price + salesTaxAmount));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("Orders");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        subTotal = findViewById(R.id.subTotal);
        salesTax = findViewById(R.id.salesTax);
        total = findViewById(R.id.total);
        listView = findViewById(R.id.listView);
        list = new ArrayAdapter<MenuItem>(this, android.R.layout.simple_list_item_1, MainActivity.order.getListItems());
        listView.setOnItemClickListener(this);
        listView.setAdapter(list);
        textHelper();

    }


    /**
     * Method to remove item from List view.
     * @param parent View for adapter.
     * @param view Order view.
     * @param position Position on click.
     * @param id ID for tem.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Would you like to remove " + list.getItem(position).toString() + "?").setTitle("Remove Item?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(OrderActivity.this,list.getItem(position).toString() + " removed.", Toast.LENGTH_SHORT).show();
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

    /**
     * Method to store the order.
     * @param view Order view.
     */
    public  void storeOrderClick(View view)
    {
        if(MainActivity.order.getListItems().size()== 0)
        {
            Toast.makeText(OrderActivity.this,"Can't store empty order.", Toast.LENGTH_SHORT).show();
            return;

        }
        MainActivity.storeOrders.add(MainActivity.order);
        MainActivity.orderReset();
        textHelper();
        listView.setAdapter(null);
        Toast.makeText(OrderActivity.this,"Order Stored.", Toast.LENGTH_SHORT).show();


    }


}