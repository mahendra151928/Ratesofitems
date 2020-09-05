package com.example.ratesofitems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity  {
EditText eprice;
Spinner espinner;
TextView eamount;
Button ebtn;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            eprice=findViewById(R.id.price);
            espinner=findViewById(R.id.spinner);
            eamount=findViewById(R.id.amount);
            ebtn=findViewById(R.id.btn);


            ArrayList<Integer>arrayList=new ArrayList<>();
            for (int i=1;i<=10;i++){
                arrayList.add(i);
            }

            ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.activity_list_item,arrayList);
            espinner.setAdapter(arrayAdapter);

        espinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String qualityvalue=adapterView.getItemAtPosition(i).toString();
                Integer qtyvalue=Integer.parseInt(qualityvalue);
                String value=eprice.getText().toString();
                Integer priceval=Integer.parseInt(value);
                Integer mul=priceval*qtyvalue;
                eamount.setText(Integer.toString(mul));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }
        }