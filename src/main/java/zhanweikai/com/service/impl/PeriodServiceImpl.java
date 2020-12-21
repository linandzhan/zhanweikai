package zhanweikai.com.service.impl;

import org.springframework.stereotype.Service;
import zhanweikai.com.common.RestResult;
import zhanweikai.com.dao.PeriodMapper;
import zhanweikai.com.pojo.Period;
import zhanweikai.com.service.PeriodService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeriodServiceImpl implements PeriodService {
    @Resource
    private PeriodMapper periodMapper;



    @Override
    public RestResult searchPeriod() {
        List<Period> periods = periodMapper.selectAll();
        return RestResult.success("返回成功",periods);
    }

    @Override
    public Period getPeriod(Long id) {
        Period period = new Period();
        period.setPeriodId(id);
        return period;
    }
}
