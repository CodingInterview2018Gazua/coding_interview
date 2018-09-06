package chapter5

import java.util.NoSuchElementException

import org.scalatest.FunSuite

class Problem_5_3_Suite extends FunSuite {
  test("Problem_5_3 은 2(10)에 대해 1(1)과 4(100)를 출력해야 한다.") {
    assertResult(1)(Problem_5_3.findBiggestSmallNumberWithSameBitCount(2))
    assertResult(4)(Problem_5_3.findSmallestBigNumberWithSameBitCount(2))
  }

  test("Problem_5_3 은 10(1010)에 대해 9(1001)과 12(1100)를 출력해야 한다.") {
    assertResult(9)(Problem_5_3.findBiggestSmallNumberWithSameBitCount(10))
    assertResult(12)(Problem_5_3.findSmallestBigNumberWithSameBitCount(10))
  }

  test("Problem_5_3 은 15(1111)에 대해 NoSuchElementException 이 발생하고 23(10111)를 출력해야 한다.") {
    assertThrows[NoSuchElementException](Problem_5_3.findBiggestSmallNumberWithSameBitCount(15))
    assertResult(23)(Problem_5_3.findSmallestBigNumberWithSameBitCount(15))
  }

  test("Problem_5_3 은 0에 대해 NoSuchElementException 이 발생해야 한다") {
    assertThrows[NoSuchElementException](Problem_5_3.findBiggestSmallNumberWithSameBitCount(0))
    assertThrows[NoSuchElementException](Problem_5_3.findSmallestBigNumberWithSameBitCount(0))
  }

  test("Problem_5_3 은 2147483647(0111...111)에 대해 NoSuchElementException 이 발생해야 한다") {
    assertThrows[NoSuchElementException](Problem_5_3.findBiggestSmallNumberWithSameBitCount(2147483647))
    assertThrows[NoSuchElementException](Problem_5_3.findSmallestBigNumberWithSameBitCount(2147483647))
  }
}
