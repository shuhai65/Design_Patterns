package com.shuhai65.service.impl;


import com.shuhai65.service.OrderAdapterService;
import com.shuhai65.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
