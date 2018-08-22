
import java.io.PrintStream;

public class Main {

   static PrintStream ps = System.out;
   
   static void func(int[][] arr) {
      final int N = arr.length;
      final int M = arr[0].length;
      
      boolean[] row = new boolean[N];
      boolean[] col = new boolean[M];
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<M; j++) {
            if(arr[i][j] != 0) continue;
            row[i] = true;
            col[j] = true;
         }
      }
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<M; j++) {
            if(row[i] || col[j]) arr[i][j] = 0;
         }
      }
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<M; j++) {
            ps.print(arr[i][j] + " ");
         }
         ps.println();
      }
      ps.println();
   }
   
   public static void main(String[] args) {
      func(new int[][]{
         {1, 2, 0, 1},
         {3, 0, 1, 1},
         {0, 0, 1, 2},
         {1, 2, 3, 0}
      });
      
      func(new int[][]{
         {1, 0},
         {3, 1}
      });
      
      func(new int[][]{
         {1, 2, 1, 1},
         {3, 0, 1, 1},
         {0, 0, 1, 2},
         {1, 2, 3, 0}
      });
      
      func(new int[][]{
         {1, 2, 3, 4},
         {5, 6, 0, 8},
         {9, 0, 11, 12},
         {13, 14, 15, 16}
      });
   }
   
