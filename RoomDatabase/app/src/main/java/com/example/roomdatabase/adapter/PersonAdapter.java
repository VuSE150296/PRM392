package com.example.roomdatabase.adapter;

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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.activities.EditPersonActivity;
import com.example.roomdatabase.activities.PersonActivity;
import com.example.roomdatabase.constants.Constants;
import com.example.roomdatabase.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private Context context;
    private List<Person> mPersonList;
    private AppDatabase mDb;

    public PersonAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_item,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mPersonList.get(position).getFirstName());
        viewHolder.email.setText(mPersonList.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        if (mPersonList == null) {
            return 0;
        }
        return mPersonList.size();
    }

    public void setTasks(List<Person> personList) {
        mPersonList = personList;
        notifyDataSetChanged();
    }

    public List<Person> getTasks() {
        return mPersonList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;
        ImageView editImage, imgDelete;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvFirstName);
            email = itemView.findViewById(R.id.tvLastName);

            editImage = itemView.findViewById(R.id.ivEdit);
            imgDelete = itemView.findViewById(R.id.ivDelete);
            editImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int elementId = mPersonList.get(getAdapterPosition()).getUid();
                    Intent i = new Intent(context, EditPersonActivity.class);
                    i.putExtra(Constants.UPDATE_Person_Id, elementId);
                    context.startActivity(i);
                }
            });

//            imgDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(context, mPersonList.get(getAdapterPosition()).getUid()+"", Toast.LENGTH_SHORT).show();
//
//                    String name = mPersonList.get(getAdapterPosition()).getFirstName() + mPersonList.get(getAdapterPosition()).getLastName();
//                    Integer id = mPersonList.get(getAdapterPosition()).getUid();
//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setMessage("Do you want to delete " + name + "?");
//                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(context, id+"", Toast.LENGTH_SHORT).show();
////                            mDb.personDao().deleteByID(id);
//                        }
//                    });
//                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                    builder.show();
//                }
//            });
        }
    }
}
