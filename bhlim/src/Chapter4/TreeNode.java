package Chapter4;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
    
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public Object getData(){
        return this.data;
    }
}
