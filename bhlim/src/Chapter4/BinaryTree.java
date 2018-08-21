package Chapter4;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree<T> {
	TreeNode<T> root;
	int count = 0;
	int depth = 0;
	Map<Integer, Integer> nodeCounter = new HashMap<>();

	public TreeNode<T> createNode(T data, TreeNode<T> bt1, TreeNode<T> bt2) {
		TreeNode<T> root = new TreeNode<>(data);
		root.left = bt1;
		root.right = bt2;

		return root;
	}

	public void preorder(TreeNode<T> root, int depth) {
		if (root != null) {
			root.depth = depth;
			System.out.printf("depth = %d data = %s\n", depth, root.data.toString());

			preorder(root.left, depth + 1);
			preorder(root.right, depth + 1);
			count++;

			if (this.depth <= depth)
				this.depth = depth;

			depth++;
		}
	}

	public void calculateNodeAndDepth(TreeNode<T> root, int depth) {
		if (root != null) {
			if (nodeCounter.containsKey(depth)) {
				nodeCounter.put(depth, nodeCounter.get(depth) + 1);
			} else {
				nodeCounter.put(depth, 1);
			}

			root.depth = depth;

			calculateNodeAndDepth(root.left, depth + 1);
			calculateNodeAndDepth(root.right, depth + 1);
			count++;

			if (this.depth <= depth)
				this.depth = depth;

			depth++;
		}
	}

	public boolean isBalanced() {
		int lastDepthCount = nodeCounter.get(depth);
		return lastDepthCount == Math.pow(2, depth);
	}
}
