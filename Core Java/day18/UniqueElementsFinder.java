package day18;
/*Task 2: Unique Elements Identification
Given an array of integers where every element appears twice except for two, write a function that efficiently finds these two non-repeating elements using bitwise XOR operations.*/

public class UniqueElementsFinder {
    public int[] findUniqueElements(int[] nums) {
        // XOR of all elements gives us XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Get the rightmost set bit in the xor
        int rightmostSetBit = xor & -xor;

        // Divide numbers into two groups based on the rightmost set bit
        int unique1 = 0, unique2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                unique1 ^= num;
            } else {
                unique2 ^= num;
            }
        }

        return new int[]{unique1, unique2};
    }

    public static void main(String[] args) {
        UniqueElementsFinder finder = new UniqueElementsFinder();
        int[] nums = {2, 4, 7, 9, 2, 4};
        int[] uniqueElements = finder.findUniqueElements(nums);
        System.out.println("The unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
    }
}