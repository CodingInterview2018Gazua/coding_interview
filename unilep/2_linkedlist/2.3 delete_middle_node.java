public class Main {

   public static void main(String[] args) {

      Node<Integer> root = new Node<>();
      root.addLastNode(1); /** [ 1 ] **/
      root.addLastNode(3); /** [ 1 3 ] **/
      root.addLastNode(2); /** [ 1 3 2 ] **/
      root.addLastNode(4); /** [ 1 3 2 4 ] **/

      /** It will be print [ 1 3 2 4 ] **/
      root.print(); 

      root.deleteNode(3, root); /** [ 1 2 4 ] **/

      /** It will be print [ 1 2 4 ] **/
      root.print();
      root.addLastNode(5); /** [ 1 2 4 5 ] **/
      root.deleteNode(1, root); /** [ 2 4 5 ] **/

      /** It will be print [ 2 4 5 ] **/
      root.print();

      root.addLastNode(1); /** [ 2 4 5 1 ] **/
      root.deleteNode(1, root); /** [ 2 4 5 ] **/

      /** It will be print [ 2 4 5 ] **/
      root.print();

      root.deleteNode(10, root);
      
      /** It will be print [ 2 4 5 ] **/
      root.print();

   }

}

class Node<T> {

   private Node<T> next;
   private T data;
   private boolean root;

   public Node() {
      this.root = true;
   }

   public Node(T data) {
      this.data = data;
   }

   public void addLastNode(T data) {
      Node<T> newNode = new Node<>(data);
      Node<T> temp = this;
      while(temp.next != null) {
         temp = temp.next;
      }
      temp.next = newNode;
   }

   public void deleteNode(T data, Node<T> pre) {
      if(this.root) {
         if(this.next == null) return;
         this.next.deleteNode(data, this);
         return;
      }

      if(this.data.equals(data)) {
         pre.next = this.next;
         return;
      }

      if(this.next != null) {
         this.next.deleteNode(data, this);
      }

   }

   public void print() {
      Node<T> lastPointer = this;
      System.out.print("[ ");
      while(lastPointer.next != null) {
         lastPointer = lastPointer.next;
         if(lastPointer.data != null) System.out.print(lastPointer.data + " ");
      }
      System.out.println("]");

   }

}