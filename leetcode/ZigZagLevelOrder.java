import java.util.*;
public class ZigZagLevelOrder {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(root, res, 0);
        return res;
    }

    public void zigzagLevelOrder(TreeNode node, List<List<Integer>> res, int height) {
        if(node == null) {
            return;
        }
        if(height == res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> lastList = res.get(height);
        if(height % 2 == 1) {
            lastList.add(0, node.val);
        } else {
            lastList.add(node.val);
        }
        zigzagLevelOrder(node.left, res, height+1);
        zigzagLevelOrder(node.right, res, height+1);
    }
}
