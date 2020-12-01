package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.vo.EmployeeInfo;
import zhanweikai.com.vo.EmployeeQuery;

public interface EmployeeService {

    Employee selectEmployeeByName(String username);

    Employee selectEmployeeByPrimaryKey(Long id);

    Employee selectEmployeeByNameAndPassword(String username, String password);

    RestResult searchByEmployeeQuery(EmployeeQuery employeeQuery);

    Integer save(EmployeeInfo employeeInfo);

    int updateTypeEnabled(Long id);

    int updateTypeDisabled(Long id);
}
