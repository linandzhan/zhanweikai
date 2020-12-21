package zhanweikai.com.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.AreaMapper;
import zhanweikai.com.dao.OrdersMapper;
import zhanweikai.com.dao.UserMapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.pojo.Orders;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.*;
import zhanweikai.com.vo.CreateOrdersDTO;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private AreaMapper areaMapper;
    @Resource
    private AreaService areaService;
    @Resource
    private PeriodService periodService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Resource
    private EmployeeService employeeService;


    @Override
    public RestResult saveCharteredOrders(CreateOrdersDTO orderInfo) {

        Area area = new Area();
        area.setAreaId(orderInfo.getAreaId());
        Area attachArea = areaService.attach(area);
        orderInfo.setAreaAmont(attachArea.getRentalPrice());




        User user = userMapper.selectByPhone(orderInfo.getPhone());
        orderInfo.setPaymentAmount(orderInfo.getAreaAmont());
        if(user != null){
            orderInfo.setUserId(user.getUserId());
            if (User.LEVEL_LOW.equals(user.getLevel())){
                orderInfo.setPaymentAmount(orderInfo.getAreaAmont() * 0.9);
            }else if(User.LEVEL_MIDDLE.equals(user.getLevel())){
                orderInfo.setPaymentAmount(orderInfo.getAreaAmont() * 0.8);
            }else if(User.LEVEL_MIDDLE.equals(user.getLevel())){
                orderInfo.setPaymentAmount(orderInfo.getAreaAmont() * 0.7);
            }
            User attachUser = userService.attach(user);
            attachUser.setBalance(attachUser.getBalance() - orderInfo.getPaymentAmount());
            userMapper.updateByPrimaryKeySelective(attachUser);  //扣除相应的余额
        }


        orderInfo.setCreateTime(LocalDateTime.now());



        orderInfo.setEmployeeId(employeeService.getAccount().getId());

       int i =  ordersMapper.save(orderInfo);
       if(i > 0){
           return RestResult.success("包场成功");
       }else {
           return RestResult.error(403,"包场失败");
       }
    }



}
