package arrays

class MergeSort {
    /**
     * https://leetcode.com/problems/squares-of-a-sorted-array/
     * Given an array of integers A sorted in non-decreasing order,
     * return an array of the squares of each number, also in sorted non-decreasing order.
     * Example:
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     */

    fun sortedSquares(A: IntArray): IntArray {
        val arr = IntArray(A.size)
        A.forEachIndexed {index, i ->  arr[index] = i*i}
        return sort(arr)
    }

    fun sort(arr: IntArray): IntArray{
        if (arr.size < 2) return arr
        val mid = arr.size/2
        var leftHalf = arr.copyOfRange(0, mid)
        var rightHalf = arr.copyOfRange(mid, arr.size)
        return merge(sort(leftHalf), sort(rightHalf), arr.size)
    }
    
    fun merge(leftHalf: IntArray, rightHalf: IntArray, size: Int): IntArray{
        val arr = IntArray(size)
        var i=0; var j=0; var k=0
        while (i < leftHalf.size && j < rightHalf.size){
            if(leftHalf[i] < rightHalf[j]){
                arr[k] = leftHalf[i]
                i++
            } else {
                arr[k] = rightHalf[j]
                j++
            }
            k++
        }
        while (i < leftHalf.size){
            arr[k] = leftHalf[i]
            i++; k++
        }
        while (j < rightHalf.size){
            arr[k] = rightHalf[j]
            j++; k++
        }
        return arr
    }
}

fun main(){
    var A = intArrayOf(-4,-1,0,3,10)
    MergeSort().sortedSquares(A).forEach { print("$it, ") }
}

