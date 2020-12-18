package zhanweikai.com.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.AreaMapper;
import zhanweikai.com.dao.OrdersMapper;
import zhanweikai.com.dao.PeriodMapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Orders;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.AreaService;
import zhanweikai.com.service.UserService;
import zhanweikai.com.vo.AreaSearchResultDTO;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private PeriodMapper periodMapper;
    @Resource
    private UserService userService;

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
    public RestResult searchIsSpare(Long periodId, LocalDate playDay) {

        List<Area> areas =  areaMapper.selectAll();
        areas.forEach(i->i.setIsSpare(true));   //一般场地都为空





        Long period = getPeriodId(periodId);
        LocalDate playDay_ = getPlayDay(playDay);

        List<Orders> orders = ordersMapper.searchAreaByPeriodAndPlayDay(period,playDay_);
        for (Orders order : orders) {
            Area area = order.getAreaId();
            Long areaId = area.getAreaId();
            for (Area area_ : areas) {
                if (area_.getAreaId() == areaId) {   //该时间段内有订单对应的场地都应该设为false
                            //订单中有存在
                    area_.setIsSpare(false);  //设置为空场
                }
            }
        }

        List<AreaSearchResultDTO> areaResults = new ArrayList<>();

        setAreaResult(areaResults,areas,period,playDay_);


        return RestResult.success("返回成功",areaResults);
    }

    private void setAreaResult(List<AreaSearchResultDTO> areaResults, List<Area> areas,Long periodId,LocalDate playDay) {
        for (Area area:areas){
            AreaSearchResultDTO areaResult = new AreaSearchResultDTO();
            BeanUtils.copyProperties(area,areaResult);
            if(!area.getIsSpare()){
                //场地不为空时,根据场地和时间段查询出是谁订的场地。
                Orders order = ordersMapper.searchByAreaAndTime(area, periodId, playDay);
                if(order.getUserId().getUserId() != null){
                    //有可能是非会员包场的
                    User user = userService.attach(order.getUserId());
                    areaResult.setUserName(user.getUserName());
                }else {
                    areaResult.setPhone(order.getPhone());
                }
            }
            areaResults.add(areaResult);
        }

    }




    public Long getPeriodId(Long periodId){
        if(periodId == null){
            List<Long> periods = periodMapper.searchByNow();

            if(!periods.isEmpty()){
                return periods.get(0);
            }
        }

        return periodId;
    }

    public LocalDate getPlayDay(LocalDate playDay){
        if (playDay == null){
            return LocalDate.now();
        }
        return  playDay.plusDays(1);
    }


}
