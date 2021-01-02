package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeABst {
  @EpiTest(testDataFile = "is_tree_a_bst.tsv")

  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    return isBinaryTreeBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean isBinaryTreeBSTHelper(BinaryTreeNode<Integer> tree, Integer min, Integer max){
    if (tree == null){
      return true;
    }
    else if(tree.data.compareTo(min) < 0 || tree.data.compareTo(max) > 0) {
       return false;
    }
    else {
      return isBinaryTreeBSTHelper(tree.left, min, tree.data) && isBinaryTreeBSTHelper(tree.right, tree.data, max);
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
