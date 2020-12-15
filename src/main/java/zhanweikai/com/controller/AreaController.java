package zhanweikai.com.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.service.AreaService;
import zhanweikai.com.service.OrdersService;
import zhanweikai.com.vo.SearchAreaIsSpareDTO;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AreaController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private AreaService areaService;

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
        Long periodId = searchAreaInfo.getPeriodId();
        LocalDate playDay = searchAreaInfo.getPlayDay();
        List<Area> areas = areaService.searchIsSpare(periodId,playDay);

        return null;
    }
}
