package com.example.ryanpark.tomato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Business_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business__main);
    }

    public void POSButton(View view){
        Intent intent = new Intent(this, POS.class);
        startActivity(intent);
    }
}
