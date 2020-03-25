package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;

/**
 * @Description 项目子功能实体类
 * @Date 2020/3/25
 * @Author fjm
 */
public class ProjectSubFunc {

    private Long id;

    private Long funcId;

    private String functionName;

    private String personCharge;

    private Timestamp createTime;

    private Timestamp changeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getPersonCharge() {
        return personCharge;
    }

    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }
}
