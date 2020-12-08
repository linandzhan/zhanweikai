package zhanweikai.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.UserService;
import zhanweikai.com.vo.EmployeeQuery;
import zhanweikai.com.vo.Pageable;
import zhanweikai.com.vo.UserQueryDTO;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;




    @ApiOperation(value = "用户查询")
    @ApiImplicitParam(name = "userId", value = "用户id信息")
    @PostMapping("/api/user/searchById")
    public RestResult search(@RequestBody Map<String, Long> userId){
        Long id = userId.get("id");
        User user = userService.selectById(id);
        return null;
    }

    @ApiOperation(value = "根据用户的名字和手机进行模糊查询")
    @ApiImplicitParam(name = "searchInfo", value = "用户查询信息")
    @PostMapping("/api/user/searchByPhoneAndName")
    public RestResult searchByPhoneAndName(@RequestBody Map<String, UserQueryDTO> searchInfo){

        UserQueryDTO userQueryDTO = searchInfo.get("userQueryDTO");



        return userService.searchByPhoneAndName(userQueryDTO);
    }


    @ApiOperation(value = "用户启用")
    @ApiImplicitParam(name = "userId", value = "用户id信息")
    @PostMapping("/api/user/enable")
    public RestResult enable(@RequestBody Map<String, Long> userId){
        Long id = userId.get("id");
        int  result = userService.updateTypeEnabled(id);
        if(result > 0){
            return RestResult.success("启用成功");
        }else{
            return RestResult.error(402,"启用失败");
        }

    }


    @ApiOperation(value = "用户禁用")
    @ApiImplicitParam(name = "userId", value = "用户id信息")
    @PostMapping("/api/user/disable")
    public RestResult disable(@RequestBody Map<String, Long> userId){
        Long id = userId.get("id");
        int  result = userService.updateTypeDisabled(id);
        if(result > 0){
            return RestResult.success("禁用成功");
        }else{
            return RestResult.error(402,"禁用成功");
        }
    }

    @ApiOperation(value = "用户添加")
    @ApiImplicitParam(name = "user", value = "用户信息")
    @PostMapping("/api/user/save")
    public RestResult save(@RequestBody Map<String, User> userInfo){
        User user = userInfo.get("userInfo");
        return  userService.save(user);
    }





}
