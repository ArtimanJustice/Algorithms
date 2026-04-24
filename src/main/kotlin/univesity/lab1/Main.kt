package univesity.lab1

import kotlin.math.abs
import kotlin.system.measureNanoTime

fun main() {
    fun test(name: String, block: () -> Unit) {
        println("----- $name -----")
        val time = measureNanoTime {
            block()
        }
        println("Time: $time ns")
        println()
    }

    val base = fromValues(1, 2, 3, 4, 5, 6)
    val withDuplicates = fromValues(1, 2, 2, 3, 3, 4, 5)
    val listA = fromValues(1, 3, 5, 7)
    val listB = fromValues(2, 3, 4, 7, 8)

    test("search(4)") {
        val list = base.copyList()
        list.printList()
        println("Found: ${list.search(4)}")
    }

    test("sumItems()") {
        val list = base.copyList()
        list.printList()
        println("Sum: ${list.sumItems()}")
    }

    test("sumEvenItems()") {
        val list = base.copyList()
        list.printList()
        println("Even sum: ${list.sumEvenItems()}")
    }

    test("removeDuplicates()") {
        val list = withDuplicates.copyList()
        println("Before:")
        list.printList()
        list.removeDuplicates()
        println("After:")
        list.printList()
    }

    test("listEqual()") {
        val list1 = base.copyList()
        val list2 = base.copyList()
        println("Equal: ${listEqual(list1, list2)}")
    }

    test("printReverse()") {
        val list = base.copyList()
        println("Original:")
        list.printList()
        print("Reverse print: ")
        list.printReverse()
    }

    test("copyRange(2, 4)") {
        val list = base.copyList()
        println("Original:")
        list.printList()
        val result = list.copyRange(2, 4)
        println("Range copy:")
        result.printList()
    }

    test("splitAt(3)") {
        val list = base.copyList()
        println("Original:")
        list.printList()
        val (first, second) = list.splitAt(3)
        println("First:")
        first.printList()
        println("Second:")
        second.printList()
    }

    test("reverse()") {
        val list = base.copyList()
        println("Before:")
        list.printList()
        list.reverse()
        println("After:")
        list.printList()
    }

    test("reverseCopy()") {
        val list = base.copyList()
        println("Original before:")
        list.printList()
        val reversed = list.reverseCopy()
        println("Original after reverseCopy():")
        list.printList()
        println("Result:")
        reversed.printList()
    }

    test("copyReverse()") {
        val list = base.copyList()
        println("Original:")
        list.printList()
        val reversed = list.copyReverse()
        println("Copy reversed:")
        reversed.printList()
    }

    test("insertDuplicate()") {
        val list = withDuplicates.copyList()
        println("Before:")
        list.printList()
        list.insertDuplicate()
        println("After:")
        list.printList()
    }

    test("copyDuplicate()") {
        val list = withDuplicates.copyList()
        println("Original:")
        list.printList()
        val result = list.copyDuplicate()
        println("Copied with duplicates:")
        result.printList()
    }

    test("merge(list2)") {
        val list1 = listA.copyList()
        val list2 = listB.copyList()
        println("L1 before:")
        list1.printList()
        println("L2:")
        list2.printList()
        list1.merge(list2)
        println("L1 after merge:")
        list1.printList()
    }

    test("mergeToNew(list2)") {
        val list1 = listA.copyList()
        val list2 = listB.copyList()
        println("L1:")
        list1.printList()
        println("L2:")
        list2.printList()
        val result = list1.mergeToNew(list2)
        println("L3:")
        result.printList()
    }

    test("union(list2)") {
        val list1 = listA.copyList()
        val list2 = listB.copyList()
        println("L1:")
        list1.printList()
        println("L2:")
        list2.printList()
        val result = list1.union(list2)
        println("Union:")
        result.printList()
    }

    test("intersection(list2)") {
        val list1 = listA.copyList()
        val list2 = listB.copyList()
        println("L1:")
        list1.printList()
        println("L2:")
        list2.printList()
        val result = list1.intersection(list2)
        println("Intersection:")
        result.printList()
    }

    test("difference(list2)") {
        val list1 = listA.copyList()
        val list2 = listB.copyList()
        println("L1:")
        list1.printList()
        println("L2:")
        list2.printList()
        val result = list1.difference(list2)
        println("Difference L1 - L2:")
        result.printList()
    }

    test("containsAll(list2)") {
        val list1 = fromValues(1, 2, 3, 4, 5, 6)
        val list2 = fromValues(2, 4, 6)
        println("L1:")
        list1.printList()
        println("L2:")
        list2.printList()
        println("Contains all: ${list1.containsAll(list2)}")
    }

    test("removeAverage()") {
        val list = fromValues(1, 2, 4, 7, 10)
        println("Before:")
        list.printList()
        val removed = list.removeAverage()
        println("Removed value: $removed")
        println("After:")
        list.printList()
    }
}

fun fromValues(vararg values: Int): SortedLinkedList {
    val list = SortedLinkedList()
    for (value in values) {
        list.add(Node(value))
    }
    return list
}

fun SortedLinkedList.copyList(): SortedLinkedList {
    val result = SortedLinkedList()
    var curr = head
    while (curr != null) {
        result.add(Node(curr.value))
        curr = curr.next
    }
    return result
}