package com.example.shashwatgupta.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity=0;
    int quantity2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity>0)
            quantity--;
        displayQuantity(quantity);
    }

    public void increment2(View view) {
        quantity2++;
        display2(quantity2);
    }

    public void decrement2(View view) {
        if(quantity2>0)
            quantity2--;
        display2(quantity2);
    }

    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name=nameField.getText().toString();
        int final_quantity=((quantity*15)+(quantity2*10));
        CheckBox whippedCreamCheckbox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        if(whippedCreamCheckbox.isChecked())
            {
                final_quantity+=(quantity+quantity2)*5;
            }
        CheckBox chocolateCheckbox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        if(chocolateCheckbox.isChecked())
            {
                final_quantity+=(quantity+quantity2)*5;
            }
        String priceMessage="Total: Rs. "+final_quantity;
        displayMessage(priceMessage);
        displayName(name);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.order_text_view);
        quantityTextView.setText("" + number);
        displayCoffee("Tea : "+number);
    }

    private void display2(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.order_text_view2);
        quantityTextView.setText("" + number);
        displayTea("Coffee : "+number);
    }

    private void displayTea(String message) {
        TextView teaTextView = (TextView) findViewById(R.id.tea_text_view);
        teaTextView.setText(message);
    }

    private void displayCoffee(String message) {
        TextView coffeeTextView = (TextView) findViewById(R.id.coffee_text_view);
        coffeeTextView.setText(message);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void displayName(String message) {
        TextView nameTextView = (TextView) findViewById(R.id.name_text_view);
        nameTextView.setText("Thank You "+message+"!");
    }
}