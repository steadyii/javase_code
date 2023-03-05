package com.steady.d7_collection.LIST;
/*
在每个方法体中定义temp
只是对单向链表进行优化，原有的单向链表功能也可以用
 */
public class DouLinkedList {
    public static void main(String[] args) {
        Node h1 = new Node(1, "x");
        Node h2 = new Node(2, "xx");
        Node h3 = new Node(3, "xxx");
        Node h4 = new Node(4,"xxxx");
        DouList douList = new DouList();
        douList.addList(h1);
        douList.addList(h2);
        douList.addList(h3);
        douList.addList(h4);

        Node H2 = new Node(2,"ccc-cc");
        douList.change(H2);
        douList.delete(3);
        douList.showList();
    }

}

class DouList{
    private final Node head =new Node(0,"");        //head不再改变

    public Node getHead() {
        return head;      //封装一下
    }


    public void addList(Node h){
        //添加节点，替换原链表的最后一个节点
        Node temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }                               //当退出while时，temp指向链表的最后
        temp.next=h;                    //将h添加到temp的下一个
        h.pre = temp;
    }


    public void showList(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;       //此处temp为第一个正式元素
        while (temp != null){
            System.out.println(temp);        //已重写toString
            temp = temp.next;            //temp后移
        }
    }

    public void delete(int no){
        Node temp=head.next;
        boolean flag=false;
        while (true){
            if (temp == null){  //此时已经遍历完，无no序号
                break;
            }
            if (temp.no==no){  //找到temp的下一个即为要删除的节点,temp要直接指向temp的下下个节点，跳过temp下一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
            temp.next.pre = temp.pre;
            }
        }else System.out.println("删除错误");
    }


    public void change(Node n){      //根据节点的no修改，使用单向链表代码
        Node temp=head.next;
        boolean flag=false;
        while (true){
            if (temp==null){      //temp一直后移，temp=temp.next; 第一个temp溢出 为空
                break;           //此处指未找到 目标no
            }
            if (temp.no==n.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=n.name;
        }else System.out.println("无指定节点");
    }
}


class Node {                    //定义一个结构体
    public int no;        //定义序号
    public String name;
    public Node next;        //next指向下一个节点
    public Node pre;           //pre指向前一个节点
    public Node(int no, String name){
        this.no=no;
        this.name=name;
    }
    @Override
    public String toString() {
        return "heroNode{" + "no=" + no + ", name='" + name + '\'' +  '}';
    }
}