# neetcode-150
neetcode-150

### Arrays & Hashing 07062022
- Contains duplicate
- Valid Anagram - Learnt about HashMap merging, where you add a remappingFunction to a hasmap.
  The Java HashMap merge() method inserts the specified key/value mapping to the hashmap if the specified key is already not present. If the specified key is already associated with a value, the method replaces the old value with the result of the specified function 
  
      hashmap.merge(key, value, remappingFunction)
Example

      hashmap.merge("key", 1, Integer::sum) - remapping function does a sum of existing value at key and the new vakue if the key is already found

- Two Sum - Return indices of values in an array who's sum would be targeted value; To cater for O(n) implemetation, use a hashmap to store values not found, then be checking whether the remainder of subtraction of current num is in hashmap
  
- Group Anagrams - Create a hash for each word and group them together if they have the same hash. 
Method can be applied for valid anagrams too
  ```
  for(String s: strs){
            int checksum=0;
            for(char c: s.toCharArray()){
                checksum += (int) c;
            }

            if(map.get(checksum)==null){
                map.put(checksum, new ArrayList<>());
            }
            map.get(checksum).add(s);
  ```
  
- TopKFrequency - This problem test for knowledge of priority queues, where values are stored by priority, ie highest to lowest, but does not replace values.
The problem uses learnings from merging map entries if the keys match
```

PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() -
                e2.getValue());

        for(Map.Entry<Integer, Integer> entry : frequence.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
```

- ArrayProductExceptSelf - This problem emphasizes traversing an array from LHS and also from RHS. The product of elements of an array can be gotten through multiplying proudct of values from L->R and R->L

- LongestConsecutive - This problem can be easily solved using a hashmap. Put all values into the hashmap as keys, values as booleans which are toogled on check of each, then loop through the objects checking if the left and right values (-1 and +1 ) exist in the hashmap