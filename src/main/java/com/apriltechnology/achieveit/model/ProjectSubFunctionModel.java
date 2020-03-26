package com.apriltechnology.achieveit.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Description excel导入model实体
 * @Author fjm
 * @Date 2020/3/25
 */
public class ProjectSubFunctionModel extends BaseRowModel {

    @ExcelProperty(index = 0,value = "功能名称")
    private String functionName;

    @ExcelProperty(index = 1,value = "负责人")
    private String personCharge;

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
}
