package com.example.thethaoplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyBookingAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MyBooking> arrayList;
    private int layout;

    public MyBookingAdapter(Context context, ArrayList<MyBooking> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        TextView tvDate, tvTime, tvStatus, tvLocation, tvNameField;
        ImageView imgAction;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder.tvDate = (TextView) convertView.findViewById(R.id.textViewDate);
            holder.tvTime = (TextView) convertView.findViewById(R.id.textViewTime);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.textViewStatus);
            holder.tvLocation = (TextView) convertView.findViewById(R.id.textViewLocation);
            holder.tvNameField = (TextView) convertView.findViewById(R.id.textViewNameField);
            holder.imgAction = (ImageView) convertView.findViewById(R.id.imageViewActionButton);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

            MyBooking myBooking = arrayList.get(position);
            holder.tvDate.setText(myBooking.getDate());
            holder.tvTime.setText(myBooking.getTime());
            holder.tvStatus.setText(myBooking.getStatus());
            holder.tvLocation.setText(myBooking.getLocation());
            holder.tvNameField.setText(myBooking.getNameField());

            holder.imgAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(context, holder.imgAction);
                    popupMenu.getMenuInflater().inflate(R.menu.action_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.actionAccept:
                                    Toast.makeText(context, "Accept!", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.actionCancel:
                                    Toast.makeText(context, "Cancel!", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });
        }

        return convertView;
    }
}
