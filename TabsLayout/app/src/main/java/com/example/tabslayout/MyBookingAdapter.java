package com.example.tabslayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyBookingAdapter extends FragmentStateAdapter {
    public MyBookingAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Upcoming();
            case 1:
                return new History();
            default:
                return new Upcoming();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
