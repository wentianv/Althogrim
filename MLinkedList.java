package com.zt.althogrim.array;

import com.zt.list.Node;

import java.util.Deque;
import java.util.LinkedList;

import static com.zt.althogrim.array.LinkListAlgroithm.sortNode;
import static com.zt.althogrim.array.LinkListAlgroithm.sortNode1;

/**
 * @Auther: ASUS
 * @Date: 2019/7/15 18:34
 * @Description:
 *
 * 双向链表   头指针 元素  尾指针
 */
public class MLinkedList<E>  {
    // 定义头指针,尾指针 指向 LinkedList
    private Node first;
    private Node last;
    private int size; // 链表长度

    public MLinkedList(){
        size =0;
    }

    /**
     * 添加链表--直接添加到尾部
     * @param element
     */
    public void add(E element){
        Node node = new Node(element);
        if(first==null){
            first=node;
            last=node;
        }else {
            last.next=node;
            node.previous=last;
            node.next = null;
            last = node;
        }
        size++;
    }

    /**
     *  添加链表
     * @param index
     * @param element
     */
    public void add(int index,E element){
        if(index == size){
            add(element);
        }else {
            Node newNode = new Node(element);
            Node tmpNode = get(index);
            if(tmpNode!=null){
                Node preNode = tmpNode.previous;
                preNode.next = newNode;
                newNode.previous = preNode;

                newNode.next = tmpNode;
                tmpNode.previous = newNode;
                size ++;
            }
        }
    }

    public int size(){
        return size;
    }

//    public void remove(E element){
//        // 删除一个链表
//        Node node = first;
//        for(int i=0;i<size;i++){
//            if(node.element == element){
//                remove(i);
//            }
//            node = node.next;
//        }
//    }

    /**
     * 删除链表
     * @param index
     */
    public void remove(int index){
        Node curNode = get(index);
        if(curNode!=null){
            Node preNode = curNode.previous;
            Node nextNode = curNode.next;
            if(preNode!=null){// 不是头节点
                preNode.next = nextNode;
            }else{
                first = nextNode;
            }

            if(nextNode!=null){
                nextNode.previous=preNode;
            }else{
                last = preNode;
            }
            size--;
        }
    }

    /**
     * 获取 链表中的数据
     * @param index
     * @return
     */
    public Node get(int index){
        checkRange(index);
        Node node = null;
        // 从前往后遍历
        if(index < (size>>1)){
            node = first;
            for(int i=0; i<index ;i++){
                node = node.next;
            }
        }else{// 从后往前遍历
            node = last;
            for(int i=size-1;i>index;i--){
                node = node.previous;
            }
        }
       return node;
    }

    public void checkRange(int index){
        if(index <0 || index >= size){
            throw new RuntimeException("链表位置有误");
        }
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        for(int i=0;i<size;i++){
            sb.append(node.element+"\t");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        MLinkedList<String> linkedList = new MLinkedList<>();
//        linkedList.add(0,"aa");
//        linkedList.add(1,"vv");
//        linkedList.add(2,"cc");
//        linkedList.add(3,"ff");
//        linkedList.add(2,"dd");
//        System.out.println(linkedList);
//
//        linkedList.remove(4);
//        System.out.println(linkedList);
//
        MLinkedList<Integer> list1 = new MLinkedList<>();
        list1.add(18);
        list1.add(3);
        list1.add(20);
        list1.add(15);
        list1.add(9);
//        long begin = System.currentTimeMillis();
//        Node p = sortNode(list1.first);
//        long end = System.currentTimeMillis();
//        System.out.println("time:"+(end-begin));

        Node p = LinkListAlgroithm.reverseList(list1.first);
        while (p!=null){
            System.out.println(p.element);
            p = p.next;
        }
    }
}
