package com.zt.althogrim.array;
import com.zt.althogrim.biTree.TreeNode;
import com.zt.list.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/7/16 11:23
 * @Description:
 */
public class LinkListAlgroithm {


    /*******************************************************************************
     * 双链表- 反转
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        if(null == head || head.next==null){
            return head;
        }
        Node curNode = head;
        while(curNode!=null){
            Node nextNode = curNode.next;
            Node prevNode = curNode.previous;
            curNode.previous = nextNode;
            curNode.next = prevNode;

            if(nextNode==null){ // 此时为反转链表的头节点
                head = curNode;
            }
            curNode = nextNode;
        }
        return head;
    }
    /*******************************************************************
     *  双向链表 排序！！！
     *  只需要交换 链表中的元素即可
     * @return
     */

    public static Node sortNode(Node pNode){
        int count = sizeOf(pNode);
        Node node = pNode;
        while(count > 1){
            while(node.next!=null){
                if((int)node.element > (int)node.next.element){
                    int temp = (int ) node.element;
                    node.element = node.next.element;
                    node.next.element = temp;
                }
                node = node.next;
            }
            count --;
            node=pNode;
        }
        return pNode;
    }

    /*
     * 双链表 排序  冒泡法
     * @param head
     * @return
     */
    public static Node sortNode1(Node head){
        int count = sizeOf(head);
        for(int i=0;i<count;i++){
            Node pNode = head;
            Node pnNode = head.next;
            for(int j=1;j<count-i;j++){
                if(pnNode!=null){
                    if((int) pnNode.element > (int) pNode.element){
                        int temp = (int) pNode.element;
                        pNode.element = pnNode.element;
                        pnNode.element = temp;
                    }
                    pNode = pnNode;
                    pnNode = pnNode.next;
                }
            }
        }
        return head;
    }

    /**
     * ListNode 的元素个数
     * @param node
     * @return
     */
    public static int sizeOf(Node node){
        int size =0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }


    public static void main(String[] args){

    }


}
