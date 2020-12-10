package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.User;
import zhanweikai.com.vo.UserQueryDTO;

public interface UserService {
    User selectById(Long id);

    RestResult searchByPhoneAndName(UserQueryDTO userQueryDTO);

    int updateTypeEnabled(Long id);

    int updateTypeDisabled(Long id);

    RestResult save(User user);

    RestResult culculateReduce(Long userId, Double reduceBalance);

    RestResult reduceBalance(Long id, Double actualBalance);

    RestResult rechargeBalance(Long id, Double rechargeMoney);
}
