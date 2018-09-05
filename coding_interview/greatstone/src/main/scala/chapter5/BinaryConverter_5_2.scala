package chapter5

object BinaryConverter_5_2 {

  def convertToBinary(number: Double): String = {
    val binaryString = StringBuilder.newBuilder
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
    else "0." + binaryString.toString()
  }
}
