package com.zt.althogrim.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/7/23 00:04
 * @Description:求两个链表 第一个公共节点
 */
public class CommonFirstNode {


    /**
     *
     * 时间复杂度  O(m+n)  空间复杂度 O(m+n)
     */

    public static ListNode getCommonNode(ListNode list1,ListNode list2){
        if(list1 == null || list2 ==null) return null;
        Deque<ListNode> deque1 = new LinkedList<>();
        Deque<ListNode> deque2 = new LinkedList<>();

        ListNode p = list1;
        ListNode q = list2;
        while(p!=null){
            deque1.push(p);
            p = p.next;
        }
        while(q!=null){
            deque2.push(q);
            q = q.next;
        }

        ListNode target = null;
        while(!deque1.isEmpty() && !deque2.isEmpty()){
            ListNode a = deque1.pop();
            ListNode b = deque2.pop();
            if(a.val == b.val){
                target = a;
            }else
                break;
        }
        return target;
    }

    public static ListNode getCommonNode1(ListNode list1,ListNode list2){
        int sizeOfList1 = getListLength(list1);
        int sizeOfList2 = getListLength(list2);
        int diffSize = Math.abs(sizeOfList1 - sizeOfList2);
        ListNode pLong = list1;
        ListNode pShort = list2;
        if(sizeOfList2 > sizeOfList1){
            pLong = list2;
            pShort = list1;
        }

        for(int i=0;i<diffSize;i++){
            pLong = pLong.next;
        }

        while(pLong!=null && pShort !=null && pLong.val!=pShort.val){
            pLong = pLong.next;
            pShort = pShort.next;
        }

        // 第一个公共节点 就是  pLong
        return pLong;
    }

    private static int getListLength(ListNode list1){
        int size = 0;
        while(list1!=null){
            list1 = list1.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args){
        // 1-> 2 -> 3
        //            -> 6 -> 7
        //     4-> 5
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);

        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        ListNode list7 = new ListNode(7);

        list1.next = list2;
        list2.next = list3;
        list3.next = list6;

        list4.next = list5;
        list5.next = list6;

        list6.next = list7;
        System.out.println(getCommonNode(list1,list4).val);
    }
}
