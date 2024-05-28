package com.day12;

import java.util.Stack;
public class StackSorting {
 public static void sortStack(Stack<Integer> stack) {
 Stack<Integer> tempStack = new Stack<>();
 while (!stack.isEmpty()) {
 int current = stack.pop();
 while (!tempStack.isEmpty() && tempStack.peek() > current) {
 stack.push(tempStack.pop()); }
 tempStack.push(current); }
 while (!tempStack.isEmpty()){ // Transfer the sorted elements back to the original stack
 stack.push(tempStack.pop());
 }}
 public static void main(String[] args) {
 Stack<Integer> stack = new Stack<>();
 stack.push(34);
 stack.push(3);
 stack.push(31);
 stack.push(98);
 stack.push(92);
 stack.push(23);
 System.out.println("Original Stack:");
 System.out.println(stack);
 sortStack(stack);
 System.out.println("Sorted Stack:");
 System.out.println(stack); 
 }
 }