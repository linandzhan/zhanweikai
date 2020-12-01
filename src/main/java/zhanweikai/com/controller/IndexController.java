package zhanweikai.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.service.EmployeeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IndexController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String test(Long id,HttpServletResponse response) throws IOException {
        Employee employee = employeeService.selectEmployeeByPrimaryKey(id);
        System.out.println(employee);
        response.sendRedirect("/main/test.html");
        return "test";
    }
}
