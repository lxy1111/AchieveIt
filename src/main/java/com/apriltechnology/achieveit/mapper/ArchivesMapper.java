package com.apriltechnology.achieveit.mapper;


import com.apriltechnology.achieveit.entity.Archives;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 档案类类接口
 * @Author br
 * @Date 2020/4/8
 */

@Repository
public interface ArchivesMapper {
    //通过项目id添加档案信息
    int archivesAdd(@Param("projectId")Long projectId);

    //通过项目id搜寻档案信息
    List<Archives> getArchivesList(@Param("projectId")Long projectId);

    //审批项目基础数据表
    int acceptProjectBasicTable(@Param("projectId")Long projectId);

    //审批项目提案书
    int acceptProjectProposal(@Param("projectId")Long projectId);

    //审批项目报价书
    int acceptProjectPrice(@Param("projectId")Long projectId);

    //审批项目估算表
    int acceptProjectEstimate(@Param("projectId")Long projectId);

    //审批项目计划书
    int acceptProjectSchedule(@Param("projectId")Long projectId);

    //审批项目过程裁剪表
    int acceptProjectProcess(@Param("projectId")Long projectId);

    //审批项目成本管理表
    int acceptProjectCost(@Param("projectId")Long projectId);

    //审批项目需求变更表
    int acceptProjectDemand(@Param("projectId")Long projectId);

    //审批项目风险管理表
    int acceptProjectRisk(@Param("projectId")Long projectId);

    //审批客户验收问题表
    int acceptProblem(@Param("projectId")Long projectId);

    //审批客户验收报告
    int acceptReport(@Param("projectId")Long projectId);

    //审批项目总结
    int acceptProjectSummary(@Param("projectId")Long projectId);

    //审批项最佳经验和教训
    int acceptBestExperience(@Param("projectId")Long projectId);

    //审批开发工具
    int acceptDevelopTool(@Param("projectId")Long projectId);

    //审批开发模板
    int acceptDevelopModel(@Param("projectId")Long projectId);

    //审批各阶段检查单
    int acceptExamine(@Param("projectId")Long projectId);

    //审批QA总结
    int acceptQASummary(@Param("projectId")Long projectId);
}
