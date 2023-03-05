package com.steady.d7_collection.StaCk;

import java.util.Scanner;

/**
 * 用数组模拟 栈
 * 定义一个栈顶top，初始下标为-1
 * 当有data入栈时，栈顶上移 top++,stack[top] ->data
 * 出栈，int value = stack[top] ,top--  ,方法 return value;
*/
public class ArrStack {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(4);
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        String key = "";
        while (flag){
            System.out.println("show : 显示栈");
            System.out.println("exit : 退出");
            System.out.println("push : 添加栈");
            System.out.println("pop : 取出栈顶数据");
            System.out.println("请输入指令");
            key = s.next();
//            switch (key){
//                case "show" -> as.show();
//                case "exit" -> {
//                    flag = false;
//                    s.close();         //关闭io流
//                }
//                case "push" -> {
//                    System.out.println("请输入一个数值");
//                    int value = s.nextInt();
//                    as.push(value);
//                }
//                case "pop" -> {
//                    int n = as.pop();
//                    System.out.println(n);
//                }
            }
//        }
//        System.out.println("程序结束");
    }

}

class ArrayStack{
    private int top = -1;
    public int[] stack;
    public int maxSize;        //maxSize 代表个数

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack = new int[this.maxSize];
    }
    public boolean isFull(){return top == maxSize-1;}

    public boolean isEmpty(){return top == -1;}

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满");
        }else {
            top++;
            stack[top] =value;
        }
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            System.out.println("空栈 将返回-1");
            return -1;
        }else {
            int value= stack[top];           //定义有一个辅助局部变量，传递数据
            top--;
            return value;
        }
    }

    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = 0; i < top+1; i++) {
            System.out.println(stack[i]);
        }
    }

}
