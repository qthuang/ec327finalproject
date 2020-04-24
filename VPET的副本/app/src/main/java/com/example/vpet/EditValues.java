package com.example.vpet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditValues extends AppCompatActivity {

    public double bmi = 0;
    public int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_values);

        //check if there is string?
        //

        EditText weight = (EditText) findViewById(R.id.textInputEditText);
        EditText height = (EditText) findViewById(R.id.textInputEditText2);

        double weight_d = Double.parseDouble(weight.getText().toString());
        double height_d = Double.parseDouble(height.getText().toString());

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

//needs calculation should

        Button finished = (Button) findViewById(R.id.edit_return);//button in edit_values

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
