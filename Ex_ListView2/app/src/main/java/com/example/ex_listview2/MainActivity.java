package com.example.ex_listview2;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etIndex;
    EditText etValue;
    ListView lvItem;

    ArrayList<String> dsItem;
    ArrayAdapter<String> adapterItem;
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

        dsItem = new ArrayList<String>();
        dsItem.add("Item 1");
        dsItem.add("Item 2");
        dsItem.add("Item 3");
        dsItem.add("Item 4");
        dsItem.add("Item 5");
        dsItem.add("Item 6");
        dsItem.add("Item 7");

        adapterItem = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsItem);
        lvItem.setAdapter(adapterItem);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                etIndex.setText(String.valueOf(position));
                etValue.setText(dsItem.get(position));
            }
        });
    }
    void getControls(){
        etIndex = (EditText) findViewById(R.id.et_index);
        etValue = (EditText) findViewById(R.id.et_value);
        lvItem = (ListView) findViewById(R.id.lv_item);
    }

    public void luuThem(View v){
        String item = etValue.getText().toString();
        dsItem.add(item);
        adapterItem.notifyDataSetChanged();
    }

    public void luuSua(View v){
        String item = etValue.getText().toString();
        int index =  Integer.parseInt(etIndex.getText().toString());
        dsItem.set(index,item);
        adapterItem.notifyDataSetChanged();
    }

    public void luuXoa(View v){
        int index =  Integer.parseInt(etIndex.getText().toString());
        dsItem.remove(index);
        adapterItem.notifyDataSetChanged();
    }


}