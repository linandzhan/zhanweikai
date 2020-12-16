package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Orders;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrdersMapper {
    public Orders selectByPrimaryKey(long id);

    List<Orders> searchAreaByPeriodAndPlayDay(Long periodId, LocalDate playDay);

    Orders searchByAreaAndTime(Area area, Long periodId, LocalDate playDay);
}
