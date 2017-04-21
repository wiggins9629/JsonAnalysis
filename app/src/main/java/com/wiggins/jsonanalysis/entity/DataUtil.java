package com.wiggins.jsonanalysis.entity;

import com.wiggins.jsonanalysis.listener.Callback;

/**
 * @Description 数据解析
 * @Author 一花一世界
 */
public class DataUtil {

    public static void getData(String url, Callback callback) {
        Object object = callback.parseNetworkResponse(url);
        callback.onSuccess(object);
    }
}
