package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.vo.CreateOrdersDTO;
import zhanweikai.com.vo.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface OrdersService {
    RestResult saveCharteredOrders(CreateOrdersDTO userInfo);

    RestResult search(Pageable pageable);

    RestResult searchStatistics(LocalDateTime startTime, LocalDateTime endTime);
}
