public class Main {

   public static void main(String[] args) {

      Node<Integer> root = new Node<>();
      root.addLastNode(1);
      root.addLastNode(3);
      root.addLastNode(2);
      root.addLastNode(4);
      root.addLastNode(5);
      root.addLastNode(1);
      root.addLastNode(6);
      root.addLastNode(7);
      root.addLastNode(2);
      root.addLastNode(9);
      root.print();

      root.divideByValue(5);
      root.print();

      root = new Node<>();
      root.addLastNode(5);
      root.addLastNode(2);
      root.addLastNode(3);
      root.addLastNode(1);
      root.addLastNode(4);
      root.print();

      root.divideByValue(3);
      root.print();

   }

}

class Node<T> {
   
   private Node<T> next;
   private T data;
   private boolean root;
   private Node<T> left;
   private Node<T> right;

   public Node() {
      this.root = true;
   }

   public Node(T data) {
      this.data = data;
   }

   public void addLastNode(Node<T> node) {
      Node<T> temp = this;
      while(temp.next != null) {
         temp = temp.next;
      }
      temp.next = node;
   }

   public void addLastNode(T data) {
      Node<T> newNode = new Node<>(data);
      Node<T> temp = this;
      while(temp.next != null) {
         temp = temp.next;
      }
      temp.next = newNode;
   }

   public void divideByValue(T value) {
      Node<T> temp = this;
      left = new Node<T>();
      right = new Node<T>();
      
      while(temp != null) {
         if(!temp.root) {
            if((int)temp.data < (int) value) {
               left.addLastNode(temp.data);
            } else {
               right.addLastNode(temp.data);
            }
         }
         temp = temp.next;
      }

      this.next = this.left;
      temp = left;
      while(temp.next != null) temp = temp.next;
      temp.next = right;
   }

   public void print() {
      Node<T> lastPointer = this;
      System.out.print("[ ");
      while(lastPointer.next != null) {
         lastPointer = lastPointer.next;
         if(!lastPointer.root) System.out.print(lastPointer.data + " ");
      }
      System.out.println("]");

   }

}