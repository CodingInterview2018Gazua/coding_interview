package Chapter4;

public class Test180816 {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		
//		TreeNode<Integer> n10 = tree.createNode(10, null, null);
//		TreeNode<Integer> n9 = tree.createNode(9, null, null);
//		TreeNode<Integer> n8 = tree.createNode(8, null, null);
		TreeNode<Integer> n7 = tree.createNode(7, null, null);
		TreeNode<Integer> n6 = tree.createNode(6, null, null);
		TreeNode<Integer> n5 = tree.createNode(5, null, null);
		TreeNode<Integer> n4 = tree.createNode(4, null, null);
		TreeNode<Integer> n3 = tree.createNode(3, n7, null);
		TreeNode<Integer> n2 = tree.createNode(2, n5, n6);
		TreeNode<Integer> n1 = tree.createNode(1, n3, n4);
		TreeNode<Integer> n0 = tree.createNode(0, n1, n2);
		
		tree.root = n0;
		//tree.preorder(tree.root, 0);
		
		tree.calculateNodeAndDepth(tree.root, 0);
		System.out.println(tree.nodeCounter);
		System.out.println(tree.isBalanced());
		
		//System.out.printf("node count = %d\n", tree.count);
	}
}
