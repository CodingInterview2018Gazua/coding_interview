package chapter5

import org.scalatest.FunSuite

class BinaryConverter_5_2_Suite extends FunSuite {
  test("BinaryConverter 는 0.5를 넣으면 0.1을 리턴해야 한다") {
    assertResult("0.1")(BinaryConverter_5_2.convertToBinary(0.5))
  }

  test("BinaryConverter 는 0.55를 넣으면 ERROR 를 리턴해야 한다") {
    assertResult("ERROR")(BinaryConverter_5_2.convertToBinary(0.55))
  }

  test("BinaryConverter 는 0.625를 넣으면 0.101을 리턴해야 한다") {
    assertResult("0.101")(BinaryConverter_5_2.convertToBinary(0.625))
  }
}
