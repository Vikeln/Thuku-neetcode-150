package Arrays;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {

        String s = "peek";

        String t = "keap";
        boolean isAnagram = isAnagram2(s, t);

        System.out.println("isAnagram");
        System.out.println(isAnagram);
    }

    public static boolean isAnagram2(String s, String t) {

        if (s.equals(t))
            return true;
        if (t.length()!=s.length())
            return false;

        Map<Character, Integer> sLetterPositions = new HashMap<>();
        Map<Character, Integer> tLetterPositions = new HashMap<>();

        for (int i=0;i<s.length();i++){
            sLetterPositions.merge(s.charAt(i),1,Integer::sum);
            tLetterPositions.merge(t.charAt(i),1,Integer::sum);
        }

        for (Character letter : sLetterPositions.keySet()) {
            if (!sLetterPositions.get(letter).equals(tLetterPositions.get(letter))) return false;
        }
        return true;
    }

//    using hashes developed for each word.matching hashes give anagrams
 public static boolean isAnagram3(String s, String t) {

        if (s.equals(t))
            return true;
        if (t.length()!=s.length())
            return false;

        char[] firstchar = new char[26];
        for (char c : s.toCharArray())
            firstchar[c-'a']++;

     char[] secondchar = new char[26];
        for (char c : t.toCharArray())
            secondchar[c-'a']++;
        if (new String(firstchar).equals(new String(secondchar)))
        return true;
        return false;
    }


}