import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(findSingleNumber(new int[] {1,1,2,2,3,4,4,5,5,}));
    }

    static int findSingleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = nums[i];
            if (count.containsKey(result))
                count.replace(result, count.get(result) + 1);
            else
                count.put(result, 1);
        }

        return count.entrySet().stream().parallel()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey()).findAny().get();
    }

    public static int singleNumberBest(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans^nums[i];
        }
        return ans;
    }
}