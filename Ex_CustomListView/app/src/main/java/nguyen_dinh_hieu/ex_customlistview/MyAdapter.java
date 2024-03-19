package nguyen_dinh_hieu.ex_customlistview;

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
    private List<Country> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter(List<Country> listData, Context context) {
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
            convertView = layoutInflater.inflate(R.layout.item_layout, null);
            holder = new ViewHolder();
            holder.flagView = convertView.findViewById(R.id.image_flag);
            holder.countryNameView = convertView.findViewById(R.id.text_name);
            holder.populationView = convertView.findViewById(R.id.text_population);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Country country = this.listData.get(position);
        holder.countryNameView.setText(country.getCoutryName());
        holder.populationView.setText("Population: " + country.getPopulation());

        int imageId = this.getMipmapResIdByName(country.getFlagName());

        holder.flagView.setImageResource(imageId);

        return convertView;
    }

    private class ViewHolder {
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }
    //Find Image ID corresponding to the name of the image (in diractory mipmap).
    public int getMipmapResIdByName(String resName){
        String pkgName = context.getPackageName();
        // Return 0 if it not found
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomeListView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

}
