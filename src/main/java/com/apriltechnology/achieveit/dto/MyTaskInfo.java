package com.apriltechnology.achieveit.dto;

/**
 * @Decsription 待审批项目信息
 * @Author fjm
 * @Date 2020/4/4
 */
public class MyTaskInfo {

    private Integer pageSize;

    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
