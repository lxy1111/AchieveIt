package com.apriltechnology.achieveit.service;

import javafx.util.Pair;

/**
 * @Description 组员增加时顺带调整memberassign表
 * @Author br
 * @Date 2020/4/5
 */

public interface ProjectMemberService {
    Pair<Boolean,String> adjustQAMemberAssign(Long projectId);

    Pair<Boolean,String> adjustEPGMemberAssign(Long projectId);

    Pair<Boolean,String> adjustDEVMemberAssign(Long projectId);
}
