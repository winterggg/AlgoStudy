package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelRecursion {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.constuctTree(1, 2, 3, 4, 5, 6, -1, 7, -1, 8, 9);
        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
        System.out.println(postOrder2(root));
    }

    public static List<Integer> preOrder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        preOrder(node, res);
        return res;
    }

    public static void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    public static List<Integer> inOrder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        inOrder(node, res);
        return res;
    }

    public static void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }

    public static List<Integer> postOrder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        postOrder(node, res);
        return res;
    }

    public static void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }


    public static List<Integer> postOrder2(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        postOrder2(node, res);
        Collections.reverse(res);
        return res;
    }

    public static void postOrder2(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        postOrder2(node.right, res);
        postOrder2(node.left, res);
    }


}
