package com.example.myapplication;


import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

/**
 * This class allows the user to order a coffee with various quantities and a running subtotal.
 * @author Muhammad Saleem, Jessie Choucrallah
 */

public class CoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private CheckBox cream;
    private CheckBox milk;
    private CheckBox syrup;
    private CheckBox caramel;
    private CheckBox whippedcream;
    private Button orderButton;
    private TextView txt;
    private Spinner size;
    private Spinner quantity;
    private Coffee coffee = new Coffee();
    private DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Helper method used to calculate payment and
     * append payment to the text view.
     */
    public void checkHelper()
    {
        coffee.itemPrice();
        txt.setText(" $" + df.format(coffee.getPrice()));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Coffee");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        cream = findViewById(R.id.cream);
        caramel = findViewById(R.id.caramel);
        milk = findViewById(R.id.milk);
        whippedcream = findViewById(R.id.whippedcream);
        syrup = findViewById(R.id.syrup);
        orderButton = findViewById(R.id.orderButton);
        txt = findViewById(R.id.txt);

        size = findViewById(R.id.size);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(adapter);
        size.setOnItemSelectedListener(this);

        quantity = findViewById(R.id.quantity);
        ArrayAdapter<CharSequence> quantityAdapter = ArrayAdapter.createFromResource(this, R.array.quantity, android.R.layout.simple_spinner_item);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantity.setAdapter(quantityAdapter);
        quantity.setOnItemSelectedListener(this);

        coffee.itemPrice();
        txt.setText(" $" + df.format(coffee.getPrice()));
    }

    /**
     *this method stores the donut order and displays a toast text to confirm.
     * @param view invokes action when add to order button is clicked
     */
    public  void storeOrder(View view)
    {
        Toast.makeText(CoffeeActivity.this,"Coffee Stored", Toast.LENGTH_SHORT).show();
        MainActivity.order.add(coffee);

    }
    /**
     * Determines action for milk check box.
     * @param view invokes action when the Milk check box is clicked.
     */

    public  void milkClick(View view)
    {
        if (milk.isChecked())
        {
            coffee.add("MILK");
            coffee.addInIncrease();
            checkHelper();
        }
        else
        {
            coffee.remove("MILK");
            coffee.addInDecrease();
            checkHelper();
        }
    }

    /**
     * Determines action for syrup check box.
     * @param view invokes action when the syrup check box is clicked.
     */

    public  void syrupClick(View view)
    {
        if (syrup.isChecked())
        {
            coffee.add("SYRUP");
            coffee.addInIncrease();
            checkHelper();
        }
        else
        {
            coffee.remove("SYRUP");
            coffee.addInDecrease();
            checkHelper();
        }
    }

    /**
     * Determines action for caramel check box.
     * @param view invokes action when caramel check box is clicked.
     */
    public  void caramelClick(View view)
    {
        if (caramel.isChecked())
        {
            coffee.add("CARAMEL");
            coffee.addInIncrease();
            checkHelper();
        }
        else
        {
            coffee.remove("CARAMEL");
            coffee.addInDecrease();
            checkHelper();
        }
    }
    /**
     * Determines action for cream check box.
     * @param view invokes action when cream check box is clicked.
     */
    public  void creamClick(View view)
    {
        if (cream.isChecked())
        {
            coffee.add("CREAM");
            coffee.addInIncrease();
            checkHelper();
        }
        else
        {
            coffee.remove("CREAM");
            coffee.addInDecrease();
            checkHelper();
        }
    }
    /**
     * Determines action for whipped cream check box.
     * @param view invokes action when whipped cream check box is clicked.
     */
    public  void whippedcreamClick(View view)
    {
        if (whippedcream.isChecked())
        {
            coffee.add("WHIPPEDCREAM");
            coffee.addInIncrease();
            checkHelper();
        }
        else
        {
            coffee.remove("WHIPPEDCREAM");
            coffee.addInDecrease();
            checkHelper();
        }
    }
    /**
     * this method sets the size and base count for each size of coffee the user selects,
     * and then sets the quantity based on the amount of coffees the user selected.
     * @param parent adapter view in the DonutActivity class
     * @param view invokes action when quantity is selected
     * @param position position of the view in the adapter
     * @param id the row of the item that's selected
     */

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String choice = parent.getItemAtPosition(position).toString();
        switch(choice)
        {
            case "Short":
                coffee.setSize("Short");
                coffee.setBaseCount(MagicNumbers.SHORT_COUNT);
                break;
            case "Tall":
                coffee.setSize("Tall");
                coffee.setBaseCount(MagicNumbers.TALL_COUNT);
                break;
            case "Grande":
                coffee.setSize("Grande");
                coffee.setBaseCount(MagicNumbers.GRANDE_COUNT);
                break;
            case "Venti":
                coffee.setSize("Venti");
                coffee.setBaseCount(MagicNumbers.VENTI_COUNT);
                break;
            default:
                break;

        }
        switch(choice)
        {
            case "Short":
                coffee.setSize("Short");
                coffee.setBaseCount(MagicNumbers.SHORT_COUNT);
                break;
            case "Tall":
                coffee.setSize("Tall");
                coffee.setBaseCount(MagicNumbers.TALL_COUNT);
                break;
            case "Grande":
                coffee.setSize("Grande");
                coffee.setBaseCount(MagicNumbers.GRANDE_COUNT);
                break;
            case "Venti":
                coffee.setSize("Venti");
                coffee.setBaseCount(MagicNumbers.VENTI_COUNT);
                break;
            case "1":
                this.coffee.setQuantity(MagicNumbers.QUANTITY_1);
                break;

            case "2":
                this.coffee.setQuantity(MagicNumbers.QUANTITY_2);
                break;
            case "3":
                this.coffee.setQuantity(MagicNumbers.QUANTITY_3);
                break;

            case "4":
                this.coffee.setQuantity(MagicNumbers.QUANTITY_4);
                break;

            case "5":
                this.coffee.setQuantity(MagicNumbers.QUANTITY_5);
                break;

            default:
                break;

        }
        checkHelper();

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
}
