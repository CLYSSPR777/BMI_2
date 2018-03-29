package com.example.cjcu.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        //float bmi_result = intent.getFloatExtra("EX_BMI", 0);

        Bundle bag = intent.getExtras();
        float w = bag.getFloat("WEIGHT",0);
        float h = bag.getFloat("HEIGHT",0);

        float bmi_result = w / (h*h);

        TextView result = findViewById(R.id.Result);
        result.setText(String.valueOf(bmi_result));
    }
}
