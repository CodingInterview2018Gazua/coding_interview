package chapter5

import org.scalatest.FunSuite

class Problem_5_5_Suite extends FunSuite {
  test("Problem_5_5 는 29(1101)와 15(1111)를 넣으면 2를 출력해야 한다.") {
    assertResult(2)(Problem_5_5.countChangeBitForSameNumber(29, 15))
  }

  test("Problem_5_5 는 23425(0101101110000001)와 42543(1010011000101111)를 넣으면 2를 출력해야 한다.") {
    assertResult(12)(Problem_5_5.countChangeBitForSameNumber(23425, 42543))
  }

  test("Problem_5_5 는 2147483647(0111...111)과 0을 넣으면 31을 출력해야 한다.") {
    assertResult(31)(Problem_5_5.countChangeBitForSameNumber(2147483647, 0))
  }

  test("Problem_5_5 는 -1(1111...111)과 0을 넣으면 32를 출력해야 한다.") {
    assertResult(32)(Problem_5_5.countChangeBitForSameNumber(-1, 0))
  }

  test("Problem_5_5 는 같은 수를 넣으면 0을 출력해야 한다.") {
    assertResult(0)(Problem_5_5.countChangeBitForSameNumber(13234, 13234))
  }
}
