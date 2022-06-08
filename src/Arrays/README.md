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
  
- TopKFrequency - This probem test for knowledge of priority queues, where values are stored by priority, ie highest to lowest, but does not replace values.