package arrays

class SortParity {

    fun sortArrayByParityII(A: IntArray): IntArray {
        var e=0; var o=1
        val output = IntArray(A.size)
        A.forEach{i ->
            if(i%2==0){
                output[e] = i
                e+=2
            } else {
                output[o] = i
                o+=2
            }
        }
        return output
    }
}

fun main(){
    SortParity().sortArrayByParityII(intArrayOf(3,4)).forEach { print("$it, ") }
}