package com.tencent.connorlu.leetcode.example;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class _2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode header = new ListNode(0);
    	ListNode tail = header;
        int carry = 0;
        while(l1!=null && l2!=null){
        	
        	int sum = l1.val + l2.val + carry;
        	carry = sum/10;
        	ListNode current = new ListNode(sum%10);
        	
        	tail.next = current;
        	tail = current;
        	
        	l1 = l1.next;
        	l2 = l2.next;
        	
        }
        
        while(l1!=null){
        	
        	int sum = l1.val + carry;
        	carry = sum/10;
        	ListNode current = new ListNode(sum%10);
        	
        	tail.next = current;
        	tail = current;
        	
        	l1 = l1.next;
        	
        }
        
        while(l2!=null){
        	
        	int sum = l2.val + carry;
        	carry = sum/10;
        	ListNode current = new ListNode(sum%10);
        	
        	tail.next = current;
        	tail = current;

        	l2 = l2.next;	
        }
        
        if(carry!=0){
        	ListNode current = new ListNode(carry);
        	tail.next = current;
        	tail = current;
        }
        
        return header.next;
    }
}
