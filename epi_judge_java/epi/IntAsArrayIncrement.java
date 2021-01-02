package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    // TODO - you fill in here.
    int n = A.size()-1;
    A.set(n, A.get(n)+1);
    for(int j=n; j>0 && A.get(j)==10; j--){
      A.set(j, 0);
      A.set(j-1, A.get(j-1)+1);
    }
    if(A.get(0)==10){
      A.set(0, 1);
      A.add(0);
    }
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
