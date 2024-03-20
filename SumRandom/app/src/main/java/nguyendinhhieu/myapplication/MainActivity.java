package nguyendinhhieu.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et_so1;
    EditText et_so2;
    EditText et_kq;
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
        getControls();
    }

    public void getControls(){
        et_so1 = (EditText) findViewById(R.id.et_so1);
        et_so2 = (EditText) findViewById(R.id.et_so2);
        et_kq = (EditText) findViewById(R.id.et_kq);
    }

    public void cong(View v){
        double so1 = Double.parseDouble(et_so1.getText().toString());
        double so2 = Double.parseDouble(et_so2.getText().toString());
        double kq = Math.floor(so1+so2);
        et_kq.setText(String.valueOf(kq));
    }
    public void tru(View v){
        double so1 = Double.parseDouble(et_so1.getText().toString());
        double so2 = Double.parseDouble(et_so2.getText().toString());
        double kq = Math.floor(so1-so2);
        et_kq.setText(String.valueOf(kq));
    }
    public void nhan(View v){
        double so1 = Double.parseDouble(et_so1.getText().toString());
        double so2 = Double.parseDouble(et_so2.getText().toString());
        double kq = Math.floor(so1*so2);
        et_kq.setText(String.valueOf(kq));
    }
    public void chia(View v){
        double so1 = Double.parseDouble(et_so1.getText().toString());
        double so2 = Double.parseDouble(et_so2.getText().toString());
        double kq = Math.floor((so1/so2)*100)/100;
        et_kq.setText(String.valueOf(kq));
    }
    public void random(View v){
        double rd1 = Math.random() * 10;
        double rd2 = Math.random() * 10;
        et_so1.setText(String.valueOf(Math.round(rd1)));
        et_so2.setText(String.valueOf(Math.round(rd2)));
    }
}