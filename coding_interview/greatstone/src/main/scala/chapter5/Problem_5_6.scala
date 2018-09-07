package chapter5

object Problem_5_6 {
  private val EVEN_BIT_MASK = 0x55555555
  private val ODD_BIT_MASK = 0xAAAAAAAA

  /**
    * 짝수 비트와 홀수 비트 바꿔서 리턴
    *
    * @param n 정수
    * @return 짝수 비트와 홀수 비트 바뀐 수
    */
  def exchangeOddAndEvenBits(n: Int): Int =
    ((n & EVEN_BIT_MASK) << 1) | ((n & ODD_BIT_MASK) >>> 1)
}
