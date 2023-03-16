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
import com.example.se150296_pe2023.activity.EditPhongBan;
import com.example.se150296_pe2023.activity.PhongBanActivity;
import com.example.se150296_pe2023.models.Nhanvien;
import com.example.se150296_pe2023.models.Phongban;

import java.util.ArrayList;

public class PhongBanAdapter extends RecyclerView.Adapter<PhongBanAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Phongban> phongbanArrayList;
    private PhongBanActivity phongBanActivity;

    public PhongBanAdapter(Context context, ArrayList<Phongban> phongbanArrayList) {
        this.context = context;
        this.phongbanArrayList = phongbanArrayList;
    }

    public PhongBanAdapter(ArrayList<Phongban> phongbanArrayList) {
        this.phongbanArrayList = phongbanArrayList;
    }

    public ArrayList<Phongban> getPhongbanArrayList() {
        return phongbanArrayList;
    }

    public void setPhongbanArrayList(ArrayList<Phongban> phongbanArrayList) {
        this.phongbanArrayList = phongbanArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item, parent, false);
        PhongBanAdapter.ViewHolder viewHolder = new PhongBanAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Phongban phongban=phongbanArrayList.get(position);

        holder.tvName.setText(phongban.getNamePB());

    }

    @Override
    public int getItemCount() {
        if (phongbanArrayList != null) {
            return phongbanArrayList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgEdit, imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.textViewName);

            imgEdit = (ImageView) itemView.findViewById(R.id.imageViewEdit);
            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EditPhongBan.class);
                    intent.putExtra("phongbanID", phongbanArrayList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                }
            });

            imgDelete = (ImageView) itemView.findViewById(R.id.imageViewDelete);
//            imgDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    long traineeID = nhanvienArrayList.get(getAdapterPosition()).getId();
//                    String traineeName = nhanvienArrayList.get(getAdapterPosition()).getName();
////                    Toast.makeText(context, traineeName, Toast.LENGTH_SHORT).show();
//                    mainActivity.delete(traineeID, traineeName);
//                }
//            });
        }
    }
}
