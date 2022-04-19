package com.saveforgreen.datastructures.problem.number;

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
     
}
 
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode firstNumber = new ListNode(999999999);
		firstNumber.next = new ListNode(999999999);
		firstNumber.next.next = new ListNode(999999999);

		ListNode secondNumber = new ListNode(5);
		secondNumber.next = new ListNode(6);
		secondNumber.next.next = new ListNode(4);
		
		System.out.println(addTwoNumbers(firstNumber, secondNumber));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        
        String firstNumber = l1.val+"";
        while (l1.next != null) {
            l1 = l1.next;
            firstNumber = l1.val + firstNumber;
        }
        
        String secondNumber = l2.val+"";
        while (l2.next != null) {
            l2 = l2.next;
            secondNumber = l2.val + secondNumber;
        }
        ListNode result = null; 
        try {
        String sum = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
        System.out.println("Sum = " + sum);
             
        for (int i = 0; i < sum.length(); i++) {
          result =  new ListNode(Integer.parseInt(sum.charAt(i)+""), result);
        }
        } catch (NumberFormatException e) {
        	throw new IllegalArgumentException();
        }
        return result;
    }
}
