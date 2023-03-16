package com.example.sqlitedatabase;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CongViecAdapter extends BaseAdapter {
    private ArrayList<CongViec> congViecArrayList;
    private MainActivity context;
    private int layout;

    public CongViecAdapter(ArrayList<CongViec> congViecArrayList, MainActivity context, int layout) {
        this.congViecArrayList = congViecArrayList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return congViecArrayList.size();
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
        TextView tvName;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.imgEdit = (ImageView) convertView.findViewById(R.id.imageViewEdit);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imageViewDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CongViec congViec = congViecArrayList.get(position);
        holder.tvName.setText(congViec.getTenCV());

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogSua(congViec.getTenCV(),congViec.getIDCV());
//                Toast.makeText(context, "Sua", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoa(congViec.getTenCV(),congViec.getIDCV());
            }
        });

        return convertView;
    }

}
