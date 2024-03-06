package com.example.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // gắn Layout tương ứng với file này
        setContentView(R.layout.activity_main);
    }

    // Đây là bộ lắng nghe và xử lý sự kiện nút tính Tổng
    public void xuLyCong(View view)
    {
        // Tìm, tham chiếu đến điều khiển trên tệm XML
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKq = findViewById(R.id.edtKq);

        // Lấy dữ kiệu về ở điều khiển số a và điều khiên số b
        try {
            double a = Double.parseDouble(editTextSoA.getText().toString());
            double b = Double.parseDouble(editTextSoB.getText().toString());
            //Tính tổng
            double tong = a + b;

            // Hiện ra màn hình
            editTextKq.setText(String.valueOf(tong));
        } catch (NumberFormatException e) {
            // Xử lý lỗi ở đây, ví dụ: hiển thị thông báo cho người dùng
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }



    }
}