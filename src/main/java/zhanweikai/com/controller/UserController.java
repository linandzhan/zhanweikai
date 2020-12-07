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

}
