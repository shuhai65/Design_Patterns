package com.shuhai65.service.impl;


import com.shuhai65.service.OrderAdapterService;
import com.shuhai65.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
