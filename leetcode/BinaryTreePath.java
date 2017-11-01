import java.util.*;
public class BinaryTreePath {
  public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, "", res);
        return res;
    }

    public void binaryTreePaths(TreeNode root, String path, List<String> res) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            res.add(path + root.val);
        } else {
            binaryTreePaths(root.left, path + root.val +  "->", res);
            binaryTreePaths(root.right, path + root.val +  "->", res);
        }
    }
}
