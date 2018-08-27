public class Main {

   public static void main(String[] args) {
      Node charRoot = new Node();
      charRoot.addLastNode('a');
      charRoot.addLastNode('b');
      charRoot.addLastNode('c');
      charRoot.addLastNode('b');
      charRoot.addLastNode('d');
      charRoot.addLastNode('a');
      System.out.println("Not Unique LinkedList");
      charRoot.print();

      System.out.println("make Unique LinkedList");
      charRoot.makeUniqueLinkedList(0, charRoot, 'a');
      charRoot.print();

      Node intRoot = new Node();
      intRoot.addLastNode(2);
      intRoot.addLastNode(1);
      intRoot.addLastNode(3);
      intRoot.addLastNode(3);
      intRoot.addLastNode(1);
      System.out.println("Not Unique LinkedList");
      intRoot.print();
      
      System.out.println("make Unique LinkedList");
      intRoot.makeUniqueLinkedList(0, intRoot, 0);
      intRoot.print();
   }

}

class Node {

   private Node next;
   private int data;

   public Node() { }

   public Node(int data) {
      this.data = data;
   }

   public void addLastNode(int newData) {
      Node newNode = new Node(newData);
      Node lastPointer = this;
      while(lastPointer.next != null) {
         lastPointer = lastPointer.next;
      }
      lastPointer.next = newNode;
   }

   /**
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    * @param status   bitset
    * @param preNode   이전노드
    * @param diff      init value
    */
   public void makeUniqueLinkedList(int status, Node preNode, int diff) {
      if(data == 0) {
         if(next != null) {
            next.makeUniqueLinkedList(status, preNode, diff);
         }
         return;
      }

      /** status에 c가 이미 있다. **/
      if((status & (1 << (data - diff))) > 0) {
         preNode.next = next;
         if(next != null) next.makeUniqueLinkedList(status, preNode, diff);
         return;
      }
      if(next != null) next.makeUniqueLinkedList(status | (1 << (data - diff)), this, diff);
   }

   public void print() {
      Node lastPointer = this;
      System.out.print("[ ");
      while(lastPointer.next != null) {
         lastPointer = lastPointer.next;
         System.out.printf((lastPointer.data >= 'a' ? "%c" : "%d") + " ", lastPointer.data);
      }
      System.out.println("]\n");

   }

}