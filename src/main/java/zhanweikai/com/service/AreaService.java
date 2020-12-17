package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.pojo.Area;

import java.time.LocalDate;
import java.util.List;

public interface AreaService {
    Area findById(Long id);

    RestResult searchIsSpare(Long periodId, LocalDate playDay);
}
