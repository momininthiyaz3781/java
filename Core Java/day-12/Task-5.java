package com.day12;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int val) { this.val = val; }
	}
	public class ListNoderm {
	 public static ListNode removeDuplicates(ListNode head) {
	 if (head == null) return null;
	 ListNode current = head;
	 while (current != null && current.next != null) {
	 if (current.val == current.next.val) {
	 current.next = current.next.next; // Remove the duplicate node
	 } else {
	 current = current.next; // Move to the next node
	 }
	 }
	 return head;
	 }
	 public static void printList(ListNode head) {
	 ListNode current = head;
	 while (current != null) {
	 System.out.print(current.val + " ");
	 current = current.next; }
	 System.out.println(); }
	 public static void main(String[] args) {
	
	 ListNode head = new ListNode(1);
	 head.next = new ListNode(1);
	 head.next.next = new ListNode(2);
	 head.next.next.next = new ListNode(3);
	 head.next.next.next.next = new ListNode(3);
	 head.next.next.next.next.next = new ListNode(4);
	 head.next.next.next.next.next.next = new ListNode(4);
	 head.next.next.next.next.next.next.next = new ListNode(5);
	 System.out.println("Original List:");
	 printList(head);
	 head = removeDuplicates(head);
	 System.out.println("List after removing duplicates:");
	 printList(head); }}