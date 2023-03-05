package com.steady.d12_proxy.activeProxy;

import com.steady.d12_proxy.staticProxy.entity.OrderService;
import com.steady.d12_proxy.staticProxy.entity.OrderServiceImpl;

public class test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //创建代理类
        JdkInvocationHandler jdkInvocationHandler =
                new JdkInvocationHandler(new OrderServiceImpl());

        //实际上生成 proxy代理类,由于代理类也实现接口,可以向上转型,使用接口接收
        OrderService orderService = (OrderService) jdkInvocationHandler.getProxy();
        orderService.addOrder("mayikt");
    }
}
