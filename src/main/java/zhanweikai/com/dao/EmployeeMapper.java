package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.vo.EmployeeQuery;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectEmployeeByName(String username);

    Integer countByNameAndPassword(String username, String password);

    List<Employee> selectByEmployeeQuery(EmployeeQuery employeeQuery);

    Long countByEmployeeQuery(EmployeeQuery employeeQuery);
}