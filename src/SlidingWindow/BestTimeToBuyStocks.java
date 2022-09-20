package SlidingWindow;

public class BestTimeToBuyStocks {

    public static void main(String[] args) {
        int[] ints = new int[]{1,7,2,3,5,6,2};
        int maxProfit = maxProfit(ints);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buy = Integer.MAX_VALUE;
        for (int price : prices){
            if(price<buy)
                buy = price;
            else
                maxProfit = Math.max(maxProfit, price - buy);
        }
        return maxProfit;
    }
}