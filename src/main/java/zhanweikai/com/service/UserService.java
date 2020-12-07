package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.User;
import zhanweikai.com.vo.UserQueryDTO;

public interface UserService {
    User selectById(Long id);

    RestResult searchByPhoneAndName(UserQueryDTO userQueryDTO);
}
