package com.example.ryanpark.tomato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class selectType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
    }

    public void individual_onClick(View v){
        Intent intent = new Intent(this, LoginIndividual.class);
        startActivity(intent);
        finish();
    }

    public void business_onClick(View v){
        Intent intent = new Intent(this, LoginBusiness.class);
        startActivity(intent);
        finish();
    }
}
