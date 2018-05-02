package com.hengda.hengdasports.fragment.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.adapter.Myadapter;
import com.hengda.hengdasports.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Description:
 * Data：2018/4/25-15:24
 * steven
 */
public class BetRecordsFragment extends BaseFragment {

    private TabLayout tab;
    private ViewPager pager;
    private List list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mybets;
    }

    @Override
    protected void initView() {
        this.pager = (ViewPager) getActivity().findViewById(R.id.pager);
        this.tab = (TabLayout) getActivity().findViewById(R.id.tab);

    }

    @Override
    protected void initData() {
//        list = new ArrayList<>();
//        list.clear();
//        for (int i = 0; i < 4; i++) {
//            list.add(new BillFragment());
//            list.add(new BillFragment());
//            list.add(new BillFragment());
//            list.add(new BillFragment());
//        }
        list = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            list.add(String.format(Locale.CHINA,"第%02d页",i));

        }
        //getChildFragmentManager()改成getChildFragmentManager()
        pager.setAdapter(new Myadapter(getChildFragmentManager(), list));
        /*Tab与ViewPager绑定*/
        tab.setupWithViewPager(pager);
    }
}
