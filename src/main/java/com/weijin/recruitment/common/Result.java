package com.weijin.recruitment.common;

import lombok.Data;

import java.io.Serializable;


/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 14:55
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private T data;

    private String msg;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(String msg,T data) {
        return result(1,msg,data);
    }

    public static <T> Result<T> success(String msg) {
        return result(1,msg,null);
    }

    public static <T> Result<T> failed(String msg) {
        return result(0,msg , null);
    }
    public static <T> Result<T> failed(Integer code,String msg) {
        return result(code,msg , null);
    }
    private static <T> Result<T> result(Integer code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
