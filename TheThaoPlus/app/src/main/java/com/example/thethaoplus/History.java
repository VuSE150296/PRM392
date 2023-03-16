package com.example.thethaoplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends Fragment {
    private ArrayList<MyBooking> arrayList;
    private ListView lvMyBookingCard;
    private MyBookingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_history, container, false);
        arrayList = new ArrayList<>();
        lvMyBookingCard = (ListView) view.findViewById(R.id.listViewBookingCard);
        adapter = new MyBookingAdapter(view.getContext(), arrayList, R.layout.booking_card_item);
        lvMyBookingCard.setAdapter(adapter);
        getData();
        // Inflate the layout for this fragment
        return view;
    }
    private void getData() {
        arrayList.add(new MyBooking("Nov.11,2022", "10:30", "Cancel", "177 Nguyen Xi, Binh Thanh, tp HCM ", "Lotee Football Stadium"));
        arrayList.add(new MyBooking("Nov.11,2022", "10:30", "Cancel", "177 Nguyen Xi, Binh Thanh, tp HCM ", "Lotee Football Stadium"));
        arrayList.add(new MyBooking("Nov.11,2022", "10:30", "Cancel", "177 Nguyen Xi, Binh Thanh, tp HCM ", "Lotee Football Stadium"));
        arrayList.add(new MyBooking("Nov.11,2022", "10:30", "Accept", "177 Nguyen Xi, Binh Thanh, tp HCM ", "Lotee Football Stadium"));
        arrayList.add(new MyBooking("Nov.11,2022", "10:30", "Accept", "177 Nguyen Xi, Binh Thanh, tp HCM ", "Lotee Football Stadium"));
        arrayList.add(new MyBooking("Nov.11,2022", "10:30", "Accept", "177 Nguyen Xi, Binh Thanh, tp HCM ", "Lotee Football Stadium"));
    }
}