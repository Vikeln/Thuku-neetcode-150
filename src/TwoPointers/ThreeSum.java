package TwoPointers;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum1(int[] nums) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(list.stream().sorted().collect(Collectors.toList()), nums[i] + nums[j]);
                }
            }
        }


        HashMap<List<Integer>, Boolean> map1 = new HashMap<>();

        for (Map.Entry<List<Integer>, Integer> set : map.entrySet()) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = set.getKey();
                System.out.println(list);
                System.out.println(i);
                System.out.println(nums[i]);
                if (!list.contains(i) && set.getValue() + nums[i] == 0) {
                    list.add(i);
                    map1.put(list, true);
                }
            }
            System.out.println("out");
        }
        List<List<Integer>> ret = new ArrayList<>();
        ret.addAll(map1.keySet());

        return ret;
    }

//    new and correct
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> solution = new LinkedList<>();

        for (int i=0;i<nums.length;i++){
            if (i==0 || (i>0 && nums[i] != nums[i-1])){
                int target = 0-nums[i];
                int left = i+1;
                int right = nums.length - 1;

                while (left<right){
                    if (nums[left]+nums[right] == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        solution.add(list);

                        while (left< right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while (left< right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if (nums[left] + nums[right] > target){
                        right--;
                    }else{
                        left++;
                    }
                }

            }
        }
        return solution;
    }
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        HashMap<List<Integer>,Boolean> res = new HashMap<>();
        Arrays.sort(nums);

        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length-1;



            while (left<right){

                int threesum = nums[i] + nums[left] + nums[right];
                if (threesum > 0)
                    right -=1;
                else if(threesum < 0)
                    left +=1;
                else{
                    res.merge(Arrays.asList(nums[i] , nums[left] , nums[right]), true,(v1,v3) -> v1);
                    left +=1;
                    while(i>0 && (left<right && nums[i] == nums[i-1]))
                        left +=1;

                }
            }
        }
        System.out.println(res.getKeys());

        return Arrays.asList(res.getKeys());
    }
}