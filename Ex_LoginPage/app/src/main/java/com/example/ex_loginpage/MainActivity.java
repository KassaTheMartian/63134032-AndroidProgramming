package com.example.ex_loginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String userName;
    String password;
    int attempts = 0;
    EditText etUserName;
    EditText etPassword;
    TextView tvAttempts;
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
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvAttempts = (TextView) findViewById(R.id.tv_attempts);
    }

    public void dangNhap(View v){
        userName = etUserName.getText().toString();
        password = etPassword.getText().toString();
        attempts ++;
        tvAttempts.setText("Attempts: " + attempts);
        if (userName.equals("maicuongtho") && password.equals("Cntt60ntu!"))
        {
            Toast.makeText(this, "User and Password is correct", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "User and Password is wrong", Toast.LENGTH_SHORT).show();

    }
}