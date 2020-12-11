package zhanweikai.com.service.impl;

import org.springframework.stereotype.Service;
import zhanweikai.com.dao.RolePermissionMapper;
import zhanweikai.com.pojo.Permission;
import zhanweikai.com.service.RolePermissionService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;


//    @Override
//    public Set<String> findPermissionByRolesId(List<Long> roleIds) {
//        return rolePermissionMapper.findPermissionByRoleId(roleIds);
//    }
}
