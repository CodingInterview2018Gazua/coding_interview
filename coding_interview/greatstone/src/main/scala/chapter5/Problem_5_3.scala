package chapter5

object Problem_5_3 {

  /**
    * 입력 값과 bit 1의 개수가 같은 입력 값보다 작은 수 중 가장 큰 수를 구한다.
    *
    * @param x 양의 정수
    * @return x와 bit 1의 개수가 같은 x보다 작은 수 중 가장 큰 수
    */
  def findBiggestSmallNumberWithSameBitCount(x: Int): Int =
    findBiggestSmallNumberWithSameBitCountRecursive(x, 0)

  /**
    * 입력 값과 bit 1의 개수가 같은 입력 값보다 큰 수 중 가장 작은 수를 구한다.
    *
    * @param x 양의 정수
    * @return x와 bit 1의 개수가 같은 x보다 큰 수 중 가장 작은 수
    */
  def findSmallestBigNumberWithSameBitCount(x: Int): Int =
    findSmallestBigNumberWithSameBitCountRecursive(x, 0)

  private def findBiggestSmallNumberWithSameBitCountRecursive(x: Int, pos: Int): Int = {
    if (pos == 30) throw new NoSuchElementException
    else if (((x & 1 << pos) != (1 << pos)) && ((x & 2 << pos) == (2 << pos))) x ^ (3 << pos)
    else findBiggestSmallNumberWithSameBitCountRecursive(x, pos + 1)
  }

  private def findSmallestBigNumberWithSameBitCountRecursive(x: Int, pos: Int): Int = {
    if (pos == 30) throw new NoSuchElementException
    else if (((x & 1 << pos) == (1 << pos)) && ((x & 2 << pos) != (2 << pos))) x ^ (3 << pos)
    else findSmallestBigNumberWithSameBitCountRecursive(x, pos + 1)
  }
}
