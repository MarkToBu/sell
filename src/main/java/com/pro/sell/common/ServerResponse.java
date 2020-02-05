package com.pro.sell.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

//自动清除null的对象

/**
 * 返回值封装
 * @author Administrator
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
    private int code;

    private String message;

    private T data;

    private String description;

    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public ServerResponse() {
    }

    public ServerResponse(int code) {
        this.code = code;
    }

    public ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ServerResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServerResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ServerResponse(int code, String message, T data, String description) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.description = description;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    //成功返回的各种方法
    public static ServerResponse createBySuccess() {
        return new ServerResponse(ResponseCode.SUCCESS.getCode());
    }

    public static ServerResponse createBySuccessMessage(String msg) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    //错误方法
    public static ServerResponse createByError() {
        return new ServerResponse(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static ServerResponse createByErrorMessage(String errorMessage) {
        return new ServerResponse(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static ServerResponse createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse(errorCode, errorMessage);
    }

    public static ServerResponse createByErrorCodeMessageWithFlag(String errorMessage, int flag) {
        ServerResponse serverResponse = createByErrorMessage(errorMessage);
        serverResponse.setFlag(flag);
        return serverResponse;
    }

}
