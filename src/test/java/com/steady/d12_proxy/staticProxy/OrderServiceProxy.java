package com.steady.d12_proxy.staticProxy;

import com.steady.d12_proxy.staticProxy.entity.OrderService;
import com.steady.d12_proxy.staticProxy.entity.OrderServiceImpl;
import lombok.extern.java.Log;

/**
 * 直接实现接口中的方法,使用最多
 */
@Log
public class OrderServiceProxy implements OrderService {

    private final OrderService orderService;
    //添加 构造函数
    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }
    @Override
    public String addOrder(String orderName) {
        // 目标方法前后处理操作
        log.info("<目标方法之前执行...>");
        String result = orderService.addOrder(orderName);
        log.info("<目标方法之后执行...>");
        return result;
    }
}

class Test01 {
    public static void main(String[] args) {
        OrderServiceProxy orderServiceProxy =
                new OrderServiceProxy(new OrderServiceImpl());
        //实际上接受的参数是接口..
        String result = orderServiceProxy.addOrder("mayikt");
        System.out.println(result);
    }
}


