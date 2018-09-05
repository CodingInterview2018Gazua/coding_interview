package chapter5

object Problem_5_1 {

  /**
    * M의 비트를 N에 삽입하는 메서드.
    *
    * @param N 원본 비트
    * @param M 삽입할 비트
    * @param i 비트 끝 위치
    * @param j 비트 시작 위치
    * @return 비트 삽입 결과
    */
  def insertBit(N: Int, M: Int, i: Int, j: Int): Int = {
    val destLeftBitMask = ~0 << (j + 1)
    val destRightBitMask = (~destLeftBitMask) >>> (j - i + 1)
    val destBitMask = destLeftBitMask | destRightBitMask

    val srcBitMask = ~destBitMask

    val source = (M << i) & srcBitMask
    val dest = N & destBitMask

    dest | source
  }
}