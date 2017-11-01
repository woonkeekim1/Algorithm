public class KthSmallestElementInBST {
  public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if(count + 1 == k) {
            return root.val;
        } else if(count >= k) {
            return kthSmallest(root.left, k);
        }
        return kthSmallest(root.right, k - count - 1);
    }

    public int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }
}
