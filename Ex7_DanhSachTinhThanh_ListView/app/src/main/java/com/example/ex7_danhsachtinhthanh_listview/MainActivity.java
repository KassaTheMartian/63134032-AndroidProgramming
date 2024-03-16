package com.example.ex7_danhsachtinhthanh_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // Tại đây khai báo các biến toàn cục
    // ví dụ các biến tham chiếu đến các điều khiển
    EditText edtThongTin;
    EditText edtNhap;
    ListView lsvTen;
    // biên lưu danh sách tên
    ArrayList<String> dsTen;
    // Tạo Adapter
    ArrayAdapter<String> tenAdapter;



    void getControls(){
        edtThongTin = (EditText) findViewById(R.id.edtThongTin);
        lsvTen = (ListView) findViewById(R.id.lsvTen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls(); // Lấy tham chiếu
        // Tạo nguồn dữ liệu
        dsTen = new ArrayList<String>();
        dsTen.add("Ha Noi");
        dsTen.add("Sai Gon");
        dsTen.add("Khanh Hoa");
        dsTen.add("Dak Lak");
        dsTen.add("Phu Yen");
        dsTen.add("Quang Nam");
        dsTen.add("Can Tho");
        // Gắn nguồn dữ liệu
        tenAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsTen);
        lsvTen.setAdapter(tenAdapter);
        lsvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtThongTin.setText(dsTen.get(position));
                Toast.makeText(MainActivity.this, dsTen.get(position), Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void themPhanTu(View v){
        // Lấy dữ liệu từ điều khiển
        edtNhap = (EditText) findViewById(R.id.edtNhap);
        String tenNhap = edtNhap.getText().toString();
        // Thêm vào danh sách tên
        dsTen.add(tenNhap);
        // Yêu cầu adapter báo cho view đã có sự thay đổi
        tenAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Thêm phần tử thành công", Toast.LENGTH_SHORT).show();
    }

    public void xoaPhanTu(View v){
        edtNhap = (EditText) findViewById(R.id.edtNhap);
        String tenNhap = edtNhap.getText().toString();

        if (dsTen.contains(tenNhap)) {
            dsTen.remove(tenNhap);
            tenAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã xóa " + tenNhap, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Không tồn tại " + tenNhap, Toast.LENGTH_SHORT).show();

        }

    }
}
