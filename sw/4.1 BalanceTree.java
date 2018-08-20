package Tree;

/*
4.1 주어진 이진 트리가 균형 이진 트리인지 판별하는 함수를 구현하라.
       이 문제에서 이진 트리는 어떤 노드의 두 자식 트리 깊이가 하나 이상 차이나지 않는 트리이다.
*/

public class BinaryTree{
	private int data;
	private BinaryTree left;
	private BinaryTree right;
	
	public BinaryTree(int data) {
		this.left=null;
		this.right=null;
		this.data=data;
	}
	public void makeLeft(BinaryTree left) {
		if(this.left!=null)
			this.left=null;
		this.left=left;
	}
	public void makeRight(BinaryTree right) {
		if(this.right!=null)
			this.right=null;
		this.right=right;
	}
	public int getData() {
		return this.data;
	}
	public BinaryTree getLeft() {
		return this.left;
	}
	public BinaryTree getRight() {
		return this.right;
	}
	public int getHeight(BinaryTree root) {
		int height=0;
		if(root!=null) {
			int left=getHeight(root.left);
			int right=getHeight(root.right);
			int maxHeight=Math.max(left,right);
			height=maxHeight+1;
		}
		return height;
	}
	public int diffHeight(BinaryTree root) {
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		int diff=left-right;
		return diff;
	}
	public boolean checkBalance(BinaryTree root) {
		if(Math.abs(root.diffHeight(root))!=0)
			return false;
		else
			return true;
	}
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		BinaryTree tr2 = new BinaryTree(2);
		BinaryTree tr3 = new BinaryTree(3);
		BinaryTree tr4 = new BinaryTree(4);
		
		root.makeLeft(tr2);
		root.makeRight(tr3);
		tr2.makeLeft(tr4);
		System.out.println(root.checkBalance(root));
		System.out.println(root.getLeft().getData());
		System.out.println(root.getRight().getData());
	}
}

