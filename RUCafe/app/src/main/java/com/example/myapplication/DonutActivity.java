package com.example.myapplication;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

/**
 * This class allows the user to add their donut to the order with quantity and running subtotal.
 * @author Muhammad Saleem, Jessie Choucrallah
 */

public class DonutActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView flavorTxt;
    private TextView subtotalTxt;
    private Spinner quantity;
    private String flavor;
    private Donut newDonut = new Donut();
    private DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Donut Ordering");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        flavorTxt = findViewById(R.id.flavorTxt);
        flavor = getIntent().getStringExtra("text");
        flavorTxt.setText(flavor);
        subtotalTxt = findViewById(R.id.subtotalTxt);

        quantity = findViewById(R.id.quantity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantity.setAdapter(adapter);
        quantity.setOnItemSelectedListener(this);

        newDonut.itemPrice();
        subtotalTxt.setText(" $" + df.format(newDonut.getPrice()));
        newDonut.setFlavor(flavor);
    }

    /**
     * this method is invoked when selection disappears
     * @param parent adapter view where the selection happened
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        ;

    }

    /**
     * this method sets the price for each quantity the user selects, and updates the price accordingly
     * @param parent adapter view in the DonutActivity class
     * @param view invokes action when quantity is selected
     * @param position position of the view in the adapter
     * @param id the row of the item that's selected
     */

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String choice = parent.getItemAtPosition(position).toString();
        switch(choice){
            case "1":
                this.newDonut.setCount(MagicNumbers.QUANTITY_1);
                break;

            case "2":
                this.newDonut.setCount(MagicNumbers.QUANTITY_2);
                break;
            case "3":
                this.newDonut.setCount(MagicNumbers.QUANTITY_3);
                break;

            case "4":
                this.newDonut.setCount(MagicNumbers.QUANTITY_4);
                break;

            case "5":
                this.newDonut.setCount(MagicNumbers.QUANTITY_5);
                break;
            default:
                break;
        }
        newDonut.itemPrice();
        subtotalTxt.setText(" $" + df.format(newDonut.getPrice()));
    }

    /**
     * this method stores the donut order and displays a toast text to confirm.
     * @param view invokes action when add to order button is clicked
     */
    public void storeOrder(View view)
    {
        Toast.makeText(DonutActivity.this,"Added to order", Toast.LENGTH_SHORT).show();
        MainActivity.order.add(newDonut);
        newDonut = new Donut();
        newDonut.itemPrice();
        newDonut.setFlavor(flavor);

    }

}
