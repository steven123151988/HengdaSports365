package com.hengda.hengdasports.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hengda.hengdasports.fragment.bills.BillFragment;

import java.util.List;

/**
 * Description:
 * Data：2018/4/28-16:41
 * steven
 */
public class Myadapter extends FragmentPagerAdapter {

    private List<String> list;

    public Myadapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return BillFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
