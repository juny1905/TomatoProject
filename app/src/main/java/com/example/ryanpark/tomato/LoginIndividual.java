package com.example.ryanpark.tomato;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginIndividual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_individual);
    }

    public void onClick(View v){
        EditText box1 = (EditText)findViewById(R.id.editText);
        EditText box2 = (EditText)findViewById(R.id.editText2);

        AlertDialog.Builder alert = new AlertDialog.Builder(LoginIndividual.this);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(LoginIndividual.this, Individual_Main.class);
                startActivity(intent);
                dialog.dismiss();     //닫기
                finish();
            }
        });

        String getID = box1.getText().toString();
        String getPW = box2.getText().toString();
        alert.setMessage("(미구현)아이디/패스워드를 서버의 데이터베이스와 대조\n\n" + "입력 ID : " + getID + "\n입력 PW : " + getPW);
        alert.show();




    }
}
