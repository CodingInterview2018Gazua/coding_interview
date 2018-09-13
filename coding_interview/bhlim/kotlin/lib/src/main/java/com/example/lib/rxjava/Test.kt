package com.example.lib.rxjava

import io.reactivex.Observable
import io.reactivex.disposables.Disposable

var int = 11

val threadTest : Runnable = Runnable {
    print(int)
}

var disp : Disposable? = null

fun main(args : Array<String>) {
    //just()
    //create()
    //fromArray()
    callable()
}

fun callable() {
    val source = Observable.fromCallable {
        print("dd")
    }

    source.subscribe()
}

fun fromArray() {
    val arr1 = arrayOf(24, 3, 25, 36, 5, 0, 99)
    val source = Observable.fromArray(*arr1)
    source.subscribe{
        print("$it\n")
    }
}

fun create() {
    val source = Observable.create<() -> Unit> {
        it.onNext {
            print("1\n")
        }
        it.onNext {
            print("2\n")
        }
        it.onComplete()
    }

    source.subscribe({
        it.invoke()
    },{

    },{
        print("Complete\n")
    })
}

fun just() {
    val source = Observable.just("RED", "GREEN" , "BLUE")

    disp = source.subscribe {
        print("$it\n")
    }

    print("${disp?.isDisposed}\n")
}