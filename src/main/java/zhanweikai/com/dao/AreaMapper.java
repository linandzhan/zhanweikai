package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.pojo.Employee;

@Mapper
public interface AreaMapper {
    Area selectByPrimaryKey(Long id);

}
