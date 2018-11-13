package com.example.lib.backjoon

import java.util.*

var N = 4
var M = 2

val evalByAmount = ArrayList<Int>()
val evalByRate = ArrayList<Int>()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val array = ArrayList<String>()

    while (sc.hasNext()) {
        array.add(sc.next())
    }

    val list = ArrayList<Benefit>()

    val input = array[0].split(" ")

    N = input[0].toInt()
    M = input[1].toInt()


    for(i in 1 until N + 1) {
        val inputData = array[i].split(" ")

        for(j in 0 until M) {
            val benefit = Benefit(i ,inputData[j + 1].toInt() , j)
            list.add(benefit)
        }
    }

//    list.add(Benefit(1, 5))
//    list.add(Benefit(1, 1))
//    list.add(Benefit(2, 6))
//    list.add(Benefit(3, 7))
//    list.add(Benefit(3, 9))
//    list.add(Benefit(4, 8))
//    list.add(Benefit(4, 15))

    for(i in 0 until M) {
        evalByAmount.add(0)
        evalByRate.add(0)
    }

//    list.add(Benefit(1, 5, 0))
//    list.add(Benefit(1, 1, 1))
//    list.add(Benefit(2, 5, 0))
//    list.add(Benefit(2, 6, 1))
//    list.add(Benefit(3, 7, 0))
//    list.add(Benefit(3, 9, 1))
//    list.add(Benefit(4, 10, 0))
//    list.add(Benefit(4, 15, 1))


    val maxByAmount = list.evalByAmount()
    val maxByRate = list.evalByRate()

    if(maxByAmount > maxByRate) {
        print("$maxByAmount\n")
        evalByAmount.forEach {
            print("$it ")
        }
    } else {
        print("$maxByRate\n")
        evalByRate.forEach {
            print("$it ")
        }
    }
}

private fun ArrayList<Benefit>.evalByAmount() : Int {
    sortWith(BenefitAmountComparator())

    var m = 0
    var sum = 0
    var investAmount = N

    fun cal() {
        var rest : Int = 0

        forEach {
            if(m == M)
                return@forEach

            rest = investAmount - it.investAmount

            if(rest >= 0 && evalByAmount[it.company] == 0) {
                sum += it.benefitAmount
                investAmount -= it.investAmount
                evalByAmount[it.company] = it.investAmount
                m++
            }
        }

        investAmount = rest
    }

    cal()

    if(investAmount != 0) {
        sortWith(BenefitAmountComparatorByInvestAmount(investAmount))
        cal()
    }

    return sum
}

private fun ArrayList<Benefit>.evalByRate() : Int {
    sortWith(BenefitRateComparator())

    var m = 0
    var sum = 0
    var investAmount = N

    fun cal() {
        forEach {
            if(m == M)
                return@forEach

            val rest = investAmount - it.investAmount

            if(rest >= 0 && evalByRate[it.company] == 0) {
                sum += it.benefitAmount
                investAmount -= it.investAmount
                evalByRate[it.company] = it.investAmount
                m++
            }
        }
    }

    cal()

    if(investAmount != 0) {
        sortWith(BenefitRateComparatorByInvestAmount(investAmount))
        cal()
    }

    return sum
}

class BenefitAmountComparator : Comparator<Benefit> {
    override fun compare(p0: Benefit, p1: Benefit): Int {
        return (p0.benefitAmount - p1.benefitAmount) * -1
    }
}

class BenefitAmountComparatorByInvestAmount(val amount : Int) : Comparator<Benefit> {
    override fun compare(p0: Benefit, p1: Benefit): Int {
        if(amount < p1.investAmount)
            return -1

        return (p0.benefitAmount - p1.benefitAmount) * -1
    }
}

class BenefitRateComparatorByInvestAmount(val amount : Int) : Comparator<Benefit> {
    override fun compare(p0: Benefit, p1: Benefit): Int {
        if(amount < p1.investAmount)
            return -1

        return (p0.rate - p1.rate).toInt() * -1
    }
}

class BenefitRateComparator : Comparator<Benefit> {
    override fun compare(p0: Benefit, p1: Benefit): Int {
        return (p0.rate - p1.rate).toInt() * -1
    }
}

data class Benefit(val investAmount : Int , val benefitAmount : Int = 0, val company : Int) {
    val rate : Float = (benefitAmount / investAmount).toFloat()

    override fun toString(): String {
        return "invest = $investAmount, benefit = $benefitAmount, rate = $rate\n"
    }
}
