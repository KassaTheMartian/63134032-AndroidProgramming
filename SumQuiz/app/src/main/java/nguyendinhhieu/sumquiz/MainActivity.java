package nguyendinhhieu.sumquiz;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> listNum1;
    ArrayList<Integer> listNum2;
    int countKq=0;
    int count=0;
    EditText etNum1;
    EditText etNum2;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnGen;
    TextView tvAns;
    TextView tvCount;

    Random random = new Random();

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
        generationAns();
    }
    public void getControls(){
        etNum1 = (EditText) findViewById(R.id.et_num1);
        etNum2 = (EditText) findViewById(R.id.et_num2);
        btnA = (Button) findViewById(R.id.bnt_a);
        btnB = (Button) findViewById(R.id.bnt_b);
        btnC = (Button) findViewById(R.id.bnt_c);
        btnD = (Button) findViewById(R.id.bnt_d);
        btnGen = (Button) findViewById(R.id.bnt_gen);
        tvAns = (TextView) findViewById(R.id.tv_kq);
        tvCount = (TextView) findViewById(R.id.tv_count);
    }

    public void gen(View v){
        generationAns();
    }
    public void a(View v){
        if (count <=9 && Integer.parseInt(String.valueOf(btnA.getText())) == listNum1.get(count) + listNum2.get(count)){
            countKq++;
            tvAns.setText(countKq + "/10");
        }
        count++;
        if(count == 10){
            Toast.makeText(this, "Bạn làm đúng: " + countKq +"/10 Câu", Toast.LENGTH_SHORT).show();
            generationAns();
        }
        mergeAns(listNum1.get(count) + listNum2.get(count));
        setNum(listNum1.get(count), listNum2.get(count));
        tvCount.setText("Câu số: "+ (count + 1) );
    }
    public void b(View v){
        if (count <=9 && Integer.parseInt(String.valueOf(btnB.getText())) == listNum1.get(count) + listNum2.get(count)){
            countKq++;
            tvAns.setText(countKq + "/10");
        }
        count++;
        if(count == 10){
            Toast.makeText(this, "Bạn làm đúng: " + countKq +"/10 Câu", Toast.LENGTH_SHORT).show();
            generationAns();
        }
        mergeAns(listNum1.get(count) + listNum2.get(count));
        setNum(listNum1.get(count), listNum2.get(count));
        tvCount.setText("Câu số: "+ (count + 1) );

    }
    public void c(View v){
        if (count <=9 && Integer.parseInt(String.valueOf(btnC.getText())) == listNum1.get(count) + listNum2.get(count)){
            countKq++;
            tvAns.setText(countKq + "/10");
        }
        count++;
        if(count == 10){
            Toast.makeText(this, "Bạn làm đúng: " + countKq +"/10 Câu", Toast.LENGTH_SHORT).show();
            generationAns();
        }
        mergeAns(listNum1.get(count) + listNum2.get(count));
        setNum(listNum1.get(count), listNum2.get(count));
        tvCount.setText("Câu số: "+ (count + 1) );

    }
    public void d(View v){
        if (count <=9 && Integer.parseInt(String.valueOf(btnD.getText())) == listNum1.get(count) + listNum2.get(count)){
            countKq++;
            tvAns.setText(countKq + "/10");
        }
        count++;
        if(count == 10){
            Toast.makeText(this, "Bạn làm đúng: " + countKq +"/10 Câu", Toast.LENGTH_SHORT).show();
            generationAns();
        }
        mergeAns(listNum1.get(count) + listNum2.get(count));
        setNum(listNum1.get(count), listNum2.get(count));
        tvCount.setText("Câu số: "+ (count + 1) );
    }
    public void  mergeAns(int ans){
        ArrayList<Integer> options = new ArrayList<>();
        options.add(ans); // Add the correct answer first

        while (options.size() < 4) {
            int randomOption = random.nextInt(40);
            if (!options.contains(randomOption)) {
                options.add(randomOption);
            }
        }

        Collections.shuffle(options); // Shuffle the options list

        btnA.setText(String.valueOf(options.get(0)));
        btnB.setText(String.valueOf(options.get(1)));
        btnC.setText(String.valueOf(options.get(2)));
        btnD.setText(String.valueOf(options.get(3)));
    }

    public void setNum(int a, int b){
        etNum1.setText(String.valueOf(a));
        etNum2.setText(String.valueOf(b));
    }
    public void generationAns(){
        listNum1 = new ArrayList<Integer>();
        listNum2 = new ArrayList<Integer>();
        count = 0;
        countKq = 0;
        for (int i = 0; i<10; i++){
            listNum1.add(random.nextInt(20));
            listNum2.add(random.nextInt(20));
        }
        setNum(listNum1.get(count), listNum2.get(count));
        mergeAns(listNum1.get(0) + listNum2.get(0));
        tvAns.setText(countKq + "/10");
        tvCount.setText("Câu số: "+ (count + 1) );
    }
}