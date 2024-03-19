package nguyen_dinh_hieu.ex_customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> listCountry;

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
        listCountry = new ArrayList<>();
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("USA","usa",300000000));
        listCountry.add(new Country("Japan","jp",1300000000));
        listCountry.add(new Country("Thailand", "thail", 80000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));
        listCountry.add(new Country("Việt Nam","rsz_3flagvn",1000000000));

        ListView listView = findViewById(R.id.lv_country);
        MyAdapter adapter = new MyAdapter(listCountry, this);
        listView.setAdapter(adapter);
    }
}