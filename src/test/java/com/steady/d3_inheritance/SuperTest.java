package com.steady.d3_inheritance;

public class SuperTest {
    public static void main(String[] args) {
        S s = new S();
        
        S s1 = new S(3);
        
        S s2 = new S("saf");
    }
}

class P {
    
    public P() {
        System.out.println("p-init");
    }
    
    public P(int a) {
        System.out.println(a + "p-int-init");
    }
}

class S extends P {
    public S() {
        super(2);
        System.out.println("super-init");
    }
    
    public S(int b) {
        System.out.println("int-init");
    }
    
    public S(String s) {
        System.out.println("string-init");
    }
}
