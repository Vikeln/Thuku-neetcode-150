package Arrays;

public class LongestConsecutive {
    public static void main(String[] args) {

//        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        int ret1 = longestConsecutive1(nums);

        System.out.println(ret1);

    }

//    best solution
    private static int longestConsecutive1(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int m : nums)
            map.put(m,true);

        int longest=0;

        for (int m : nums){
            if (!map.get(m))
                continue;
            map.put(m,false);
            int currentLongest =1;
            int left = m-1;
            int right = m+1;



            while(map.containsKey(left)){
                --left;
                currentLongest++;
            }
            while (map.containsKey(right)){
                ++right;
                currentLongest++;
            }
            longest = Math.max(longest, currentLongest);

        }

        return longest;
    }
    private static int longestConsecutive(int[] nums) {

        if (nums.length < 1) return 0;
        Arrays.sort(nums);

        int longest = 1;
        int longest1 = 1;
        for (int i = 0; i < nums.length; i++) {

            if (i+1< nums.length && nums[i]+1 == nums[i + 1])
                ++longest1;
            else if (i>0 && i+1<nums.length && nums[i]+1 == nums[i + 1])
                continue;
            else
                longest1 = 0;

            if (i==nums.length-1 && nums[i]-1 == nums[i - 1]) {
                ++longest;
            }

            longest = Math.max(longest, longest1);
        }
        return longest;
    }
}