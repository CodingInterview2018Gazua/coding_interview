package Chapter4;

public class BinaryTree<T> {
	TreeNode<T> root;
	int count = 0;
	
	public TreeNode<T> createNode(T data, TreeNode<T> bt1, TreeNode<T> bt2) {
		TreeNode<T> root = new TreeNode<>(data);
		root.left = bt1;
		root.right = bt2;

		return root;
	}
	
	public void preorder(TreeNode<T> root) {
		if (root != null) {
			System.out.println(root.data.toString());
			preorder(root.left);
			preorder(root.right);
			count++;
		}
	}
}
