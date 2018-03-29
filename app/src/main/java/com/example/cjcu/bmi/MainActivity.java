package com.example.cjcu.bmi;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private EditText ed_weight;
    private EditText ed_height;
    private Button btn_bmi;
    private Button btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViews();

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI說明")
                        .setMessage("BMI=體重（Kg）/身高^2（m）")
                        .setPositiveButton("ok", null)
                        .show();
            }
        });
    }

    private void FindViews() {
        ed_weight = findViewById(R.id.Ed_Weight);
        ed_height = findViewById(R.id.Ed_Height);

        btn_help = findViewById(R.id.Btn_Help);
    }

    public void BMI(View view) {
        float w = Float.parseFloat(ed_weight.getText().toString());
        float h = Float.parseFloat(ed_height.getText().toString());

        Bundle bag = new Bundle();
        bag.putFloat("WEIGHT",w);
        bag.putFloat("HEIGHT",h);

        //float bmi = w / (h*h);
        //Log.d("BMI", String.valueOf(bmi));
        //Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();

        //new AlertDialog.Builder(this)
                //.setMessage("BMI="+bmi)
                //.setTitle("BMI值")
                //.setPositiveButton("Cancel", null)
                //.show();

        Intent intent = new Intent(this, ResultActivity.class);
        //intent.putExtra("EX_BMI", 0);
        intent.putExtras(bag);
        startActivity(intent);
    }
}
