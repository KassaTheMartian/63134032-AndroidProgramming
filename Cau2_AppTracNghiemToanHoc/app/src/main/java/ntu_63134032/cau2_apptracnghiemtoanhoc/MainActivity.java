package ntu_63134032.cau2_apptracnghiemtoanhoc;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Quiz> listQuiz = new ArrayList<Quiz>();
    private int count = 0;
    private int countKq = 0;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private TextView tvDe;

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

        listQuiz.add(new Quiz(3));
        listQuiz.add(new Quiz(3));
        listQuiz.add(new Quiz(3));
        listQuiz.add(new Quiz(3));
        listQuiz.add(new Quiz(3));
        listQuiz.add(new Quiz(3));

        tvDe.setText(listQuiz.get(count).getChuoiPhepToan());
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonDapAn(btnA);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonDapAn(btnB);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonDapAn(btnC);
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonDapAn(btnD);
            }
        });
    }

    public void chonDapAn(Button btn){
        Random random = new Random();
        if (btn.getText().toString().equals(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()))){
            countKq++;
            count++;
            btnA.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
            btnB.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
            btnC.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
            btnD.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
        }else {
            count++;
            btnA.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
            btnB.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
            btnC.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
            btnD.setText(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()));
        }
    }
    public void getControls(){
        btnA = (Button) findViewById(R.id.bnt_a);
        btnB = (Button) findViewById(R.id.bnt_b);
        btnC = (Button) findViewById(R.id.bnt_c);
        btnD = (Button) findViewById(R.id.bnt_d);
        tvDe = (TextView) findViewById(R.id.tv_de);
    }


}