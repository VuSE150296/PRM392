package com.example.se150296_pe2023.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se150296_pe2023.MainActivity;
import com.example.se150296_pe2023.R;
import com.example.se150296_pe2023.activity.EditActivity;
import com.example.se150296_pe2023.models.Nhanvien;

import java.util.ArrayList;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Nhanvien> nhanvienArrayList;
    private MainActivity mainActivity;

    public NhanVienAdapter(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public NhanVienAdapter(Context context) {
        this.context = context;
    }


    public ArrayList<Nhanvien> getNhanvienArrayList() {
        return nhanvienArrayList;
    }

    public void setNhanvienArrayList(ArrayList<Nhanvien> nhanvienArrayList) {
        this.nhanvienArrayList = nhanvienArrayList;
        notifyDataSetChanged();
    }

    public NhanVienAdapter(ArrayList<Nhanvien> nhanvienArrayList) {
        this.nhanvienArrayList = nhanvienArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Nhanvien nhanvien = nhanvienArrayList.get(position);

        holder.tvName.setText(nhanvien.getName());
        holder.tvDate.setText(nhanvien.getDate());
        holder.tvGender.setText(nhanvien.getGender());
        holder.tvSalary.setText(nhanvien.getSalary());

    }

    @Override
    public int getItemCount() {
        if (nhanvienArrayList != null) {
            return nhanvienArrayList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvGender, tvSalary;
        ImageView imgEdit, imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDate = (TextView) itemView.findViewById(R.id.textViewEmail);
            tvGender = (TextView) itemView.findViewById(R.id.textViewGender);
            tvSalary = (TextView) itemView.findViewById(R.id.textViewPhone);

            imgEdit = (ImageView) itemView.findViewById(R.id.imageViewEdit);
            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, nhanvienArrayList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, EditActivity.class);
                    intent.putExtra("traineeID", nhanvienArrayList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                }
            });

            imgDelete = (ImageView) itemView.findViewById(R.id.imageViewDelete);
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long traineeID = nhanvienArrayList.get(getAdapterPosition()).getId();
                    String traineeName = nhanvienArrayList.get(getAdapterPosition()).getName();
//                    Toast.makeText(context, traineeName, Toast.LENGTH_SHORT).show();
                    mainActivity.delete(traineeID, traineeName);
                }
            });
        }
    }
}
