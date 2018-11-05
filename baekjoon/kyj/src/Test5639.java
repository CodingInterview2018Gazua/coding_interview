
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5639{
    public static void main(String[] args) throws IOException {
        /**
         * description : Binary search tree를 Pre order 한 결과를 받아서 Post order 한 결과를 출력하라.
         * solution : Pre order 의 결과로 Tree를 만들고 다시 Post order 한 결과를 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();

        String st;
        while(  (st = br.readLine()) != null && !st.equals("") ){
            int value = Integer.parseInt(st);
            tree.addNode(value);
        }

        tree.postOrder(tree.root);
    }
}


class Node {
    public int value;
    public Node left;
    public Node right;
}

class Tree {

    public Node root;

    public void addNode(int value) {
        if (root == null) {
            Node node = new Node();
            node.value = value;
            root = node;
        } else {
            addNode(value, root);
        }
    }

    public void addNode(int value, Node root) {
        if (value <= root.value) {

            if (root.left == null) {
                Node node = new Node();
                node.value = value;
                root.left = node;
            } else {
                addNode(value, root.left);
            }

        } else {

            if (root.right == null) {
                Node node = new Node();
                node.value = value;
                root.right = node;
            } else {
                addNode(value, root.right);
            }
        }
    }

    public void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}
