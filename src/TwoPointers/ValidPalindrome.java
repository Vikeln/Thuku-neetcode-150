package TwoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {

//        String s = "peep";
//        String s = "peep";
        String s = "A man, a plan, a canal: Panama";

        boolean ispalindrome = isPalindrome(s);


    }

    public static boolean isPalindrome(String s) {
        String original = s.replaceAll(" ","").replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println(original);

        for (int i=0;i<original.length();i++){
            if (!original.substring(i,i+1).equals(original.substring(original.length()-1-i,original.length()-i)))
                return false;
        }
        return true;
    }
}
