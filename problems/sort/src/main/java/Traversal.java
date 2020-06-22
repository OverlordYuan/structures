import java.util.List;
import java.util.Stack;

public class Traversal {
    public static void preoder_stack(TreeNode root){
        if(root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);
            }
        }
    }

    public static void inorderTraversal(TreeNode root) {
        if(root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
                while (current != null || !stack.isEmpty()) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    System.out.print(current.val);
                    current = current.right;
                }
             }
        }
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (!stack.isEmpty() && current == stack.peek()) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            } else {
                System.out.print(current.val);
            }
        }
    }
}
