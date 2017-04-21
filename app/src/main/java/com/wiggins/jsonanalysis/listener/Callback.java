package com.wiggins.jsonanalysis.listener;

/**
 * @Description 数据回调接口
 * @Author 一花一世界
 */
public abstract class Callback<T> {

    public abstract void onSuccess(T t);

    public abstract T parseNetworkResponse(String str);
}
