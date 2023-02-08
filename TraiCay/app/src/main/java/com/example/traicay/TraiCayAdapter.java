package com.example.traicay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCayItem> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCayItem> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
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
        ImageView imgTraiCay;
        TextView tvNameTraiCay, tvDescriptionTraiCay;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imgTraiCay = (ImageView) convertView.findViewById(R.id.imageTraiCay);
            holder.tvNameTraiCay = (TextView) convertView.findViewById(R.id.textViewName);
            holder.tvDescriptionTraiCay = (TextView) convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TraiCayItem traiCayItem = traiCayList.get(position);
        holder.imgTraiCay.setImageResource(traiCayItem.getImgTraiCay());
        holder.tvNameTraiCay.setText(traiCayItem.getNameTraiCay());
        holder.tvDescriptionTraiCay.setText(traiCayItem.getDescriptionTraiCay());

        return convertView;
    }
}
