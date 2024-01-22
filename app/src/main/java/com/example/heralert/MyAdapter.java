package com.example.heralert;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;
    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }
    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TipsFragment TipsFragment = new TipsFragment();
                return TipsFragment;
            case 1:
                EscapeFragment EscapeFragment = new EscapeFragment();
                return EscapeFragment;
            case 2:
                SelfDefenseFragment SelfDefenseFragment = new SelfDefenseFragment();
                return SelfDefenseFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
