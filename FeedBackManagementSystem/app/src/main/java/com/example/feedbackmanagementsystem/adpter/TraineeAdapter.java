package com.example.feedbackmanagementsystem.adpter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feedbackmanagementsystem.MainActivity;
import com.example.feedbackmanagementsystem.R;
import com.example.feedbackmanagementsystem.activity.AddActivity;
import com.example.feedbackmanagementsystem.activity.EditActivity;
import com.example.feedbackmanagementsystem.api.TraineeService;
import com.example.feedbackmanagementsystem.models.Trainee;

import java.util.ArrayList;

public class TraineeAdapter extends RecyclerView.Adapter<TraineeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Trainee> traineeArrayList;
    private MainActivity mainActivity;

    public TraineeAdapter(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public TraineeAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Trainee> getTraineeArrayList() {
        return traineeArrayList;
    }

    public void setTraineeArrayList(ArrayList<Trainee> traineeArrayList) {
        this.traineeArrayList = traineeArrayList;
        notifyDataSetChanged();
    }

    public TraineeAdapter(ArrayList<Trainee> traineeArrayList) {
        this.traineeArrayList = traineeArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.trainee_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Trainee trainee = traineeArrayList.get(position);

        holder.tvName.setText(trainee.getName());
        holder.tvEmail.setText(trainee.getEmail());
        holder.tvGender.setText(trainee.getGender());
        holder.tvPhone.setText(trainee.getPhone());

    }

    @Override
    public int getItemCount() {
        if (traineeArrayList != null) {
            return traineeArrayList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail, tvGender, tvPhone;
        ImageView imgEdit, imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
            tvGender = (TextView) itemView.findViewById(R.id.textViewGender);
            tvPhone = (TextView) itemView.findViewById(R.id.textViewPhone);

            imgEdit = (ImageView) itemView.findViewById(R.id.imageViewEdit);
            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, traineeArrayList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, EditActivity.class);
                    intent.putExtra("traineeID", traineeArrayList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                }
            });

            imgDelete = (ImageView) itemView.findViewById(R.id.imageViewDelete);
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long traineeID = traineeArrayList.get(getAdapterPosition()).getId();
                    String traineeName = traineeArrayList.get(getAdapterPosition()).getName();
//                    Toast.makeText(context, traineeName, Toast.LENGTH_SHORT).show();
                    mainActivity.delete(traineeID, traineeName);
                }
            });
        }
    }
}
