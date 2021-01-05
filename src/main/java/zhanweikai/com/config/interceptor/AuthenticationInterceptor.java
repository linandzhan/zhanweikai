package zhanweikai.com.config.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zhanweikai.com.annotation.RequiredPermission;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.pojo.Permission;
import zhanweikai.com.pojo.Role;
import zhanweikai.com.pojo.RolePermission;
import zhanweikai.com.service.*;


import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AuthenticationInterceptor implements HandlerInterceptor {
//    @Autowired
//    private UserService userService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;
    @Resource
    private RolePermissionService rolePermissionService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 防止 userService 注入不进来
        if (null == employeeService) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            employeeService = (EmployeeService) factory.getBean("employeeService");
        }
        // 验证权限
        if (this.hasPermission(handler,request)) {
            return true;
        }
        //  null == request.getHeader("x-requested-with") TODO 暂时用这个来判断是否为ajax请求
        // 如果没有权限 则抛403异常 springboot会处理，跳转到 /error/403 页面
//        response.sendError(HttpStatus.FORBIDDEN.value(), "无权限");

//        return false;
       // response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("无权限");
//        response.getWriter().flush();

        ServletOutputStream output = response.getOutputStream();
        output.write(("no-permission").getBytes());
        output.flush();

        return  false;
    }

    /**
     * 是否有权限
     */
    private boolean hasPermission(Object handler,HttpServletRequest request) {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            // 获取方法上的注解
//            RequiredPermission requiredPermission = handlerMethod.getMethod().getAnnotation(RequiredPermission.class);
//            // 如果方法上的注解为空 则获取类的注解
//            if (requiredPermission == null) {
//                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequiredPermission.class);
//            }
//            // 如果注解为null, 说明不需要拦截, 直接放过
//            if (requiredPermission == null) {
//                return true;
//            }
//            // 如果标记了注解，则判断权限
//            if (StringUtils.isNotBlank(requiredPermission.value())) {
//                // 应该到 redis 或数据库 中获取该用户的权限信息 并判断是否有权限
//                //Set<String> permissionSet = userService.getPermissionSet();
//                // 这里测试使用 直接add
//                Set<String> permissionSet  = new HashSet<>();
////                permissionSet.add("user:view");
////                permissionSet.add("user:save");
//                Employee employee = (Employee) request.getSession().getAttribute("employee");
//                permissionSet  = employeeService.findRoleByEmployee(employee.getId());
//
//                if (CollectionUtils.isEmpty(permissionSet) ){
//                    return false;
//                }
//                return permissionSet.contains(requiredPermission.value());
//
//
////                return true;
//            }
//        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
