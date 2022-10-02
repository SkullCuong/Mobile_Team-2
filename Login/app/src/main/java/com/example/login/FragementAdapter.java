package com.example.login;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragementAdapter extends FragmentStateAdapter {
    int tabcount;

    public FragementAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, int tabcount) {
        super(fragmentManager, lifecycle);
        this.tabcount = tabcount;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new Login();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return tabcount;
    }
}
