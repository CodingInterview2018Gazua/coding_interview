package chapter5

object Problem_5_5 {

  /**
    * 두 수를 같은 수로 바꾸기 위해 비트를 몇 개 바꿔야 하는지 계산.
    *
    * @param A 정수
    * @param B 정수
    * @return 바꿔야 하는 비트 수
    */
  def countChangeBitForSameNumber(A: Int, B: Int): Int =
    countBit1(A ^ B)

  /**
    * Brian Kernighan's algorithm
    * 1  Initialize count: = 0
    * 2  If integer n is not zero
    * (a) Do bitwise & with (n-1) and assign the value back to n
    * n: = n&(n-1)
    * (b) Increment count by 1
    * (c) go to step 2
    * 3  Else return count
    *
    * @param n 정수
    * @return n의 1 bit 수
    */
  private def countBit1(n: Int): Int = {
    if (n == 0) 0
    else 1 + countBit1(n & (n - 1))
  }
}
