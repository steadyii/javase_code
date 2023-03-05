package com.steady.d12_proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过Proxy.newProxyInstance 创建获取代理对象<br>
 * 依次传入类加载器,要被代理的类,handler类提供了具体的增强方法
 */
public class test {
    public static void main(String[] args) {
        Class[] inter = new Class[]{UserDao.class};   //可以有多个..
        //返回被代理对象
        UserDao user = (UserDao) Proxy.newProxyInstance(
                test.class.getClassLoader(),
                inter,
                new UserHandler(new UserDaoImpl())
        );
        System.out.println(user.add(1, 2));
        System.out.println(user.append("123", "456"));
    }
}

class UserHandler implements InvocationHandler {
    private final Object object;
    public UserHandler(Object object){     //通过有参构造,获取要增强的对象
        this.object = object;
    }
    //写增强的部分,返回增强后的对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException{
        System.out.println("pre");

        Object o = method.invoke(object, args);

        System.out.println("after");
        return o;
    }
}











