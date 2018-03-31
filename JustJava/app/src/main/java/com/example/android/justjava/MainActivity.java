package com.example.android.justjava;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity= 2;

    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText customerName = (EditText) findViewById(R.id.name_edit_text);

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        String name = customerName.getText().toString();

        int price = calculatePrice(hasChocolate, hasWhippedCream);
        String orderMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "devansh233@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order by " + name);
        intent.putExtra(Intent.EXTRA_TEXT, orderMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view) {
        if(quantity < 50 )
            quantity++;
        else {
            CharSequence toastText = "You can't order more than 50 coffees !";
            Toast toast = Toast.makeText(this, toastText, duration);
            toast.show();
        }
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity>=2)
            quantity--;
        else {
            CharSequence toastText = "You can't order less than 1 coffee !";
            Toast toast = Toast.makeText(this, toastText, duration);
            toast.show();
        }
        display(quantity);
    }

    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream) {
        int basePrice = 10;
        //Add 4 rupees if the user wants chocolate
        if(hasChocolate) {
            basePrice += 4;
        }
        //Add 2 rupees if the user wants whipped cream
        if(hasWhippedCream) {
            basePrice += 2;
        }

        return quantity*basePrice;
    }

    /**
     * Displays the order summary on screen.
     * @param customerName Displays the name of the customer
     * @param addChocolate Determines if chocolate is present or not.
     * @param addWhippedCream Determines if whipped cream is present or not.
     * @param price The total price if coffee.
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String customerName) {
        String orderMessage = "Name: " + customerName;
        orderMessage += "\nQuantity : " + quantity;
        orderMessage += "\nHas Whipped Cream ? " + addWhippedCream;
        orderMessage += "\nHas Chocolate ? " + addChocolate;
        orderMessage += "\nTotal : ₹" + price;
        orderMessage += "\nThank you !";
        return  orderMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}