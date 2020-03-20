package com.apriltechnology.achieveit.dto;

import java.util.Map;

/**
 * @Description json返回类型
 * @Author fjm
 * @Date 2020/3/9
 */
public class Response {

    //状态 "0"成功 "1"失败
    private String code;

    //返回信息
    private String msg;

    //数量
    private Integer count;

    //返回的数据
    private Map<String,?> data;

    public String getCode() {
        return code;
    }

    public static Response createError(String code,String msg){
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Map<String, ?> getData() {
        return data;
    }

    public void setData(Map<String, ?> data) {
        this.data = data;
    }
}
