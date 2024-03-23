package hieu_nguyendinh.list_animals;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_FILE_REQUEST_CODE = 1;
    ArrayList<Animal> listAnimals;
    ListView lvAnimals;
    ImageView ivAnimal;
    EditText etName;
    EditText etDes;
    TextView tvImagefile;

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
        listAnimals.add(new Animal("Dê","goat","Nguyễn Trần Việt Hoàng"));
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
                etDes.setText(listAnimals.get(position).getDescription());
                etName.setText(listAnimals.get(position).getName());
            }
        });

    }
    public void getControls(){
        lvAnimals = findViewById(R.id.lv_animal);
        ivAnimal = findViewById(R.id.iv_animal);
        etDes = findViewById(R.id.et_description);
        etName = findViewById(R.id.et_name);
        tvImagefile = findViewById(R.id.tv_selected_file);
    }

    public void selectFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            String imagePath = getImagePath(selectedImageUri);

            // Sao chép tệp ảnh vào thư mục lưu trữ
            copyImageToStorage(imagePath);

            // Hiển thị đường dẫn ảnh trong TextView
            tvImagefile.setText(imagePath);
        }
    }
    private String getImagePath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) {
            return uri.getPath();
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String path = cursor.getString(columnIndex);
            cursor.close();
            return path;
        }
    }

    private void copyImageToStorage(String imagePath) {
        File srcFile = new File(imagePath);
        File destFile = new File(getFilesDir(), "selected_image.jpg");

        try {
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}