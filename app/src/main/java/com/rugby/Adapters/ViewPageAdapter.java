package com.rugby.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rugby.Fragment.allPlayers;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

     private List<Fragment> frags = new ArrayList<>();
     private List<String> fragmentTitle = new ArrayList<>();

    public ViewPageAdapter(@NonNull FragmentManager fm, int i) {
        super(fm, i);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){ return fragmentTitle.get(position);}

    public void addFragment(Fragment fragment, String title){
        frags.add(fragment);
        fragmentTitle.add(title);
    }

}
