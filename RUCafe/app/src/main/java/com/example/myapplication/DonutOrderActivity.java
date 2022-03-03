package com.example.myapplication;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This class sets the flavors for each donut and takes the user
 * to the next screen so they can place the order for that flavor.
 * @author Muhammad Saleem, Jessie Choucrallah
 */

public class DonutOrderActivity extends AppCompatActivity {
    private Button glazed;
    private Button strawberry;
    private Button jelly;
    private Button bostonCream;
    private Button blueberry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Donuts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdonut);
        glazed = findViewById(R.id.glazed);
        strawberry = findViewById(R.id.strawberry);
        jelly = findViewById(R.id.jelly);
        bostonCream = findViewById(R.id.bostonCream);
        blueberry = findViewById(R.id.blueberry);


        strawberry.setOnClickListener(new View.OnClickListener() {
            /**
             * This method sets the on click listener for the strawberry button,
             * and takes the user to the ordering donuts screen where they can add the donut to their order.
             * @param view invokes action when strawberry button is clicked
             */
            public void onClick(View view) {
                Intent intent = new Intent(DonutOrderActivity.this, DonutActivity.class);
                String s = strawberry.getText().toString();
                intent.putExtra("text", s);
                startActivity(intent);
            }
        });
        glazed.setOnClickListener(new View.OnClickListener() {
            /**
             * this method sets the on click listener for the Glazed button,
             * and takes the user to the ordering donuts screen where they can add the donut to their order.
             * @param view invokes action when glazed button is clicked
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonutOrderActivity.this, DonutActivity.class);
                String s = glazed.getText().toString();
                intent.putExtra("text", s);
                startActivity(intent);
            }
        });
        jelly.setOnClickListener(new View.OnClickListener() {
            /**
             * this method sets the on click listener for the Jelly button,
             * and takes the user to the ordering donuts screen where they can add the donut to their order.
             * @param view invokes action when jelly button is clicked
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonutOrderActivity.this, DonutActivity.class);
                String s = jelly.getText().toString();
                intent.putExtra("text", s);
                startActivity(intent);
            }
        });
        blueberry.setOnClickListener(new View.OnClickListener() {
            /**
             *  this method sets the on click listener for the Blueberry button,
             * and takes the user to the ordering donuts screen where they can add the donut to their order.
             * @param view invokes action when blueberry button is clicked
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonutOrderActivity.this, DonutActivity.class);
                String s = blueberry.getText().toString();
                intent.putExtra("text", s);
                startActivity(intent);
            }
        });
        bostonCream.setOnClickListener(new View.OnClickListener() {
            /**
             *  this method sets the on click listener for the Boston Cream button,
             * and takes the user to the ordering donuts screen where they can add the donut to their order.
             * @param view invokes action when Boston Cream button is clicked
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonutOrderActivity.this, DonutActivity.class);
                String s = bostonCream.getText().toString();
                intent.putExtra("text", s);
                startActivity(intent);
            }
        });
    }

}