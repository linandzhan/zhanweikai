package zhanweikai.com.service.impl;

import org.springframework.stereotype.Service;
import zhanweikai.com.dao.UserMapper;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.UserService;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
