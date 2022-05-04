package com.example.powertoolrental;

// Name: Chauntel Atchley Cully
// Project: Create a Mobile App that determines the cost of a power washer or tiller
//          Should display a logo on home and in App, once opened the app should request
//          number of days to rent the power tool. Selecting which tool to use by RadioButtons
//          And "print" the total cost once the Compute Cost button has been clicked on.
// Start Date: 2/23/2022

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting the Home and in-App Logo to photo of choice
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Setting the RadioButton, Button and EditText objects
        RadioButton powerWasher = (RadioButton)findViewById(R.id.radPowerWasher);
        RadioButton tillerWasher = (RadioButton)findViewById(R.id.radTillerWasher);
        EditText days = (EditText)findViewById(R.id.txtNumOfDays);
        Button compute = findViewById(R.id.btnComputeCost);
        // Setting up the compute(Button) onClickListener
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double powerWasherPrice = 55.99;
                double tillerWasherPrice = 68.99;
                double computedCost;
                TextView resultCost = findViewById( R.id.txtResultCost);            // Setting the txtResultCost as a TextView to Update/SetText
                DecimalFormat df = new DecimalFormat("$#.#");                // Setting the Decimal format to Currency and Decimal
                df.setMaximumFractionDigits(2);                                     // Set the Max Digits/Decimal places to be 2
                double daysEntered = Double.parseDouble(days.getText().toString()); // Parsing the days entered string to a double (int)

                // If the PowerWasher is selected check to see if the days entered
                // is less than or equal to 7, if so set the resultCost to the days
                // entered by the powerWasherPrice. If it is greater than set resultCost
                // to else. If it is less than or equal to 0 set resultCost to last if.
                if (powerWasher.isChecked())
                {
                    if(daysEntered <= 7) {
                        computedCost = daysEntered * powerWasherPrice;
                        resultCost.setText("Total Rental Cost is " + df.format(computedCost));
                    }else {
                        resultCost.setText("Cannot rent longer than 7 days. Please re-submit.");
                    }
                    if(daysEntered <= 0){
                        resultCost.setText("Please choose between 1 to 7 days.");
                    }
                }
                // If the PowerWasher is selected check to see if the days entered
                // is less than or equal to 7, if so set the resultCost to the days
                // entered times the powerWasherPrice. If it is greater than 7 set resultCost
                // to the else. If it is less than or equal to 0 set resultCost to last if.
                if (tillerWasher.isChecked())
                {
                    if(daysEntered <= 7){
                        computedCost = daysEntered * tillerWasherPrice;
                        resultCost.setText("Total Rental Cost is " + df.format(computedCost));
                    }else {
                        resultCost.setText("Cannot rent longer than 7 days. Please re-submit");
                    }
                    if(daysEntered <= 0){
                        resultCost.setText("Please choose between 1 to 7 days.");
                    }
                }
//                 Not sure why this wouldn't run properly it was only taking into
//                 consideration the second if statement even if the first one was checked
//                 But I think it was because each portion was not in their own statement
//                if (powerWasher.isChecked() || (daysEntered <= 7))
//                {
//                    computedCost = daysEntered * powerWasherPrice;
//                    resultCost.setText("Total Rental Cost is " + df.format(computedCost));
//                } else
//                {
//                    resultCost.setText("Cannot rent longer than 7 days. Please re-submit");
//                }
//                if (tillerWasher.isChecked() || (daysEntered <= 7))
//                {
//                    computedCost = daysEntered * tillerWasherPrice;
//                    resultCost.setText("Total Rental Cost is " + df.format(computedCost));
//                } else
//                {
//                    resultCost.setText("Cannot rent longer than 7 days. Please re-submit");
//                }
            }
        });
    }
}