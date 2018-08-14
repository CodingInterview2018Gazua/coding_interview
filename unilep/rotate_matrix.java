import java.io.PrintStream;

public class Main {

   static PrintStream ps = System.out;
   
   public static void rotateMatrix(int[][] arr) {
      
      final int N = arr.length;
      final int half_N = N / 2;
      final int realN = N-1;
      
      for(int i=0; i<half_N; i++) {
         final int jLen = N / (i + 1) - 1;
         for(int j=0; j<jLen; j++) {
            
            Node top = new Node(i, i+j);
            Node right = new Node(j+i, realN-i);
            Node bottom = new Node(realN-i, realN-j-i);
            Node left = new Node(realN-j-i, i);
            
            int temp = arr[top.x][top.y];
            arr[top.x][top.y] = arr[left.x][left.y];
            arr[left.x][left.y] = arr[bottom.x][bottom.y];
            arr[bottom.x][bottom.y] = arr[right.x][right.y];
            arr[right.x][right.y] = temp;

         }
      }
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<N; j++) {
            ps.printf("%3d", arr[i][j]);
         }
         ps.println();
      }
      
   }
   
   public static void main(String[] args) {
      
      /**
       * 13  9  5  1
       * 14 10  6  2
       * 15 11  7  3
       * 16 12  8  4
       */
      rotateMatrix(
            new int[][]
               {
                  {1,2,3,4},
                  {5,6,7,8},
                  {9,10,11,12},
                  {13,14,15,16}
               });
      
      ps.println();
      
      /**
       * 7 4 1
       * 8 5 2
       * 9 6 3
       */
      rotateMatrix(
            new int[][]
               {
                  {1,2,3},
                  {4,5,6},
                  {7,8,9}
               });
   }
   
}

class Node {
   int x;
   int y;
   Node(int x, int y) {
      this.x = x;
      this.y = y;
   }
   @Override
   public String toString() {
      return x + " : " + y;
   }
