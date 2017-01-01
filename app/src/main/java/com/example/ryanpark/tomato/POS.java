package com.example.ryanpark.tomato;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class POS extends AppCompatActivity {
    boolean applyTax = false;
    boolean applyDiscount = false;
    float taxRate = 0;
    float discountRate = 0;

    TextView discountValue;
    TextView taxValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos);
        taxValue = (TextView)findViewById(R.id.taxRateDisp);
        discountValue = (TextView)findViewById(R.id.discRateDisp);
        // Pseudo : 기존 SQL 데이터 베이스에서 할인율, 세율등 설정 값 로드

        taxValue.setText(Float.toString(taxRate)); // 로드한 값 적용
        discountValue.setText(Float.toString(discountRate));
    }

    public void clickSetting(View view) {
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_pos_setting, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this); //AlertDialog.Builder 객체 생성
        taxValue = (TextView)findViewById(R.id.taxRateDisp);
        discountValue = (TextView)findViewById(R.id.discRateDisp);

        builder.setTitle("Pos Settings"); //Dialog 제목
        builder.setIcon(android.R.drawable.ic_menu_add); //제목옆의 아이콘 이미지(원하는 이미지 설정)
        builder.setView(dialogView); //위에서 inflater가 만든 dialogView 객체 세팅 (Customize)
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            //Dialog에 "Save"라는 타이틀의 버튼을 설정
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //멤버 정보의 입력을 완료하고 TextView에 추가 하도록 하는 작업 수행
                //dialogView 객체 안에서 NAME을 입력받는 EditText 객체 찾아오기(주의: dialaogView에서 find 해야함)
                EditText discountValue = (EditText) dialogView.findViewById(R.id.editDiscountValue);
                EditText taxValue = (EditText) dialogView.findViewById(R.id.editTaxValue);
                //dialogView 객체 안에서 NATION을 입력받는 RadioGroup 객체 찾아오기
                CheckBox checkTax = (CheckBox) dialogView.findViewById(R.id.checkTax);
                CheckBox checkDiscount = (CheckBox) dialogView.findViewById(R.id.checkDiscount);

                //EditText에 입력된 이름 얻어오기
                taxRate = Float.valueOf(taxValue.getText().toString());
                discountRate = Float.valueOf(discountValue.getText().toString());
                //선택된 RadioButton의 ID를 RadioGroup에게 얻어오기
                applyTax = checkTax.isChecked();
                applyDiscount = checkDiscount.isChecked();

                taxValue.setText(Float.toString(taxRate));
                discountValue.setText(Float.toString(discountRate));

                Toast.makeText(POS.this, "Settings are saved.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            //Dialog에 "Cancel"이라는 타이틀의 버튼을 설정
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //멤버 정보의 입력을 취소하고 Dialog를 종료하는 작업
                //취소하였기에 특별한 작업은 없고 '취소'했다는 메세지만 Toast로 출력
                Toast.makeText(POS.this, "Settings are not saved.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog settingDialog = builder.create();

        settingDialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정

        //Dialog 보이기
        settingDialog.show();

    }//mOnClickMethod
}
