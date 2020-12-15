package zhanweikai.com.service.impl;

import org.springframework.stereotype.Service;
import zhanweikai.com.dao.AreaMapper;
import zhanweikai.com.dao.OrdersMapper;
import zhanweikai.com.dao.PeriodMapper;
import zhanweikai.com.pojo.Area;
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

    @Override
    public List<Area> searchIsSpare(Long periodId, LocalDate playDay) {
        if(playDay == null && periodId==null){
            //默认为当前时间
            playDay = LocalDate.now();   //默认为今天
            List<Long> periodIds = periodMapper.searchByNow();//默认为当前时间段
            if(periodIds.isEmpty()){
                //不在时间段内

            }else{
                periodId = periodIds.get(0);
            }
        }

       List<Area> areas = ordersMapper.searchAreaByPeriodAndPlayDay(periodId,playDay);


        return null;
    }
}
