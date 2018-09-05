package chapter5

object Problem_5_2 {

  /**
    * 0과 1 사이의 실수를 이진수 문자열로 변환
    *
    * @param number 0과 1 사이의 실수
    * @return 이진수 문자열
    */
  def toBinaryString(number: Double): String = {
    val binaryString = StringBuilder.newBuilder.append("0.")
    var comp = number
    while (comp != 0 && binaryString.size <= 32) {
      comp *= 2
      val digit = if (comp >= 1) {
        comp -= 1
        '1'
      } else {
        '0'
      }
      binaryString += digit
    }

    if (binaryString.size > 32) "ERROR"
    else binaryString.toString()
  }
}
