package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListProblems {

    static ListNode head;
    public static void main(String[] args) {
        LinkedListProblems linkedList = new LinkedListProblems();
        head = linkedList.createLinkedList();
        System.out.println("Input Linked List");
        linkedList.printLinkedList(head);
//        linkedList.deleteNode(head.next);
//        ListNode reversed = linkedList.reverseList(head);
        System.out.println("\nOutput Linked List");
        System.out.println(linkedList.hasCycle(head));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode createLinkedList() {
        int[] input = {4,5,1,9};
        ListNode head = new ListNode(input[0]);
        ListNode node = head;
        for (int i = 1; i < input.length; i++) {
            ListNode newNode = new ListNode(input[i]);
            node.next = newNode;
            node = newNode;
        }
        return head;
    }

    void printLinkedList(ListNode head){
        if(head != null) {
            System.out.print(head.val);
            if(head.next != null) {
                System.out.print(", ");
                printLinkedList(head.next);
            }
        }
    }

//    https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/
    void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            System.out.println("\ndeleting node " + node.val);
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    List<Object> list = new ArrayList<>();
    public boolean hasCycle(ListNode head) {
        while(head != null){
            if(!list.contains(head)) {
                list.add(head);
                head = head.next;
            }
            else return true;
        }
        return false;
    }
}

