package zhanweikai.com.service.impl;

import org.springframework.stereotype.Service;
import zhanweikai.com.dao.AreaMapper;
import zhanweikai.com.pojo.Area;
import zhanweikai.com.service.AreaService;

import javax.annotation.Resource;

@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;

    @Override
    public Area findById(Long id) {
        Area area = areaMapper.selectByPrimaryKey(id);
        return area;
    }
}
