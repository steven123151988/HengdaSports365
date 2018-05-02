package com.hengda.hengdasports.fragment.bills;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseFragment;

/**
 * Description:
 * Data：2018/4/28-14:34
 * steven
 */
public class BillFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bill;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public static BillFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        BillFragment blankFragment = new BillFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.pager_text);
        textView.setText(getArguments().getString("text"));
    }


}
