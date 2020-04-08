package com.apriltechnology.achieveit.exception;

/**
 * @Description 插入自定义异常
 * @Author fjm
 * @Date 2020/4/8
 */
public class InsertException extends Exception{

    public InsertException(){
        super();
    }
    public InsertException(String message){
        super(message);
    }

    public InsertException(String message, Throwable cause){
        super(message,cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }
}
