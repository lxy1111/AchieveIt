package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 异常处理控制层
 * @Author fjm
 * @Date 2020/3/11
 */
@Controller
@RequestMapping("/Error")
public class ErrorController {


    @RequestMapping("/NoPermission")
    @ResponseBody
    public Response noPermission(){

        return Response.createError("1","权限不足!");

    }

}
