package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.ProjectInfoAdd;
import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.dto.UserProjectPermissionInfo;
import com.apriltechnology.achieveit.entity.*;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.exception.InsertException;
import com.apriltechnology.achieveit.mapper.*;
import com.apriltechnology.achieveit.service.ProjectInfoService;
import com.apriltechnology.achieveit.util.UserUtil;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 项目信息service实现层
 * @Author fjm
 * @Date 2020/3/17
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MemberAssignMapper memberAssignMapper;

    @Autowired
    private UserProjectRoleMapper userProjectRoleMapper;

    @Autowired
    private UserProjectPermissionMapper userProjectPermissionMapper;

    @Override
    public List<ProjectInfo> getProjectInfo(ProjectInfoSearch projectInfoSearch) {

        Integer offset = (projectInfoSearch.getPageNum()-1)*projectInfoSearch.getPageSize();
        Integer limit = projectInfoSearch.getPageSize();
        List<ProjectInfo> projectInfos = projectInfoMapper.getProjectInfoList(projectInfoSearch.getId(), projectInfoSearch.getProjectName(), projectInfoSearch.getCustomerInfo(),
                projectInfoSearch.getLeader(), projectInfoSearch.getMilepost(), projectInfoSearch.getProjectFunction(), projectInfoSearch.getTechnology(), projectInfoSearch.getBusinessArea(),
                projectInfoSearch.getScheduleTime(), projectInfoSearch.getDeliveryTime(),offset,limit);

        return projectInfos;
    }

    @Override
    public Integer getProjectInfoCount(ProjectInfoSearch projectInfoSearch) {

        Integer count = projectInfoMapper.getProjectInfoCount(projectInfoSearch.getId(), projectInfoSearch.getProjectName(), projectInfoSearch.getCustomerInfo(),
                projectInfoSearch.getLeader(), projectInfoSearch.getMilepost(), projectInfoSearch.getProjectFunction(), projectInfoSearch.getTechnology(), projectInfoSearch.getBusinessArea(),
                projectInfoSearch.getScheduleTime(), projectInfoSearch.getDeliveryTime());
        return count;
    }

    @Override
    public Pair<Boolean,String> editProjectInfo(ProjectInfoSearch projectInfoSearch) {

        int result = projectInfoMapper.updateProjectInfo(projectInfoSearch);
        if(result <= 0){
            return new Pair<>(false,"更新失败！");
        }else{
            return new Pair<>(true,"更新成功！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public Pair<Boolean, String> deleteProjectInfo(List<Long> projectIds) throws BatchDeleteException{

        if(null != projectIds && projectIds.size() > 0){
            int size = projectIds.size();
            int result = projectInfoMapper.deleteProjectInfo(projectIds);
            if(result == size){
                return new Pair<>(true,"删除成功！");
            }else{
                throw new BatchDeleteException("删除失败！");
            }
        }

        return new Pair<>(false,"请选择需要删除的项目！");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public Pair<Boolean, String> insertProjectInfo(ProjectInfoAdd projectInfoAdd, Long createId, int status) throws InsertException{

        User leader = userMapper.getUserByUsername(projectInfoAdd.getLeader());
        if(null == leader){
            return new Pair<>(false,"项目上级不存在！");
        }

        ProjectInfo projectInfo = this.dataChange(projectInfoAdd,createId,status);
        int count = projectInfoMapper.insertProjectInfo(projectInfo);

        if(count <= 0){
            throw new InsertException("插入失败！");
        }

        User pm = UserUtil.get();
        List<UserProjectRole> userProjectRoles = new ArrayList<>();

        UserProjectRole userProjectRole1 = new UserProjectRole();
        userProjectRole1.setProjectId(projectInfo.getId());
        userProjectRole1.setUserId(leader.getId());
        userProjectRole1.setRoleId(1L);
        userProjectRoles.add(userProjectRole1);

        UserProjectRole userProjectRole2 = new UserProjectRole();
        userProjectRole2.setProjectId(projectInfo.getId());
        userProjectRole2.setUserId(pm.getId());
        userProjectRole2.setRoleId(5L);
        userProjectRoles.add(userProjectRole2);

        MemberAssign memberAssign = new MemberAssign();
        memberAssign.setProjectId(projectInfo.getId());
        memberAssign.setQaMember(0);
        memberAssign.setEpgMember(0);
        memberAssign.setDevMember(0);

        UserProjectPermissionInfo userProjectPermission1 = new UserProjectPermissionInfo();
        userProjectPermission1.setUserId(pm.getId());
        userProjectPermission1.setProjectId(projectInfo.getId());
        userProjectPermission1.setMailPermission(1);
        userProjectPermission1.setFilePermission(1);
        userProjectPermission1.setGitPermission(1);

        UserProjectPermissionInfo userProjectPermission2 = new UserProjectPermissionInfo();
        userProjectPermission2.setUserId(leader.getId());
        userProjectPermission2.setProjectId(projectInfo.getId());
        userProjectPermission2.setMailPermission(1);
        userProjectPermission2.setFilePermission(1);
        userProjectPermission2.setGitPermission(1);

        int cc = userProjectPermissionMapper.insertUserProjectPermission(userProjectPermission1);
        if(cc <= 0){
            throw new InsertException("插入失败");
        }

        cc = userProjectPermissionMapper.insertUserProjectPermission(userProjectPermission2);
        if(cc <= 0){
            throw new InsertException("插入失败");
        }

        int result = memberAssignMapper.insertMemberAssign(memberAssign);
        if(result <= 0){
            throw new InsertException("插入失败！");
        }

        int num = userProjectRoleMapper.batchInsertUserProjectRole(userProjectRoles);
        if(num != 2){
            throw new InsertException("插入失败!");

        }

        return new Pair<>(true,"插入成功！");

    }

    //实体类转移
    private ProjectInfo dataChange(ProjectInfoAdd projectInfoAdd,Long createId,int status){
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setCreaterId(createId);
        projectInfo.setProjectName(projectInfoAdd.getProjectName());
        projectInfo.setCustomerInfo(projectInfoAdd.getCustomerInfo());
        projectInfo.setLeader(projectInfoAdd.getLeader());
        projectInfo.setMilepost(projectInfoAdd.getMilepost());
        projectInfo.setProjectFunction(projectInfoAdd.getProjectFunction());
        projectInfo.setTechnology(projectInfoAdd.getTechnology());
        projectInfo.setBusinessArea(projectInfoAdd.getBusinessArea());
        projectInfo.setScheduleTime(projectInfoAdd.getScheduleTime());
        projectInfo.setDeliveryTime(projectInfoAdd.getDeliveryTime());
        projectInfo.setStatus(status);
        return projectInfo;
    }

    @Override
    public int getProjectStatus(Long projectId) {

        int status = projectInfoMapper.getProjectStatus(projectId);
        return status;
    }

    @Override
    public Pair<Boolean,String> changeProjectStatus(Long projectId, Integer status) {

        int result = projectInfoMapper.changeProjectStatus(projectId,status);
        if(result > 0){
            return new Pair<>(true,"状态更新成功！");
        }else{
            return new Pair<>(false,"更新失败！");
        }

    }

    @Override
    public List<ProjectInfo> searchMyTaskProjectInfo(String leader, Integer status,Integer pageNum,Integer pageSize) {

        Integer offset = (pageNum - 1)*pageSize;
        Integer limit = pageSize;
        List<ProjectInfo> projectInfos = projectInfoMapper.getMyTaskProjectInfo(leader,status,offset,limit);
        return projectInfos;
    }

    @Override
    public int searchMyTaskProjectInfoCount(String leader, Integer status) {
        Integer count = projectInfoMapper.getMyTaskProjectInfoCount(leader,status);
        if(null == count || count < 0){
            return 0;
        }
        return count;
    }

    @Override
    public List<ProjectInfo> searchMyProjectInfo(Long createrId,Integer pageSize,Integer pageNum) {

        Integer offset = (pageNum-1)*pageSize;
        Integer limit = pageSize;

        List<ProjectInfo> projectInfos = projectInfoMapper.getMyProjectInfo(createrId,offset,limit);
        return projectInfos;
    }

    @Override
    public int searchMyProjectInfoCount(Long createrId) {
        Integer count = projectInfoMapper.getMyProjectInfoCount(createrId);
        if(null == count || count < 0){
            return 0;
        }
        return count;
    }

    @Override
    public List<ProjectInfo> searchQALeaderProject(Integer pageNum, Integer pageSize) {
        Integer offset = (pageNum-1)*pageSize;
        Integer limit = pageSize;
        List<ProjectInfo> projectInfos = projectInfoMapper.getQALeaderProject(offset,limit,1);
        return projectInfos;
    }

    @Override
    public int searchQALeaderProjectCount() {
        Integer count = projectInfoMapper.getQALeaderProjectCount(1);
        if(null == count || count < 0){
            return 0;
        }
        return count;
    }

    @Override
    public List<ProjectInfo> searchEPGLeaderProject(Integer pageNum, Integer pageSize) {
        Integer offset = (pageNum-1)*pageSize;
        Integer limit = pageSize;
        List<ProjectInfo> projectInfos = projectInfoMapper.getEPGLeaderProject(offset,limit,1);
        return projectInfos;
    }

    @Override
    public int searchEPGLeaderProjectCount() {
        Integer count = projectInfoMapper.getEPGLeaderProjectCount(1);
        if(null == count || count < 0){
            return 0;
        }
        return count;
    }

    @Override
    public List<ProjectInfo> getMemberProjectInfo(Long userId, Integer pageNum, Integer pageSize) {
        Integer offset = (pageNum-1)*pageSize;
        Integer limit = pageSize;
        List<Long> ids = projectInfoMapper.getMemberProjectIds(offset,limit,userId);
        if(null == ids || ids.size() <= 0){
            return  new ArrayList<>();
        }
        List<ProjectInfo> projectInfos = projectInfoMapper.getProjectInfosByIds(ids);
        return projectInfos;
    }

    @Override
    public int getMemberProjectInfoCount(Long userId) {
        Integer count = projectInfoMapper.getMemberProjectIdsCount(userId);
        if(null == count || count < 0){
            return 0;
        }
        return count;
    }

    @Override
    public Long getProjectCreaterId(Long projectId) {
        ProjectInfo projectInfo = projectInfoMapper.getProjectInfoById(projectId);
        return projectInfo.getCreaterId();
    }

    @Override
    public Pair<Boolean, String> judgeRolesAssignment(Long projectId) {
        MemberAssign memberAssign = memberAssignMapper.searchMemberAssign(projectId);
        if(null == memberAssign){
            return new Pair<>(false,"项目不存在！");
        }
        if(memberAssign.getQaMember().equals(0) || memberAssign.getEpgMember().equals(0)){
            return new Pair<>(false,"EPG 和 QA 还未分配！");
        }

        return new Pair<>(true,"EPG 和 QA 均已分配成功！");
    }


}
