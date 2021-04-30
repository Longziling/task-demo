package com.yipeng.task.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {

    private int code;
    private String message;
    private T data;

    public static <T> RestResponse<T> buildErr(T data, String msg) {
        RestResponse<T> respResult = new RestResponse<>();
        respResult.setCode(0);
        respResult.setData(data);
        respResult.setMessage(msg);
        return respResult;
    }

    public static <T> RestResponse<T> buildSuccess(T data) {
        RestResponse<T> respResult = new RestResponse<>();
        respResult.setCode(1);
        respResult.setData(data);
        respResult.setMessage("ok");
        return respResult;
    }

}
