package com.example.thethaoplusadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FieldAddressAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FieldAddress> fieldAddressArrayList;
    private int layout;

    public FieldAddressAdapter(Context context, ArrayList<FieldAddress> fieldAddressArrayList, int layout) {
        this.context = context;
        this.fieldAddressArrayList = fieldAddressArrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return fieldAddressArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView tvName, tvAddress, tvStar, tvAvailable;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder.tvName=(TextView) convertView.findViewById(R.id.textViewName);
            holder.tvAddress=(TextView) convertView.findViewById(R.id.textViewAddress);
            holder.tvStar=(TextView) convertView.findViewById(R.id.textViewStar);
            holder.tvAvailable=(TextView) convertView.findViewById(R.id.textViewAvailable);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();

            FieldAddress fieldAddress=fieldAddressArrayList.get(position);
            holder.tvName.setText(fieldAddress.getName());
            holder.tvAddress.setText(fieldAddress.getAddress());
            holder.tvStar.setText(fieldAddress.getStar());
            holder.tvAvailable.setText(fieldAddress.getAvailable());
        }

        return convertView;
    }
}
