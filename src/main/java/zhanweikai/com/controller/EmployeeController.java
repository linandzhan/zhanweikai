package zhanweikai.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.service.EmployeeService;
import zhanweikai.com.vo.EmployeeInfo;
import zhanweikai.com.vo.EmployeeQuery;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@Api(tags = "处理用户登录的controller")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;


    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "登录名"), @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @PostMapping("/employee/login")
    public RestResult login(@RequestBody Map<String,String> loginInfo ) throws UnsupportedEncodingException {
        //Map<String,String> loginInfo
  //      Employee employee = employeeService.selectEmployeeByName(username);
        String username = loginInfo.get("username");
        String password = loginInfo.get("password");
//        String u = new String(username.getBytes("utf-8"),"utf-8");
        Employee employee =  employeeService.selectEmployeeByNameAndPassword(username,password);
        if(employee == null){
            RestResult restResult = RestResult.error(400, "密码或用户名错误");
            return restResult;
        }else{
            RestResult restResult = RestResult.success();
            restResult.put("employee",employee);
            restResult.put("message","返回成功");
            return  restResult;
        }
    }


    @ApiOperation(value = "员工查询")
    @ApiImplicitParam(name = "employeeQuery", value = "员工查询信息")
    @PostMapping("/api/employee/search")
    public RestResult search(@RequestBody Map<String,EmployeeQuery> employeeQueryMap){
        EmployeeQuery employeeQuery = employeeQueryMap.get("employeeQuery");

        return employeeService.searchByEmployeeQuery(employeeQuery);
    }



    @ApiOperation(value = "员工添加")
    @ApiImplicitParam(name = "employeeQuery", value = "员工添加信息")
    @PostMapping("/api/employee/save")
    public RestResult save(@RequestBody Map<String, EmployeeInfo> employeeInfoMap){
        EmployeeInfo employeeInfo = employeeInfoMap.get("employeeInfo");
      Integer result = employeeService.save(employeeInfo);
      if(result > 0){
          return  RestResult.success("插入成功");
      }
        return RestResult.error(400,"插入失败");
    }



}
