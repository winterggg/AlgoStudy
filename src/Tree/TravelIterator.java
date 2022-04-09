package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TravelIterator {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constuctTree(1, 2, 3, 4, 5, 6, -1, 7, -1, 8, 9);
        preOrderIterator preOrderIterator = new preOrderIterator(root);
        while (preOrderIterator.hasNext()) {
            System.out.println(preOrderIterator.next());
        }
    }


    static class preOrderIterator  {
        TreeNode node;
        Deque<TreeNode> stack;

        public preOrderIterator(TreeNode root) {
            node = root;
            stack = new ArrayDeque<TreeNode>();
        }

        public boolean hasNext() {
            return !(stack.isEmpty() && node == null);
        }

        public Integer next() {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            int ret = node.val;
            node = node.right;
            return ret;
        }
    }
}
