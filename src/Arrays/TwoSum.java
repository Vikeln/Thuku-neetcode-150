package Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum1(nums, target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

        ans = twoSum(nums, target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> fuondValues = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (fuondValues.containsKey(remainder))
                return new int[]{fuondValues.get(remainder), i};
            fuondValues.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target)
                continue;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && target - nums[i] == nums[j]) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }
}