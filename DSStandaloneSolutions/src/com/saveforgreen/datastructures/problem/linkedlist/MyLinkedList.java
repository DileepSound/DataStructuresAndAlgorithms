package com.saveforgreen.datastructures.problem.linkedlist;

class MyLinkedList {

    
    Node head;
        
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	int result = -1;
        if (index < 0) {
            return -1;
        } else if (index == 0) {
        	result = head.val;
        } else if (index == 1 && this.head != null && this.head.next != null) {
        	result = this.head.next.val;    
        } else {        
            Node currentNode = this.head.next;
            int i = 1;
            while (i < index && currentNode.next != null) {
                currentNode = currentNode.next;
                i++;        
            }
            
            if ( i == index && currentNode != null) {
                result = currentNode.val;
            } else {
                return -1;
            }
        }
        return result;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	
    	 if (val > 1000) {
             System.err.println("Invalid input!");
             return;
         }
         Node newHead = new Node(val);
         newHead.next = head; 
         head = newHead;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (val > 1000) {
            System.err.println("Invalid input!");
           return;
        }
        
        if (head == null) {
           head = new Node(val);
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }       
            currentNode.next = new Node(val);
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || val > 1000) {
            System.err.println("Invalid input!");
           return;
        }
        if (index == 0 || head == null) {
            addAtHead(val);
            return;
        }        
        int i = 0;
        Node currentNode = head;
        while (i < index-1 && currentNode.next != null) {
            currentNode = currentNode.next;
            i++;
        }
        Node newNode = new Node(val);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) {
            System.err.println("Invalid input!");
           return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        int i = 0;
        Node currentNode = head;
        while (i < index-1 && currentNode.next != null) {
            currentNode = currentNode.next;
            i++;
        }
        if (i == index-1 && currentNode.next != null) 
            currentNode.next = currentNode.next.next;
    }
    
    private static class Node {
        int val;
        Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */