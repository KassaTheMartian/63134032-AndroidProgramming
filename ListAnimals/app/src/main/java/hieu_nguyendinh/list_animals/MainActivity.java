package hieu_nguyendinh.list_animals;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Animal> listAnimals;
    ListView lvAnimals;
    ImageView ivAnimal;
    TextView tvName;
    TextView tvDes;

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
        listAnimals = new ArrayList<>();
        listAnimals.add(new Animal("Dê","goat","Con vật có sừng ăn cỏ"));
        listAnimals.add(new Animal("Cừu","sheep","Con vật nhiều lông ăn cỏ"));
        listAnimals.add(new Animal("Hổ","tiger","Con vật có vằn ăn thịt"));
        listAnimals.add(new Animal("Mèo", "cat", "Con hổ nhưng mà bé hơn"));
        listAnimals.add(new Animal("Chó","dog","Con vật màu vàng ăn thịt"));


        MyAdapter adapter = new MyAdapter(listAnimals, this);
        lvAnimals.setAdapter(adapter);

        lvAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animal selectedAnimal = listAnimals.get(position);
                int imageResource = getResources().getIdentifier(selectedAnimal.getImage(), "drawable", getPackageName());
                ivAnimal.setImageResource(imageResource);
                tvDes.setText(listAnimals.get(position).getDescription());
                tvName.setText(listAnimals.get(position).getName());
            }
        });

    }

    public void getControls(){
        lvAnimals = findViewById(R.id.lv_animal);
        ivAnimal = findViewById(R.id.iv_animal);
        tvName = findViewById(R.id.tv_name);
        tvDes = findViewById(R.id.tv_description);

    }
}