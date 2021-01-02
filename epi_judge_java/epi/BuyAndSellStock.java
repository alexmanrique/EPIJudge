package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    // TODO - you fill in here.
    double maxProfit = 0.0;
    double min = Double.MAX_VALUE;
    for(Double price:prices){
      maxProfit = Math.max(maxProfit, price-min);
      min = Math.min(min, price);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
