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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
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
    private TextView tvScore;
    private TextView tvTime;

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
        newGame();
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
        if (btn.getText().toString().equals(String.valueOf(listQuiz.get(count).tinhChuoiPhepToan()))){
            countKq++;
            count++;
            setAns(listQuiz.get(count));
        }else {
            count++;
            setAns(listQuiz.get(count));
        }
    }

    public void mergeQuiz() {
        Collections.shuffle(listQuiz);
    }
    public void newGame(){
        mergeQuiz();
        count = 0;
        countKq = 0;
        tvScore.setText("Score\n" + (countKq));
        tvDe.setText(listQuiz.get(count).getChuoiPhepToan());
        setAns(listQuiz.get(count));
    }
    public void setAns(Quiz quiz){
        Random random = new Random();
        ArrayList<Double> options = new ArrayList<>();

        options.add(roundToTwoDecimalPlaces(quiz.tinhChuoiPhepToan()));
        options.add(roundToTwoDecimalPlaces(random.nextDouble() * 15));
        options.add(roundToTwoDecimalPlaces(random.nextDouble() * 15));
        options.add(roundToTwoDecimalPlaces(random.nextDouble() * 15));

        Collections.shuffle(options); // Trộn thứ tự các lựa chọn

        btnA.setText(String.valueOf(options.get(0)));
        btnB.setText(String.valueOf(options.get(1)));
        btnC.setText(String.valueOf(options.get(2)));
        btnD.setText(String.valueOf(options.get(3)));

        tvDe.setText(listQuiz.get(count).getChuoiPhepToan());

        tvScore.setText("Score\n" + (countKq));

    }

    public static double roundToTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(value));
    }



    public void getControls(){
        btnA = (Button) findViewById(R.id.bnt_a);
        btnB = (Button) findViewById(R.id.bnt_b);
        btnC = (Button) findViewById(R.id.bnt_c);
        btnD = (Button) findViewById(R.id.bnt_d);
        tvDe = (TextView) findViewById(R.id.tv_de);
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvTime = (TextView) findViewById(R.id.tv_time);

    }


}