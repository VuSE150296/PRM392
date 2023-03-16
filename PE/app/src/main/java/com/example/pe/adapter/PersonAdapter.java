package com.example.pe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pe.MainActivity;
import com.example.pe.R;
import com.example.pe.models.Person;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Person> personArrayList;
    private MainActivity mainActivity;

    public PersonAdapter(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
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
        Person person = personArrayList.get(position);

        holder.tvName.setText(person.getName());
        holder.tvPhone.setText(person.getPhone());
    }

    @Override
    public int getItemCount() {
        if (personArrayList != null) {
            return personArrayList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;
        ImageView imgEdit, imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvPhone = (TextView) itemView.findViewById(R.id.textViewPhone);

            imgEdit = (ImageView) itemView.findViewById(R.id.imageViewEdit);
            imgDelete = (ImageView) itemView.findViewById(R.id.imageViewDelete);

            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.editPerson(personArrayList.get(getAdapterPosition()).getId());
                }
            });
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.deletePerson(personArrayList.get(getAdapterPosition()).getId(),personArrayList.get(getAdapterPosition()).getName());
                }
            });
        }
    }
}
