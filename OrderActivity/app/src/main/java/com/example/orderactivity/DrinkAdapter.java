package com.example.orderactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DrinkItems> drinkList;

    public DrinkAdapter(Context context, int layout, List<DrinkItems> drinkList) {
        this.context = context;
        this.layout = layout;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() {
        return drinkList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imgDrink;
        TextView tvName, tvDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();

            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);

            holder.imgDrink = (ImageView) convertView.findViewById(R.id.imageItems);
            holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DrinkItems drinkItems = drinkList.get(position);

        holder.imgDrink.setImageResource(drinkItems.getDrinkImg());
        holder.tvName.setText(drinkItems.getDrinkName());
        holder.tvDescription.setText(drinkItems.getDrinkDescription());

        return convertView;
    }
}
