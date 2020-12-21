package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.Period;

public interface PeriodService {
    RestResult searchPeriod();

    Period getPeriod(Long id);
}
