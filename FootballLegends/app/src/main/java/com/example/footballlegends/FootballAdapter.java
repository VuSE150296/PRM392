package com.example.footballlegends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FootballAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<FootballLegends> legendsList;

    public FootballAdapter(Context context, int layout, List<FootballLegends> legendsList) {
        this.context = context;
        this.layout = layout;
        this.legendsList = legendsList;
    }

    @Override
    public int getCount() {
        return legendsList.size();
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
        ImageView imgAvatar, imgCountry;
        TextView tvName, tvDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);

            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.imageAvatar);
            holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
            holder.imgCountry = (ImageView) convertView.findViewById(R.id.imageCountry);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FootballLegends footballLegends = legendsList.get(position);

        holder.imgAvatar.setImageResource(footballLegends.getAvatar());
        holder.tvName.setText(footballLegends.getName());
        holder.tvDescription.setText(footballLegends.getDescription());
        holder.imgCountry.setImageResource(footballLegends.getCountry());

        return convertView;
    }
}
