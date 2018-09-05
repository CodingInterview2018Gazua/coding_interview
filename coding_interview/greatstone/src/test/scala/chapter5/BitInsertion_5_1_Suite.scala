package chapter5

import org.scalatest.FunSuite

class BitInsertion_5_1_Suite extends FunSuite {
  test("Test Set 1") {
    val N = Integer.parseInt("10000000000", 2)
    val M = Integer.parseInt("10011", 2)
    val actual = BitInsertion_5_1.insertBit(N, M, 2, 6)
    val expected = Integer.parseInt("10001001100", 2)
    assertResult(expected)(actual)
  }

  test("Test Set 2") {
    val N = Integer.parseInt("10000000000", 2)
    val M = Integer.parseInt("10011", 2)
    val actual = BitInsertion_5_1.insertBit(N, M, 2, 3)
    val expected = Integer.parseInt("10000001100", 2)
    assertResult(expected)(actual)
  }

  test("Test Set 3") {
    val N = Integer.parseInt("10001111100", 2)
    val M = Integer.parseInt("10011", 2)
    val actual = BitInsertion_5_1.insertBit(N, M, 2, 6)
    val expected = Integer.parseInt("10001001100", 2)
    assertResult(expected)(actual)
  }
}