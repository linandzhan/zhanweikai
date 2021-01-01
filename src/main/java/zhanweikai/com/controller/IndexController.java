package zhanweikai.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.AreaService;
import zhanweikai.com.service.EmployeeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@Api(tags = "测试管理")
public class IndexController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private AreaService areaService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/test")
    public String test(Long id,HttpServletResponse response) throws IOException {
        Employee employee = employeeService.selectEmployeeByPrimaryKey(id);
        System.out.println(employee);
        response.sendRedirect("/main/test.html");
        return "test";
    }

    @ApiOperation(value = "查询场地")
    @ApiImplicitParam(name = "areaId", value = "场地id信息")
    @PostMapping("/api/user/searchAreaById")
    public RestResult search(@RequestBody Map<String, Long> areaId){
        Long id = areaId.get("id");
        Area area = areaService.findById(id);
        System.out.println(area.getRentalPrice());
  //      Employee employeeId = area.getEmployeeId();
        return null;
    }


}
