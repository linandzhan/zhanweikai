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

import javax.annotation.Resource;
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
}
