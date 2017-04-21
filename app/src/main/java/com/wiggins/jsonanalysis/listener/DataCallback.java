package com.wiggins.jsonanalysis.listener;

import com.wiggins.jsonanalysis.entity.Common;

import java.lang.reflect.ParameterizedType;

/**
 * @Description 对象解析接口
 * @Author 一花一世界
 */
public abstract class DataCallback<T> extends Callback<Common<T>> {

    @Override
    public Common<T> parseNetworkResponse(String str) {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return Common.fromJson(str, entityClass);
    }
}
