import java.io.PrintStream;

public class Main {

   static PrintStream ps = System.out;
   
   /**
    * s1가 s2를 포함하는지 여부
    * @param s1
    * @param s2
    * @return
    */
   static boolean isSubstring(final String s1, final String s2) {
      return s1.contains(s2);
   }
   
   /**
    * s2가 s1를 회전시킨 결과인지 판별
    * @param s1
    * @param s2
    */
   static boolean func(String s1, String s2) {
      if(s1.length() != s2.length()) return false;
      s1 += s1;
      return isSubstring(s1, s2);
   }
   
   public static void main(String[] args) {
      /** YES **/
      boolean isContain = func("waterbottle", "erbottlewat");
      ps.println(isContain ? "YES" : "NO");
      
      /** NO **/
      isContain = func("waterbottle", "erbottlewate");
      ps.println(isContain ? "YES" : "NO");
      
      /** YES **/
      isContain = func("aaa", "aaa");
      ps.println(isContain ? "YES" : "NO");
      
      /** NO **/
      isContain = func("aaa", "aAa");
      ps.println(isContain ? "YES" : "NO");
      
      /** YES **/
      isContain = func("a", "a");
      ps.println(isContain ? "YES" : "NO");
   }
   
}