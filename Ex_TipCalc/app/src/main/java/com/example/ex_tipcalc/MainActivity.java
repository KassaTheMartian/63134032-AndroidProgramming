package com.example.ex_tipcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    double kQ;
    EditText etInput;
    RadioGroup rgTip;
    RadioButton rbTip;
    TextView tvTip;

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

    public void timDieuKhien()
    {
        etInput = (EditText) findViewById(R.id.et_input);
        rgTip = (RadioGroup) findViewById(R.id.rg_tip);
        tvTip = (TextView) findViewById(R.id.tv_tip);
    }

    public void tinhTienTip(View v)
    {
        rbTip = (RadioButton) findViewById(rgTip.getCheckedRadioButtonId());
        String tip = rbTip.getText().toString();
        double input = Double.parseDouble(etInput.getText().toString());
        if (tip.equals("18%"))
            kQ = Math.floor(input * 0.18 * 100)/100;
        else if (tip.equals("13%"))
            kQ = Math.floor(input * 0.13 * 100)/100;
        else if (tip.equals("15%"))
            kQ = Math.floor(input * 0.15 * 100)/100;
        Toast.makeText(this, "You tip will be " + kQ, Toast.LENGTH_SHORT).show();
        tvTip.setText("You tip will be " + kQ);
    }
}