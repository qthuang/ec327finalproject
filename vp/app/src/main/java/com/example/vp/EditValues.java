package com.example.vp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditValues extends MainActivity {

    //initialize textview and buttons
    private EditText weight;
    private EditText height;
    private double weight_d;
    private double height_d;
    public static double bmi = 0;
    public static int state = 0;
    public static double should = 0;

    private Button finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_values);

        //implement
        weight = (EditText) findViewById(R.id.textInputEditText);
        height = (EditText) findViewById(R.id.textInputEditText2);

        weight_d = Double.parseDouble(weight.getText().toString());
        height_d = Double.parseDouble(height.getText().toString());

        bmi = weight_d / (height_d * height_d);

        if(bmi < 18.5)
            state = 1; // underweight
        else if(bmi >= 18.5 && bmi <= 24.9)
            state = 2; // normal
        else if(bmi >= 25 && bmi <= 29.9)
            state = 3; // overweight
        else if(bmi >= 30 && bmi <= 34.9)
            state = 4; // obese
        else if(bmi >=35)
            state = 5; // extremely obese


        should = 0;//needs calculation

        finished = (Button) findViewById(R.id.edit_return);//button in edit_values

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
