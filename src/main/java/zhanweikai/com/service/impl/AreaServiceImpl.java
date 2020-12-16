package zhanweikai.com.service.impl;

import org.springframework.stereotype.Service;
import zhanweikai.com.dao.AreaMapper;
import zhanweikai.com.dao.OrdersMapper;
import zhanweikai.com.dao.PeriodMapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Orders;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.AreaService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private PeriodMapper periodMapper;

    @Override
    public Area findById(Long id) {
        Area area = areaMapper.selectByPrimaryKey(id);
        return area;
    }

    /**
     * 查询场地状态是否为空场，  返回全部场地，场地为空的isSpare为true,场地不为空isSpare为false
     * @param periodId
     * @param playDay
     * @return
     */
    @Override
    public List<Area> searchIsSpare(Long periodId, LocalDate playDay) {

        List<Area> areas =  areaMapper.selectAll();
        areas.forEach(i->i.setIsSpare(true));   //一般场地都为空

        if(playDay == null && periodId==0){
            //默认为当前时间
            playDay = LocalDate.now();   //默认为今天
            List<Long> periodIds = periodMapper.searchByNow();//默认为当前时间段
            if(periodIds.isEmpty()){
                //不在选择的时间段内，默认全部场地都为空白
               return areas;
            }else{
                //其实就是只有一个时间段
                periodId = periodIds.get(0);
            }
        }

       List<Orders> orders = ordersMapper.searchAreaByPeriodAndPlayDay(periodId,playDay);

        for (Orders order : orders) {
            Area area = order.getAreaId();
            Long areaId = area.getAreaId();
            for (Area area_ : areas){
                if(area_.getAreaId() == areaId){
                    //订单中有存在
                    area_.setIsSpare(false);  //设置为空场
                }
            }
            // User user = order.getUserId();
        }



        return areas;
    }
}
