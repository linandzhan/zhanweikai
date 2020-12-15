package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Orders;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrdersMapper {
    public Orders selectByPrimaryKey(long id);

    List<Area> searchAreaByPeriodAndPlayDay(Long periodId, LocalDate playDay);
}
