package zhanweikai.com.service;

import zhanweikai.com.common.RestResult;
import zhanweikai.com.vo.CreateOrdersDTO;

public interface OrdersService {
    RestResult saveCharteredOrders(CreateOrdersDTO userInfo);
}
