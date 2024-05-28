package com.day12;

	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Stack;
	public class QueueSorting {
	 public static void sortQueueWithStack(Queue<Integer> queue) {
	 Stack<Integer> stack = new Stack<>();
	 int n = queue.size();
	 for (int i = 0; i < n; i++) {
	 int min = Integer.MAX_VALUE;
	 int minCount = 0;
	 int currentSize = queue.size();
	 // Find the minimum element
	 for (int j = 0; j < currentSize; j++) {
	 int element = queue.poll();
	 if (element < min) {
	 min = element;
	 minCount = 1;
	 } else if (element == min) {
	 minCount++;
	 }
	 stack.push(element);
	 }
	 // Move elements back from stack to queue, skipping the min element
	 while (!stack.isEmpty()) {
	 int element = stack.pop();
	 if (element != min) {
	 queue.add(element);
	 } else {
	 minCount--;
	 if (minCount > 0) {
	 queue.add(element);
	 }}
	 }
	 // Enqueue the min element to its sorted position
	 queue.add(min);
	 }
	 }
	 public static void main(String[] args) {
	 Queue<Integer> queue = new LinkedList<>();
	 queue.add(3);
	 queue.add(1);
	 queue.add(4);
	 queue.add(1);
	 queue.add(5);
	 queue.add(9);
	 queue.add(2);
	 System.out.println("Original Queue: " + queue);
	 sortQueueWithStack(queue);
	 System.out.println("Sorted Queue: " + queue);
	 }
	} 

