package com.steady.d12_proxy.jdkProxy;

public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        return a+b;
    }
    @Override
    public String append(String o1, String o2) {
        return o1 + o2;
    }
}

interface UserDao {
    int add(int a,int b);
    String append(String o1,String o2);
}
