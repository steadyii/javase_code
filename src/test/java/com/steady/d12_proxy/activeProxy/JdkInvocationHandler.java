package com.steady.d12_proxy.activeProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理,编译时自动实现代理类
 * 创建后在虚拟机中变成普通类
 */
@Slf4j
public class JdkInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private final Object target;
    
    //在此通过构造方法获取需要代理的实现类
    public JdkInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("<jdk动态代理目标方法之前>,args:{}", args);
        Object result = method.invoke(target, args);      //传入需要代理的方法,参数,返归result
        log.info("<jdk动态代理目标方法之后,args:{}", args);
        return result;
    }

    //getProxy 返回 已经被代理的对象,在此不使用泛型,而是使用object 需要在获得对象后,强转
    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);   //当前对象
    }
}

/*
  动态代理是在实现阶段不用关心代理类，而在运行阶段才指定哪一个对象
  动态代理类的源码是在程序运行期间由JVM根据反射等机制动态的生成
  JDK动态代理的一般步骤如下:
  1.创建被代理的接口和类；
  2.实现InvocationHandler接口，对目标接口中声明的所有方法进行统一处理;
  3.调用Proxy的静态方法，创建代理类并生成相应的代理对象;
    实现原理：利用拦截器机制必须实现InvocationHandler接口中的invoke方法实现对目标方法增强。
 */