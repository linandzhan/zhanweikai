package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Employee;

import java.util.List;

@Mapper
public interface AreaMapper {
    Area selectByPrimaryKey(Long id);

    List<Area> selectAll();

}
