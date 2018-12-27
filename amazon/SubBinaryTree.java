/**
 * 判断一个二叉树是不是另一个二叉树的子树
2. 改进时间复杂度直到小于O(mn)
3. 怎样序列化一个二叉树
4. 基于上述序列化的算法，写出反序列化的代码
https://leetcode.com/problems/subtree-of-another-tree/
good reference: https://www.youtube.com/watch?v=nVjxiBieE1w
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

}

public class SubBinaryTree{
    public boolean isSubTree(TreeNode t1, TreeNode t2){
        if(t2 == null ) return true;
        if (t1==null) return false;
        if (sameTree(t1, t2)) return true;
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }
    public boolean sameTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 ==null) return false;
        if(t1.val == t2.val) 
            return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
        return false;
    }
/**
     * Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
     * @param args [description]
*/
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        SubBinaryTree subBinaryTree = new SubBinaryTree();
        boolean res = subBinaryTree.isSubTree(root, root2);
        System.out.println("res = " + res);

    }
}