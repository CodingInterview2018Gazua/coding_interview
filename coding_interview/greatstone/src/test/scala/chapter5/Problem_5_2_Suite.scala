package chapter5

import org.scalatest.FunSuite

class Problem_5_2_Suite extends FunSuite {
  test("Problem_5_2 은 0.5를 넣으면 0.1을 리턴해야 한다") {
    assertResult("0.1")(Problem_5_2.toBinaryString(0.5))
  }

  test("Problem_5_2 은 0.55를 넣으면 ERROR 를 리턴해야 한다") {
    assertResult("ERROR")(Problem_5_2.toBinaryString(0.55))
  }

  test("Problem_5_2 은 0.625를 넣으면 0.101을 리턴해야 한다") {
    assertResult("0.101")(Problem_5_2.toBinaryString(0.625))
  }
}
