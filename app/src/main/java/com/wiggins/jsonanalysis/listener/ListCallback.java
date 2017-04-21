package com.wiggins.jsonanalysis.listener;

import com.wiggins.jsonanalysis.entity.CommonList;

import java.lang.reflect.ParameterizedType;

/**
 * @Description 集合解析接口
 * @Author 一花一世界
 */
public abstract class ListCallback<T> extends Callback<CommonList<T>> {

    @Override
    public CommonList<T> parseNetworkResponse(String str) {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return CommonList.fromJson(str, entityClass);
    }
}
