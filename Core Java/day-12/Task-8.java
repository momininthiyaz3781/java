package com.day12;

public class CircularQueue {
	 public static int search(int[] nums, int target) {
	 int rotationIndex = findRotationIndex(nums);
	 int left = binarySearch(nums, target, 0, rotationIndex - 1);
	 int right = binarySearch(nums, target, rotationIndex, nums.length - 1);
	 return (left != -1) ? left : (right != -1) ? right : -1; }
	 private static int findRotationIndex(int[] nums) {
	 int left = 0;
	 int right = nums.length - 1;
	 while (left < right) {
	 int mid = left + (right - left) / 2;
	 if (nums[mid] > nums[right]) {
	 left = mid + 1;
	 } else {
	 right = mid;
	 }
	 }
	 return left;
	 }
	 private static int binarySearch(int[] nums, int target, int left, int right) {
	 while (left <= right) {
	 int mid = left + (right - left) / 2;
	 if (nums[mid] == target) {
	 return mid;
	 } else if (nums[mid] < target) {
	 left = mid + 1;
	 } else {
	 right = mid - 1;
	 }
	 }
	 return -1; // Element not found
	 }
	 public static void main(String[] args) {
	 int[] nums = {4, 5, 6, 7, 0, 1, 2};
	 int target = 6;
	 int index = search(nums, target);
	 System.out.println("Index of " + target + " in the circular queue: " + index);
	 }
	}