package Tree;

import java.util.*;

public class TravelIteration {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.constuctTree(1, 2, 3, 4, 5, 6, -1, 7, -1, 8, 9);
        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
        System.out.println(preOrder2(root));
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    public static List<Integer> preOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        Collections.reverse(res);
        return res;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }


    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root, prev = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == prev) {
                res.add(node.val);
                prev = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }

        }
        return res;
    }


}
