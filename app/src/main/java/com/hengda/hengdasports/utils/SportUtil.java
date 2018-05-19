package com.hengda.hengdasports.utils;

import com.hengda.hengdasports.json2.BetMenuList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: 获取全部的玩法
 * Data：2018/5/16-11:59
 * steven
 */
public class SportUtil {
    public static Map<String, String> geAlltype(BetMenuList betMenuList) {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < betMenuList.getData().size(); i++) {
            map.put(betMenuList.getData().get(i).getType(), betMenuList.getData().get(i).getAlias());
        }
        return map;
    }
}
