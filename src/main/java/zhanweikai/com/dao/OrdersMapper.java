package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Orders;

@Mapper
public interface OrdersMapper {
    public Orders selectByPrimaryKey(long id);
}
