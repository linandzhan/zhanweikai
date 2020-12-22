package zhanweikai.com.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.OrdersMapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.pojo.Orders;
import zhanweikai.com.service.OrdersService;
import zhanweikai.com.vo.CreateOrdersDTO;
import zhanweikai.com.vo.EmployeeQuery;
import zhanweikai.com.vo.Pageable;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@RestController
@Api(tags = "订单管理")
public class OrdersController {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrdersService ordersService;


    @ApiOperation(value = "测试")
    @ApiImplicitParam(name = "id", value = "测试id")
    @PostMapping("/api/orders/test")
    public RestResult search(){
        Orders orders = ordersMapper.selectByPrimaryKey(3);
        Double rentalPrice = orders.getAreaId().getRentalPrice();
        System.out.println(orders);
        return null;
    }



    @ApiOperation(value = "创建包场订单")
    @ApiImplicitParam(name = "id", value = "测试id")
    @PostMapping("/api/orders/save")
    public RestResult save(@RequestBody Map<String, CreateOrdersDTO> createOrdersInfo){
        CreateOrdersDTO orderInfo = createOrdersInfo.get("orderInfo");
        return ordersService.saveCharteredOrders(orderInfo);
    }


    @ApiOperation(value = "查询包场订单")
    @PostMapping("/api/orders/search")
    public RestResult search(@RequestBody Map<String, Pageable> pageableInfo){
        Pageable pageable = pageableInfo.get("pageable");
        return ordersService.search(pageable);
    }


    @ApiOperation(value = "统计查询")
    @ApiImplicitParam(name = "pageable", value = "分页信息")
    @PostMapping("/api/orders/searchStatistics")
    public RestResult searchStatistics(@RequestBody JSONObject jsonObject){
        LinkedHashMap dateTimeRange = (LinkedHashMap) jsonObject.get("dateTimeRange");
        String startTime = (String) dateTimeRange.get("start");
        String endTime = (String) dateTimeRange.get("end");

        if(startTime == null || endTime == null){
            LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
            LocalDateTime now = LocalDateTime.now();
            return ordersService.searchStatistics(start,now);
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTimeDate = LocalDateTime.parse(startTime, df);
        LocalDateTime endTimeDate = LocalDateTime.parse(endTime, df);
        return ordersService.searchStatistics(startTimeDate,endTimeDate);
    }













}
