package Arrays;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};

        int k = 2;

        int[] ret = topKFrequent(nums, k);
        for (int num = 0; num < ret.length; num++)
            System.out.println(ret[num]);

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequence = new HashMap<>();

        int[] result = new int[k];

        for (Integer num : nums)
            frequence.merge(num, 1, Integer::sum);

//        using a priority queue makes sure that the values are store by priority, that is the higher value of the count

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() -
                e2.getValue());

//        Adding the count values to the queue upto the limit of values needed
        for(Map.Entry<Integer, Integer> entry : frequence.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Let's create a list of top k elements from the priority queue
        int c = 0;
        while (!minHeap.isEmpty()) {
            result[c] = minHeap.poll().getKey();
            ++c;
        }

        return result;

    }
}