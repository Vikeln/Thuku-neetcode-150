package TwoPointers;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{2,7,11,15};

        int[] indices = twoSum(nums);
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> numsAndPositions = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if (numsAndPositions.containsKey(target-numbers[i]))
                return new int[]{i+1,numsAndPositions.get(target-numbers[i])};
            else
                numsAndPositions.put(numbers[i],i+1);
        }

    }
}