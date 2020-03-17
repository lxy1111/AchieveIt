package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.service.ProjectInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 项目信息controller层
 * @Author fjm
 * @Date 2020/3/17
 */
@Controller
@RequestMapping("/ProjectInfo")
@Api(tags = "项目信息接口")
public class ProjectInfoController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @RequestMapping("/Search")
    @ResponseBody
    @ApiOperation("查询项目信息")
    Response ProjectInfoSearch(@RequestBody ProjectInfoSearch projectInfoSearch){

        if(null == projectInfoSearch.getPageNum()){
            projectInfoSearch.setPageNum(0);
        }

        if(null == projectInfoSearch.getPageSize()){
            projectInfoSearch.setPageSize(10);
        }

        Response response = new Response();

        Integer count = projectInfoService.getProjectInfoCount(projectInfoSearch);

        List<ProjectInfo> projectInfos = projectInfoService.getProjectInfo(projectInfoSearch);
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("infoList",projectInfos);

        response.setCode("0");
        response.setMsg("查询成功");
        response.setCount(count);
        response.setData(map);

        return response;
    }


}
