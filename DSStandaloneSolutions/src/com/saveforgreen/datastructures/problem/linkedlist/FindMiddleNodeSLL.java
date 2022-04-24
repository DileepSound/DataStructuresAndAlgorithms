package com.saveforgreen.datastructures.problem.linkedlist;

import com.saveforgreen.datastructures.vo.ListNode;

public class FindMiddleNodeSLL {

	public static void main(String[] args) {

		ListNode param = new ListNode(1);
		param.head = param;
		int i = 2;
		while (i <= 9) {
			param.next = new ListNode(i);
			param.next.head = param.head;
			param = param.next;
			i++;
		}
		System.out.println("param = " + param.head);
		System.out.println("Answer = " + middleNode(param.head));

	}

	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			System.out.println("slow=" + slow.val + ", fast="+fast.val);
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow;
	}
}