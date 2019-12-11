package com.an2t.beforetestonlyjava.view_pager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.an2t.beforetestonlyjava.view_pager.models.Show;

import java.util.List;

public class InFiniteViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<Show> mShows;

    public InFiniteViewPagerAdapter(FragmentManager fm, List<Show> mShows) {
        super(fm);
        this.mShows = mShows;
    }

    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment mFragment = new ViewPagerFragment();
        Show s = mShows.get(position);
        Bundle mB = new Bundle();
        mB.putParcelable("pos", s);
        mFragment.setArguments(mB);
        return mFragment;
    }

    @Override
    public int getCount() {
        return mShows.size();
    }
}
