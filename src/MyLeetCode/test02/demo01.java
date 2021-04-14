package MyLeetCode.test02;


import java.util.Stack;

//Definition for a binary tree node.
class STree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode parent;         //双亲节点
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode root;
    TreeNode cur;

    //插入的方式建立二叉查找树（二叉排序树）
    //向二叉排序树中，插入一个kx
    public boolean insert(int kx) {
        boolean res = true;
        if (root == null) {
            //根节点为空，就创建为根节点，返回true
            root = new TreeNode(kx);
            return res;
        }
        //如果根节点不为空，cur作为遍历节点，即标记
        cur = root;
        //记录前一个节点
        TreeNode pa = null;
        while (cur != null && cur.val != kx) {
            pa = cur;
            cur = kx < cur.val ? cur.left : cur.right;
        }
        //如果找到了(&& cur.key == kx)，就不能插入，返回false
        if (cur != null) {
            res = false;
        } else {
            //没有找到，就创建一个新节点
            cur = new TreeNode(kx);
            cur.parent = pa;
            if (cur.val < pa.val) {
                //如果比父节点小，就作为左儿子
                pa.left = cur;
            } else {
                //如果比父节点大，就作为右儿子
                pa.right = cur;
            }
        }
        return res;
    }

    //非递归中序遍历输出二叉排序树
    public void NiceInOrder() {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    //已通过！不过时间复杂度和空间复杂度较高。。
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();  //存放节点的栈
        stack.push(root);

        TreeNode ptr = root.left;       //用于遍历的指针
        TreeNode pa = null;             //ptr的小尾巴

        int tmp = Integer.MAX_VALUE;    //用于比较比较以获得最小的值的变量
        int pre;                    //用于比较比较以获得最小的值的中间变量

        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);

                //指针指向左孩子
                ptr = ptr.left;
            }
            ptr = stack.pop();

            //第一次pa==null,当pa不为空的时候计算差值
            if (pa != null) {
//                pre = Math.abs(pa.val - ptr.val);
                tmp = Math.min(tmp, Math.abs(pa.val - ptr.val));
                System.out.println("pa:" + tmp);
            }

            pa = ptr;

            //指针指向右孩子
            ptr = ptr.right;

            if (ptr == null) {
                continue;
            }
            if (ptr.left == null) {
//                pre = Math.abs(pa.val - ptr.val);
                tmp = Math.min(tmp, Math.abs(pa.val - ptr.val));
                System.out.println("pa2:" + tmp);
                pa = ptr;
                ptr = ptr.right;
            }
        }
        return tmp;
    }


    int pre;
    int ans;

    //优化 依旧是中序遍历，只不过是递归 不知道为啥他这个就执行的很快
    public int minDiffInBSTOpt(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/er-cha-sou-suo-shu-jie-dian-zui-xiao-ju-8u87w/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}

public class demo01 {


    public static void main(String[] args) {
        STree sTree = new STree();
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {1, 15, 17, 20, 24, 29, 35, 36};
//        int[] arr = {1, 15, 80, 90, 95, 97, 99, 98};
        for (int i = 0; i < arr.length; i++) {
            sTree.insert(arr[i]);
        }
        System.out.println("中序遍历结果：");
        sTree.NiceInOrder();

        System.out.println("最小距离为：" + sTree.minDiffInBSTOpt(sTree.root));


    }
}
