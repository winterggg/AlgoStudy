package Tree;

public class TreeUtils {
    private TreeUtils() {
        throw new AssertionError("No instances");
    }


    public static TreeNode constuctTree(int... arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] == null) continue;
            if (2 * i + 1 < arr.length) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if (2 * i + 2 < arr.length) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }

    public static void main(String... args) {
        System.out.println(1);
    }
}