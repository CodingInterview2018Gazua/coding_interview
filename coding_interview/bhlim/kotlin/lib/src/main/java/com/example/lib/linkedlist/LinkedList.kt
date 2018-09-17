package com.example.lib.linkedlist

import java.util.Random

class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    private fun addFirst(input: T) {
        val newNode = Node(input)

        head = newNode
        tail = head
        size++
    }

    fun addNode(input: T) {
        val newNode = Node(input)

        if (head == null) {
            addFirst(input)
        } else {
            tail?.next = newNode
            tail = newNode
            size++
        }
    }

    fun makeCircularNode() {
        if (size == 0)
            throw RuntimeException("Head requiered")

        val rand = Random()
        val randIdx = rand.nextInt(size)

        val inputClone = getNode(randIdx)!!.clone()
        inputClone.next = null

        tail?.next = inputClone
        tail = inputClone
        size++
    }

    fun getNode(idx: Int): Node<T>? {
        if (size <= idx)
            throw IndexOutOfBoundsException()

        var prev = head

        for (i in 0 until size) {
            if (idx == i)
                return prev
            else {
                prev = prev!!.next
            }
        }

        return null
    }

    fun removeNode(idx: Int): Boolean {
        if (size <= idx)
            throw IndexOutOfBoundsException()

        var prev = head

        if (idx == 0) {
            head = head!!.next
            return true
        }

        for (i in 0 until size) {
            if (idx - 1 == i) {
                prev!!.next = prev.next!!.next
                size--
                return true
            } else {
                prev = prev!!.next
            }
        }

        return false
    }

    fun printNodes() {
        var temp = head

        while (true) {
            System.out.println(temp!!.data)
            temp = temp.next

            if (temp == null) {
                break
            } else if (temp.next == null) {
                System.out.println(temp.data)
                break
            }
        }
    }
}

data class Node<T>(val data : T) : Cloneable {
    var next: Node<T>? = null

    public override fun clone(): Node<T> {
        val newNode = Node(this.data)

        if (this.next != null)
            newNode.next = this.next?.clone()

        return newNode
    }
}