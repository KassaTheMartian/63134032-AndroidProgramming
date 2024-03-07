package com.example.ex6_addsubmuldiv_var;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextSoA;
    EditText editTextSoB;
    EditText editTextkq;
    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timDieuKhien();
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code xử lý cộng
                xuLyCong();
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTru();
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhan();
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChia();
            }
        });
    }

    void timDieuKhien(){
        editTextSoA = (EditText)findViewById(R.id.edtA);
        editTextSoB = (EditText)findViewById(R.id.edtB);
        editTextkq = (EditText)findViewById(R.id.edtKq);
        btnCong = (Button)findViewById(R.id.btnCong);
        btnTru = (Button)findViewById(R.id.btnTru);
        btnNhan = (Button)findViewById(R.id.btnNhan);
        btnChia = (Button)findViewById(R.id.btnChia);
    }
    public void xuLyCong()
    {
        try {
            double a = Double.parseDouble(editTextSoA.getText().toString());
            double b = Double.parseDouble(editTextSoB.getText().toString());

            editTextkq.setText(String.valueOf(a+b));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
    public void xuLyTru()
    {
        try {
            double a = Double.parseDouble(editTextSoA.getText().toString());
            double b = Double.parseDouble(editTextSoB.getText().toString());

            editTextkq.setText(String.valueOf(a-b));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
    public void xuLyNhan()
    {
        try {
            double a = Double.parseDouble(editTextSoA.getText().toString());
            double b = Double.parseDouble(editTextSoB.getText().toString());

            editTextkq.setText(String.valueOf(a*b));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
    public void xuLyChia()
    {
        try {
            double a = Double.parseDouble(editTextSoA.getText().toString());
            double b = Double.parseDouble(editTextSoB.getText().toString());
            if (b != 0)
                editTextkq.setText(String.valueOf(a/b));
            else
                editTextkq.setText("Vui lòng nhập số thứ hai khác 0");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}