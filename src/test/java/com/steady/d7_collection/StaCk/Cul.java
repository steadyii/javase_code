package com.steady.d7_collection.StaCk;

import java.util.Scanner;

public class Cul {
    public static void main(String[] args) throws Exception {
        String ex1 = "3+2*6-2";
        String ex2 = "3+3*4*2-5";    //不能有空格

        System.out.println("请输入一串计算符");

        Scanner sc =new Scanner(System.in);
        String ex = sc.nextLine();

        culStack numStack = new culStack(20);
        culStack operStack = new culStack(20);

        int n1=0,n2=0;
        int res = 0;
        int index = 0;
        int oper =0;
        char ch =' ';   //初始空格
        String keepNum ="";
        do {
            ch = ex.substring(index, index + 1).charAt(0);   //获取ex中的一个字符串，然后再取第一个作为字符
            //判断
            if (operStack.isOper(ch)) {        //判断是否是运算符，用 ascll录入，再转化为字符录出
                if (operStack.isEmpty()) {
                    operStack.push(ch);    //如果运算符栈为空，直接加入
                } else {  //如果不为空
                    //取出上一个运算符，进行比较，
                    //如果 当前优先级小，就pop出之前的两个 数 与上一个运算符进行计算，得到结果，加入数栈
                    //如果当前运算符优先级高，就先存入符号栈

                    //判断优先级
                    if (operStack.pri(ch) <= operStack.pri(operStack.peek())) {

                        n2 = numStack.pop();
                        n1 = numStack.pop();
                        res = operStack.culu(n2, n1, operStack.pop());          //用上一个计算符计算
                        numStack.push(res);               //结果加入数栈
                        operStack.push(ch);                //当前符号加入符号栈
                    } else {
                        //当前运算符的优先级大，先存入符号栈,取出时再进行比较
                        operStack.push(ch);
                    }
                }
            } else {               //数字
                //               numStack.push(ch - 48);  //此时ch为ascll码，需要转化成 整数 （-48）
                keepNum += ch;   //字符拼接(先)
                if (index == ex.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                } else {
                    if (operStack.isOper(ex.substring(index + 1, index + 2).charAt(0))) {
                        //结束拼接
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";   //更新keepNum
                    }
                }
            }
            index++;
        } while (index < ex.length());

        while (!operStack.isEmpty()) {  //全部存入栈中后，再依次取出计算，得到数栈中最后一个数，就是结果  --此时符号栈为空
            //在存入时就保证了，后存入的符号，优先级高
            //所以此时，按照出栈的顺序，计算即可
            n2 = numStack.pop();
            n1 = numStack.pop();
            res = operStack.culu(n2, n1, operStack.pop());          //用上一个计算符计算
            numStack.push(res);               //结果加入数栈
        }
        System.out.println(numStack.pop());   //输出最终结果


    }
}
class culStack{
    private int top = -1;
    public int[] stack;
    public int maxSize;        //maxSize 代表个数

    //构造器
    public culStack(int maxSize){
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

    public int peek(){
        if (isEmpty()){   //此时一定不为空
            return -1;
        }else {
            return stack[top];
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
    public boolean isOper(int oper){
        return oper=='*' || oper=='/' || oper=='+' || oper=='-';
    }

    public int pri(int oper) throws Exception {    //仅有加减乘除
        if (isOper(oper)) {
            if (oper == '*' || oper == '/') {
                return 1;
            } else {
                return 0;
            }
        }else {
            throw new Exception();
        }
    }

    public int culu(int n1,int n2,int oper){     //n1先出来，实际上是在式子的后面
        int res = 0;
//        switch (oper){
//            case '*' -> res = n1 * n2;
//            case '/' -> res = n2 / n1;
//            case '+' -> res = n1 + n2;
//            case '-' -> res = n2 - n1;
//        }
        return res;
    }

}
