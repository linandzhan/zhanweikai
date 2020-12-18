package zhanweikai.com.dao;



import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.User;
import zhanweikai.com.vo.UserQueryDTO;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    List<User> searchByPhoneAndName(UserQueryDTO userQueryDTO);

    Long countByPhoneAndName(UserQueryDTO userQueryDTO);

    User selectBalanceByPrimaryKey(Long userId);

    User selectByPhone(String phone);
}