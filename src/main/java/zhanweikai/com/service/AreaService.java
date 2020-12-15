package zhanweikai.com.service;

import zhanweikai.com.pojo.Area;

import java.time.LocalDate;
import java.util.List;

public interface AreaService {
    Area findById(Long id);

    List<Area> searchIsSpare(Long periodId, LocalDate playDay);
}
