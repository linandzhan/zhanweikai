package zhanweikai.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.UserMapper;
import zhanweikai.com.pojo.User;
import zhanweikai.com.service.UserService;
import zhanweikai.com.vo.ListVo;
import zhanweikai.com.vo.UserQueryDTO;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public RestResult searchByPhoneAndName(UserQueryDTO userQueryDTO) {
        //List<Employee> list =  PageHelper.startPage(employeeQuery.getPage(),employeeQuery.getPageSize()).doSelectPage(()->employeeMapper.selectByEmployeeQuery(employeeQuery));
        List<User> users = PageHelper.startPage(userQueryDTO.getPage(),userQueryDTO.getSize()).doSelectPage(()->userMapper.searchByPhoneAndName(userQueryDTO));

        Long total = userMapper.countByPhoneAndName(userQueryDTO);
        ListVo listVo = new ListVo();
        listVo.setItems(users);
        listVo.setTotal(total);

        return RestResult.success("查询成功",listVo);
    }
}
