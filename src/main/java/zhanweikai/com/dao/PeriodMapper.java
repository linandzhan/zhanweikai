package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Period;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PeriodMapper {
    /**
     * 搜索当前时间段
     * @return
     */
    List<Long> searchByNow();

    List<Period> selectAll();
}
