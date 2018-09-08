package chapter5

import org.scalatest.FunSuite

class Problem_5_6_Suite extends FunSuite {
  test("Problem_5_6은 5(0101)를 넣으면 10(1010)을 출력해야 한다.") {
    assertResult(10)(Problem_5_6.exchangeOddAndEvenBits(5))
  }

  test("Problem_5_6은 42(101010)를 넣으면 21(010101)을 출력해야 한다.") {
    assertResult(21)(Problem_5_6.exchangeOddAndEvenBits(42))
  }

  test("Problem_5_6은 42543(1010011000101111)을 넣으면 22815(0101100100011111)를 출력해야 한다.") {
    assertResult(22815)(Problem_5_6.exchangeOddAndEvenBits(42543))
  }
}
