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
    private String ball,type,game;

    public Myadapter(FragmentManager fm, List<String> list,String ball,String type,String game) {
        super(fm);
        this.list = list;
        this.ball=ball;
        this.type=type;
        this.game=game;
    }

    @Override
    public Fragment getItem(int position) {
        return BillFragment.newInstance(list.get(position),ball,type,game);
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
