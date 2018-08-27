public class Main {


   public static void main(String[] args) {

      Node charRoot = new Node();
      charRoot.addLastNode('a');
      charRoot.addLastNode('b');
      charRoot.addLastNode('c');
      charRoot.addLastNode('b');
      charRoot.addLastNode('d');
      charRoot.addLastNode('a');
      charRoot.print();

      /**
       * [ a b c b d a ] -> b
       */
      charRoot.searchKthNode(3);

      Node intRoot = new Node();
      intRoot.addLastNode(2);
      intRoot.addLastNode(1);
      intRoot.addLastNode(3);
      intRoot.addLastNode(3);
      intRoot.addLastNode(1);
      intRoot.print();

      /**
       * [ 2 1 3 3 1 ] -> 2
       */
      intRoot.searchKthNode(5);

      /**
       * it will be throw an exception.
       * [Exception Message] -> failed : searchKthNode was 6 but linkedlist size was 5
       */
      intRoot.searchKthNode(6);

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
    * Search Kth-Node(1-based)
    * Time Complexity: O(N)
    * Space Complexity: O(N)
    * @param index      kth
    */
   public void searchKthNode(int index) {
      int size = 0;
      Node lastPointer = this;
      while(lastPointer.next != null) {
         lastPointer = lastPointer.next;
         size++;
      }

      if(size < index) {
         throw new RuntimeException("failed : searchKthNode was " + index + " but linkedlist size was " + size);
      }

      Node[] nodeArray = new Node[size + 1];
      size = 0;
      lastPointer = this;
      while(lastPointer.next != null) {
         nodeArray[size++] = lastPointer;
         lastPointer = lastPointer.next;
      }
      nodeArray[size] = lastPointer;
      System.out.printf("found Index: " + index + " data: " + (lastPointer.data >= 'a' ? "%c\n" : "%d\n"), nodeArray[size - index + 1].data);
   }



   public void print() {
      Node lastPointer = this;
      System.out.print("[ ");
      while(lastPointer.next != null) {
         lastPointer = lastPointer.next;
         System.out.printf((lastPointer.data >= 'a' ? "%c" : "%d") + " ", lastPointer.data);
      }
      System.out.println("]");
   }

}