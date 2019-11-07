package com.dubbo.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result<T> {
    private T result;
    private boolean success = true;
    private int errorCode;
    private String errorMessage;
    private Throwable reason;

    public Result(T result) {
        if(result == null)
        {
            this.success = false;
            this.errorCode = -1;
        }
        this.result = result;
    }

    public Result(int code, String errorMessage, T result, Throwable reason) {
        if(result == null)
        {
            this.errorCode = -1;
        }
        else
        {
            this.errorCode = code;
        }
        this.success = false;
        this.result = result;
        this.errorMessage = errorMessage;
        this.reason = reason;
    }

    public Result(int errorCode, String errorMessage) {
        this(errorCode,errorMessage,null);
    }

    public Result(int errorCode, String errorMessage, Throwable reason) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.reason = reason;
        this.success=false;
    }

}
