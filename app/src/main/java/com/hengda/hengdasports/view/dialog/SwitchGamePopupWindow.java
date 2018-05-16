package com.hengda.hengdasports.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import com.hengda.hengdasports.R;
import com.hengda.hengdasports.adapter.PopupMenuAdapter;
import com.hengda.hengdasports.json2.PopupMenuBean;
import com.hengda.hengdasports.view.dialog.easypopup.BaseCustomPopup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SwitchGamePopupWindow extends BaseCustomPopup {

    private Context context;
    private OnItemClickListener onItemClickListener;
    private GridView gv_popup;
    private List<PopupMenuBean> list;

    public SwitchGamePopupWindow(Context context) {
        super(context);
        this.context = context;

    }

    public SwitchGamePopupWindow setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }

    @Override
    protected void initAttributes() {
        setContentView(R.layout.popup_layout_switch_game, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusAndOutsideEnable(true)
                .setBackgroundDimEnable(true)
                .setAnimationStyle(R.style.AnimDown);
    }

    @Override
    protected void initViews(View view) {
        gv_popup = (GridView) view.findViewById(R.id.gv_popup);
        list = new ArrayList<>();
//        Map<Integer, String> otherGames = LotteryUtil.get().getAllOtherGames(gameCode);
//        Set<Map.Entry<Integer, String>> entries = otherGames.entrySet();
//        for (Map.Entry<Integer, String> entry : entries) {
//            PopupMenuBean Pmb = new PopupMenuBean();
//            Pmb.setCode(entry.getKey());
//            Pmb.setName(entry.getValue());
//            list.add(Pmb);
//        }
//        PopupMenuAdapter adapter = new PopupMenuAdapter(context,list);
//        gv_popup.setAdapter(adapter);
//        gv_popup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (onItemClickListener != null) {
//                    onItemClickListener.onItemClick(list.get(position).getCode());
//                }
//                dismiss();
//            }
//        });
    }

    public interface OnItemClickListener {
        void onItemClick(int gameCode);
    }
}
