package com.steady.d12_proxy.staticProxy.entity;

import com.steady.d12_proxy.staticProxy.entity.OrderService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class OrderServiceImpl implements OrderService {
    
    /**
     * 接口的实现类,具体方法需要被代理
     */
    @Override
    public String addOrder(String orderName) {
        log.info("<orderName:{}>" + orderName);
        return "ok";
    }
}

