/**
    Single Element in a Sorted Array
    --------------------------------
    You are given a sorted array consisting of only integers where every element appears exactly twice, 
    except for one element which appears exactly once.
    Find this single element that appears only once.
    
    Example 1:
        Input: [1,1,2,3,3,4,4,8,8]
        Output: 2
    
    Example 2:
        Input: [3,3,7,7,10,11,11]
        Output: 10

    Note: Your solution should run in O(log n) time and O(1) space.
 */
 class FindSingleElement {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j])
                return nums[i];
            i += 2;
            j += 2;
        }
        return nums[i];
    }
}