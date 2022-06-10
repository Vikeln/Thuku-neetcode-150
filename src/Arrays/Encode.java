package Arrays;

public class Encode {
    public static void main(String[] args) {

        String ret1 = encode(Arrays.asList("lint","code","love","you"));

        System.out.println(ret1);
        System.out.println(decode(ret1));

    }

    public static String encode(List<String> strs) {
        // write your code here
        return strs.stream().collect(Collectors.joining(":;"));
    }

    public static List<String> decode(String str) {
        // write your code here
        return Arrays.asList(str.split(":;").clone());
    }
}