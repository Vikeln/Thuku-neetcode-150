package Arrays;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] list = {"eat"};

        List<List<String>> rturn = groupAnagrams(list);
        List<List<String>> rturn2 = groupAnagrams2(list);
        List<List<String>> rturn1 = groupAnagrams1(list);

        System.out.println("rturn");
        System.out.println(Arrays.asList(rturn));
        System.out.println("rturn2");
        System.out.println(Arrays.asList(rturn2));
        System.out.println("rturn1");
        System.out.println(Arrays.asList(rturn1));


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
            if (!anagrams.isEmpty())
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

    // BEST
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0) return res;
        HashMap<String, List<String>> map = new HashMap();
        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }
            String str=new String(hash);

            if(map.get(str)==null){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        res.addAll(map.values());
        return res;
    }


    // checksums has an inherent problem. issue is the checksum can be gotten by adding different values i.e 1+5+4=10 and also 3+3+4=10
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0) return res;
        HashMap<Integer, List<String>> map = new HashMap();
        for(String s: strs){
            int checksum=0;
            for(char c: s.toCharArray()){
                checksum += (int) c;
            }

            if(map.get(checksum)==null){
                map.put(checksum, new ArrayList<>());
            }
            map.get(checksum).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}