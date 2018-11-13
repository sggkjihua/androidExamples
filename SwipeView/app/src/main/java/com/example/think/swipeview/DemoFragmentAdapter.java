package com.example.think.swipeview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoFragmentAdapter extends FragmentStatePagerAdapter {
    public DemoFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BasicFragment basicFragment = new BasicFragment();
        Bundle bundle = new Bundle();
        position = position+1;
        bundle.putString("message", "damn from page"+position);
        basicFragment.setArguments(bundle);

        return basicFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;
        return "Fragment"+position;
    }
}
