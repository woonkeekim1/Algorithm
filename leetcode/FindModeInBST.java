public class FindModeInBST {
  int prevVal = 0;
  int prevCount = 0;
  int maxCount = 0;
  /*
  * Given a binary search tree (BST) with duplicates, find all the mode(s)
  * (the most frequently occurred element) in the given BST.
  * input: TreeNode
  * output: int[]
  */
  public int[] findMode(TreeNode root) {
      if(root == null) {
          return new int[0];
      }
      List<Integer> list = new ArrayList<>();
      traverse(root, list);
      int[] res = new int[list.size()];
      for(int i = 0; i < list.size(); i++) {
          res[i] = list.get(i);
      }
      return res;
  }
  public void traverse(TreeNode node, List<Integer> list) {
      if(node == null) {
          return;
      }
      traverse(node.left, list);
      if(node.val == prevVal) {
          prevCount++;
      } else {
          prevCount = 1;
      }

      if(prevCount > maxCount) {
          list.clear();
      }
      if(prevCount >= maxCount) {
          list.add(node.val);
          maxCount = prevCount;
      }
      prevVal = node.val;
      traverse(node.right, list);
  }
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
