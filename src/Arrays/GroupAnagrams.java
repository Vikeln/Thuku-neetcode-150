package Arrays;

public class GroupAnagrams {
    public static void main(String[] args) {

//        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] list = {"eat"};

        List<List<String>> rturn = groupAnagrams(list);
        for (List<String> list1 : rturn) {
            System.out.println("Line ");
            for (String string : list1) {
                System.out.println("value " + string);
            }
        }

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> foundValues = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> anagrams = new ArrayList<>();

            if (!foundValues.containsKey(strs[i])) {
                anagrams.add(strs[i]);

                foundValues.put(strs[i],1);

                for (int j = 0; j < strs.length; j++) {
                    if (i!=j && isAnagram(strs[i], strs[j])) {
                        foundValues.put(strs[j], 1);
                        anagrams.add(strs[j]);
                    }
                }
            }

            list.add(anagrams);
        }
        return list;
    }

    private static boolean isAnagram(String str, String matching) {
        if (str.equals(matching)) return true;
        if (str.length() != matching.length()) return false;

        String[] first = str.split("");
        String[] second = matching.split("");

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        Map<String, Integer> strIntegerMap = new HashMap<>();

        for (int i = 0; i < first.length; i++) {
            stringIntegerMap.merge(first[i], 1, Integer::sum);
            strIntegerMap.merge(second[i], 1, Integer::sum);
        }

        for (String leter : stringIntegerMap.keySet())
            if (!stringIntegerMap.get(leter).equals(strIntegerMap.get(leter))) return false;

        return true;
    }
}