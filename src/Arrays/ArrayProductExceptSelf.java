package Arrays;

public class ArrayProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] ret1 = productExceptSelf3(nums);
        System.out.println(Arrays.asList(ret1));

    }
    //    O(n) using a hashmap. Still not the best impl
    public static int[] productExceptSelf1(int[] nums) {
        int[] results = new int[nums.length];
        HashMap<Integer, Integer> productMap = new HashMap<>();
        HashMap<Integer, Integer> productMap1 = new HashMap<Integer,Integer>();

        for (int i=0;i<nums.length;i++) {
            productMap.put(i,nums[i]);
            productMap1.put(i,nums[i]);
        }


        productMap.forEach((key, value) -> productMap1.merge(key, productMap.entrySet().stream().filter(set->!set.getKey().equals(key)).map(set->set.getValue()).collect(Collectors.toList()).stream().filter(a->a!=value).reduce(1, (a, b) -> a * b), Integer::max));
        System.out.println("productMap: " + productMap);
        System.out.println("productMap1: " + productMap1);

        int index = 0;
        for (Map.Entry<Integer, Integer> mapEntry : productMap1.entrySet()) {
            results[index] = mapEntry.getValue();
            ++index;
        }

        return results;
    }
//    Correct implementation
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Perform Prefix product operation by traversing Left -> Right
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        for (int num = 0; num < result.length; num++)
            System.out.println(result[num]);

        // Perform Postfix product operation by traversing Right -> Left
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }

    //    brute
    public static int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int product=1;
            for (int j=0;j<nums.length;j++){
                if (i!=j)
                    product*= nums[j];
            }
            results[i]=product;
        }
        return results;
    }
}