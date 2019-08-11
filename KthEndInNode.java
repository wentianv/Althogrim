package com.zt.althogrim.array;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/7/23 16:45
 * @Description:求链表 倒数第 k 个节点
 */
public class KthEndInNode {

    public static void main(String[] args){
        // 构建 链表 1 -7
        ListNode head = new ListNode(7);
        for( int i=6;i>0;i--){
            ListNode t = new ListNode(i);
            t.next = head;
            head = t;
        }
        ListNode kth = getKthEndNode(head,33);
        System.out.println(kth==null?kth:kth.val);
    }

    // 求链表倒数第 k 个节点
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    static ListNode getKthEndNode(ListNode head,int k){
        if(head == null || k < 1) return null;
        ListNode p1 = head;
        ListNode p2 = head;// 用于移动指针
        for(int i=0;i<k-1;i++){
            if(p2.next!=null){ // 这样保证p2 到最后一个 node,而不是null
                p2= p2.next;
            }else{
                return null;
            }
        }

        while(p2.next!=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}
