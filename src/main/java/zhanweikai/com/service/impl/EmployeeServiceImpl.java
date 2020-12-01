package zhanweikai.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.EmployeeMapper;
import zhanweikai.com.pojo.Employee;
import zhanweikai.com.service.EmployeeService;
import zhanweikai.com.vo.EmployeeInfo;
import zhanweikai.com.vo.EmployeeQuery;
import zhanweikai.com.vo.ListVo;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public Employee selectEmployeeByName(String username) {
        Employee employee = employeeMapper.selectEmployeeByName(username);
        return employee;
    }

    @Override
    public Employee selectEmployeeByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Employee selectEmployeeByNameAndPassword(String username, String password) {
        if(employeeMapper.countByNameAndPassword(username,password) > 0){
            return employeeMapper.selectEmployeeByName(username);
        }
        return null;
    }

    @Override
    public RestResult searchByEmployeeQuery(EmployeeQuery employeeQuery) {
      List<Employee> list =  PageHelper.startPage(employeeQuery.getPage(),employeeQuery.getPageSize()).doSelectPage(()->employeeMapper.selectByEmployeeQuery(employeeQuery));
      if(list.isEmpty()){
          return RestResult.error(400,"找不到数据");
      }else{
         Long quantity =  employeeMapper.countByEmployeeQuery(employeeQuery);
          ListVo listVo = new ListVo();
          listVo.setItems(list);
          listVo.setTotal(quantity);
          return RestResult.success("查找成功",listVo);
      }

    }

    @Override
    public Integer save(EmployeeInfo employeeInfo) {
        EmployeeQuery employeeQuery = new EmployeeQuery();
        employeeQuery.setUsername(employeeInfo.getUsername());
        Long count = employeeMapper.countByEmployeeQuery(employeeQuery);
        if(count > 0) {
            return 0;
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeInfo,employee);
//        System.out.println(employee);
        employee.setType("启用");  //默认启用


        int i = employeeMapper.insertSelective(employee);


        return i;
    }

    @Override
    public int updateTypeEnabled(Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setType("启用");
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        return i;
    }

    @Override
    public int updateTypeDisabled(Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setType("禁用");
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        return i;
    }


//    @Override
//    public Employee selectEmployeeByNameAndPassword(String username, String password) {
//        int count = employeeMapper.countByNameAndPassword(username,password);
//        if(count > 0){
//            return employeeMapper.selectEmployeeByName(username);
//        }
//        return null;
//    }
}
