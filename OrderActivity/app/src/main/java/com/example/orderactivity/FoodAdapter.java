package com.example.orderactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<FoodItems> foodList;

    public FoodAdapter(Context context, int layout, List<FoodItems> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
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
        ImageView imgFood;
        TextView tvName, tvDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);

            holder.imgFood = (ImageView) convertView.findViewById(R.id.imageItems);
            holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FoodItems foodItems = foodList.get(position);

        holder.imgFood.setImageResource(foodItems.getFoodImg());
        holder.tvName.setText(foodItems.getFoodName());
        holder.tvDescription.setText(foodItems.getFoodDescription());

        return convertView;
    }
}
