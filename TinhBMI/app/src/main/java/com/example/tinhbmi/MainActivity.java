package com.example.tinhbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public String des;
    public String gener = "Asia";

    private EditText edtChieuCao;
    private EditText edtCanNang;
    private TextView edtKetQua;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        timDieuKhien();


    }
    public void timDieuKhien(){
        edtChieuCao = (EditText) findViewById(R.id.edt_chieu_cao);
        edtCanNang = (EditText) findViewById(R.id.edt_can_nang);
        edtKetQua = (TextView) findViewById(R.id.edt_ket_qua);
        radioGroup = (RadioGroup) findViewById(R.id.radgrp);
    }
    public void tinhBMI(View v){

        try {
            double canNang = Double.parseDouble(edtCanNang.getText().toString());
            double chieuCao = Double.parseDouble(edtChieuCao.getText().toString())/100;
            double kQ =Math.round((canNang/(chieuCao*chieuCao))*10)/10;
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.rad_a) {
                        gener = "Asia";
                    }
                    if (checkedId == R.id.rad_au) {
                        gener = "Eroupe";
                    }
                }
            });
            if (gener.equals("Asia")){
                if (kQ < 18.5) des = "Gầy";
                else if (kQ < 23) des = "Bình thường";
                else if (kQ == 23) des = "Thừa cân";
                else if (kQ < 25) des = "Tiền béo phì";
                else if (kQ < 30) des = "Béo phì độ I";
                else if (kQ < 35) des = "Béo phì độ II";
                else if (kQ > 35) des = "Béo phì độ III";
            } else if (gener.equals("Eroupe")){
                if (kQ < 18.5) des = "Gầy";
                else if (kQ < 25) des = "Bình thường";
                else if (kQ == 25) des = "Thừa cân";
                else if (kQ < 30) des = "Tiền béo phì";
                else if (kQ < 35) des = "Béo phì độ I";
                else if (kQ < 40) des = "Béo phì độ II";
                else if (kQ > 40) des = "Béo phì độ III";
            } else des = "";
            edtKetQua.setText(kQ+"\n"+des);
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }


    }

}