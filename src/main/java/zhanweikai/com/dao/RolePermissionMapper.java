package zhanweikai.com.dao;

import org.apache.ibatis.annotations.Mapper;
import zhanweikai.com.pojo.Permission;

import java.util.List;
import java.util.Set;
@Mapper
public interface RolePermissionMapper {
    Set<String> findPermissionByRoleId(List<Long> roleIds);
}
