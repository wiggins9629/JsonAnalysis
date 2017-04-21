package com.wiggins.jsonanalysis.entity;


import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description 对象格式数据
 * @Author 一花一世界
 */
public class Common<T> {

    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Common{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static Common fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(Common.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(Common.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}