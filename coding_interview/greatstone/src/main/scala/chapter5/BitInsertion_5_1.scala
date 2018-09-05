package chapter5

object BitInsertion_5_1 {

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
    var srcBitMask = 0
    for (_ <- i to j) {
      srcBitMask = srcBitMask << 1 | 1
    }
    val source = M & srcBitMask

    val destBitMask = ~(srcBitMask << i)
    val dest = N & destBitMask

    dest | (source << i)
  }
}