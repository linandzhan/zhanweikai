package zhanweikai.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.OrdersMapper;
import zhanweikai.com.dao.UserMapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Orders;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.AreaService;
import zhanweikai.com.service.OrdersService;
import zhanweikai.com.service.UserService;
import zhanweikai.com.vo.AreaSearchResultDTO;
import zhanweikai.com.vo.SearchAreaIsSpareDTO;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@RestController
@Api(tags = "场地管理")
public class AreaController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private AreaService areaService;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private UserService userService;


    /**
     * 前端传递 日期  场次  可查询该场次内的场地状态信息
     * @param searchInfo
     * @return
     */
    @ApiOperation(value = "场地预约查询")
    @ApiImplicitParam(name = "", value = "测试id")
    @PostMapping("/api/area/searchAreaIsSpare")
    public RestResult searchAreaIsSpare(@RequestBody Map<String, SearchAreaIsSpareDTO> searchInfo ){


        /*
         * List<Area> areas;
         * if(orders.getCreatTime() == now 查询出来所有的orders)
         * List<Orders>  orders
         * for(order : orders){
         *  Area area = order.get(areaId);
         *  根据订单的创建时间是现在时间，可以查询该订单对应的场地，然后设置场地的空余情况为false
         * }
         * */
        SearchAreaIsSpareDTO searchAreaInfo = searchInfo.get("searchAreaInfo");

        Long periodId =null;
        LocalDate playDay = null;
        //参数可传可不传
        if(searchAreaInfo != null){
           periodId = searchAreaInfo.getPeriodId();
           playDay = searchAreaInfo.getPlayDay();
        }
//
//
//        List<Area> areas = areaService.searchIsSpare(periodId,playDay);
//        List<AreaSearchResultDTO> areaDTOS = new ArrayList<>();
//
//
//
//        for (Area area :areas){
//            AreaSearchResultDTO areaDTO = new AreaSearchResultDTO();
//            BeanUtils.copyProperties(area,areaDTO);
//            if(!area.getIsSpare()){
//                //periodId这里有可能为0L，并不是真正的那个时间段，真正的时间段在searchIsSpare里面
//               Orders order =  ordersMapper.searchByAreaAndTime(area,periodId,playDay);
//                User user = userService.attach(order.getUserId());
//                areaDTO.setUserName(user.getUserName());
//            }
//            areaDTOS.add(areaDTO);
//        }



//        return RestResult.success("返回成功",areaDTOS);

        return areaService.searchIsSpare(periodId,playDay);
    }
}
