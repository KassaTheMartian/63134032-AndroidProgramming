package hieu_nguyendinh.list_animals;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Animal> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter(List<Animal> listData, Context context) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.animal_layout, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image);
            holder.nameView = convertView.findViewById(R.id.text_name);
            holder.descriptionView = convertView.findViewById(R.id.text_description);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Animal animal = this.listData.get(position);
        holder.nameView.setText(animal.getName());
        holder.descriptionView.setText(animal.getDescription());

        int imageId = this.getResIdByName(animal.getImage());

        holder.imageView.setImageResource(imageId);

        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView nameView;
        TextView descriptionView;
    }
    //Find Image ID corresponding to the name of the image (in diractory mipmap).
    public int getResIdByName(String resName){
        String pkgName = context.getPackageName();
        // Return 0 if it not found
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("CustomeListView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

}