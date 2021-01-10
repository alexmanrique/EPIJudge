package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class BuyAndSellStockTwice {
  @EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    // TODO - you fill in here.
    double maxProfit = 0.0;
    List<Double> firstBuySell = new ArrayList<>();

    int n = prices.size();
    double minPriceSeenSoFar = Double.MAX_VALUE;

    for(int i=0; i<n; ++i){
      minPriceSeenSoFar = Math.min(minPriceSeenSoFar, prices.get(i));
      maxProfit = Math.max(maxProfit, prices.get(i)-minPriceSeenSoFar);
      firstBuySell.add(maxProfit);
    }

    double maxPriceSeenSoFar = Double.MIN_VALUE;
    for(int j=n-1; j>0 ;--j){
      maxPriceSeenSoFar = Math.max(maxPriceSeenSoFar, prices.get(j));
      maxProfit = Math.max(maxProfit, maxPriceSeenSoFar - prices.get(j)+firstBuySell.get(j));
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
