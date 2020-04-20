package easy.tree;

public class PathSum437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



//    因为问题要求是可以在树的任意节点起止，所以
    //    这个函数代表 从root节点作为入口，但是不一定要把root作为路径起始点
//    全面判断从树的任意节点开始，有没有成立的路径
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root.left,sum) +pathSum(root.right, sum)
                + pathSumTwo(root, sum) ;
    }


//    这个函数是，一定要把给的node节点算到路径里面去
    public int pathSumTwo(TreeNode node, int sum){
        if (node == null) return 0;
        int cnt = pathSumTwo(node.left, sum-node.val) + pathSumTwo(node.right, sum - node.val);
        if (node.val == sum) cnt++;
        return cnt;
    }
}
