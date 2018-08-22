import java.io.PrintStream;

public class Main {

   static PrintStream ps = System.out;
   
   public static String compressString(final String str) {
      
      StringBuilder sb = new StringBuilder();
      final int len = str.length();
      char pre_char = str.charAt(0);
      int cnt = 1;
      for(int i=1; i<len; i++) {
         char cur_char = str.charAt(i);
         if(pre_char == cur_char) {
            cnt++;
         } else {
            sb.append(pre_char);
            sb.append(cnt);
            cnt = 1;
            pre_char = cur_char;
         }
      }
      sb.append(pre_char);
      sb.append(cnt);
      String compressVer = sb.toString();
      return len > compressVer.length() ? compressVer : str;
   }
   
   public static void main(String[] args) {
      /**
       * aabccccccccaaa
       * a2b1c8a3
       * -> a2b1c8a3
       */
      ps.println(compressString("aabccccccccaaa"));
      
      /**
       * aabbccdd
       * a2b2c2d2
       * -> aabbccdd
       */
      ps.println(compressString("aabbccdd"));
      
      /**
       * eaaawwe
       * e1a3w2e1
       * -> eaaawwe
       */
      ps.println(compressString("eaaawwe"));
   }
   
}