import java.util.Arrays;

/**
    Majority Element
    ----------------
    Given an array of size n, find the majority element.
    The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    
    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:
        Input: [3,2,3]
        Output: 3
    
    Example 2:
        Input: [2,2,1,1,1,2,2]
        Output: 2
 */
 class FirstMajorElement {
    public int majorityElement(int[] nums) {
        int toCheck = nums.length / 2;
        Arrays.sort(nums);
        int x = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (x - nums[i] == 0) {
                count++;
                if (count > toCheck)
                    break;
            } else {
                x = nums[i];
                count = 1;
            }
        }
        return x;
    }
}