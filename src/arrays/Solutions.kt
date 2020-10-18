package arrays

import java.util.*

class Solutions {
    //Running Sum
    fun runningSum(nums: IntArray): IntArray {
        var prev = 0
        val output = IntArray(nums.size)
        for (i in nums.indices) {
            prev = prev + nums[i]
            output[i] = prev
        }
        return output
    }

    fun startRunningSum() {
        val nums = intArrayOf(1, 2, 3, 4)
        val output = Solutions().runningSum(nums)
        for (i in output) {
            println(i)
        }
    }

    //Candies
    //https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val output: MutableList<Boolean> = ArrayList()
        val highest = findHighest(candies)
        for (i in candies.indices) {
            output.add(candies[i] + extraCandies >= highest)
        }
        return output
    }

    private fun findHighest(candies: IntArray): Int {
        var hightest = 0
        for (i in candies.indices) {
            if (candies[i] >= hightest) hightest = candies[i]
        }
        return hightest
    }

    //Minimum value to get positive step by step sum
    //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
    internal class StepSummer {
        private fun minStartValue(nums: IntArray): Int {
            var currSum = nums[0]
            var min = nums[0]
            for (i in 1 until nums.size) {
                currSum += nums[i]
                min = Math.min(currSum, min)
            }
            if (min < 0) {
                println("min: $min")
                return Math.abs(min) + 1
            }
            return 1
        }

        fun startStepSum() {
            val nums = intArrayOf(-3, 2, -3, 4, 2)
            println("Min Start Value is " + minStartValue(nums))
        }
    }

    //Count Largest Group
    //https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
    internal class LargestGroup {
        fun countLargestGroup(n: Int): Int {
            val map: MutableMap<Int, MutableList<Int>> = HashMap()
            for (i in 1 until n) {
                val sum = sumOfDigits(i)
                map.putIfAbsent(sum, ArrayList())
                map[sum]!!.add(i)
            }
            var max = 0
            var group = 0
            for (list in map.values) {
                if (list.size > max) {
                    max = list.size
                    group = 0
                }
                if (list.size == max) {
                    group++
                }
            }
            return group
        }

        private fun sumOfDigits(n: Int): Int {
            var n = n
            var sum = 0
            while (n > 0) {
                sum += n % 10
                n = n / 10
            }
            return sum
        }

        fun startLargestGroup() {
            val n = 13
            println(countLargestGroup(n))
        }
    }

    //https://leetcode.com/problems/array-partition-i/
    internal class ArrayPairSum {
        fun arrayPairSum(nums: IntArray): Int {
            Arrays.sort(nums)
            var min1 = 0
            var i = 0
            while (i < nums.size) {
                min1 += nums[i]
                i += 2
            }
            return min1
        }

        fun startArrayPairSum() {
            val input = intArrayOf(1, 2, 3, 4)
            println(arrayPairSum(input))
        }
    }

    //    The K Weakest Rows in a Matrix
    //    https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    internal class KWeakestRow {
        var i = 0
        fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
            val solution: MutableMap<Int, Int> = HashMap()
            val sol = IntArray(k)

            return sol
        }

        fun startKWeakestRow() {
            val mat = arrayOf(intArrayOf(1, 1, 0, 0, 0), intArrayOf(1, 1, 1, 1, 0), intArrayOf(1, 0, 0, 0, 0), intArrayOf(1, 1, 0, 0, 0), intArrayOf(1, 1, 1, 1, 1))
            for (i in kWeakestRows(mat, 3)) {
                println(i)
            }
        }
    }

    fun shuffle(nums: IntArray, n: Int): IntArray {
        var n = n
        val newInt = IntArray(nums.size)
        var newIntCounter = 0
        for (i in 0 until nums.size / 2) {
            newInt[newIntCounter] = nums[i]
            newInt[++newIntCounter] = nums[n]
            newIntCounter++
            n++
        }
        return newInt
    }

    fun numIdenticalPairs(nums: IntArray): Int {
        val solSet = HashMap<Int, Int?>()
        var count = 0
        for (i in nums) {
            if (solSet.containsKey(i)) {
                count += solSet[i]!!
                solSet[i] = solSet[i]!! + 1
            } else {
                solSet[i] = 1
            }
        }
        return count
    }

    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val temp = Arrays.copyOf(nums, nums.size)
        val answer = IntArray(nums.size)
        val map = HashMap<Int, Int>()
        Arrays.sort(temp)
        for (i in temp.indices) {
            map.putIfAbsent(temp[i], i)
        }
        for (i in nums.indices) {
            answer[i] = map[nums[i]]!!
            println(answer[i])
        }
        return answer
    }

    fun decompressRLElist(nums: IntArray): IntArray {
        val answer: MutableList<Int> = ArrayList()
        var i = 0
        while (i < nums.size) {
            val freq = nums[i]
            val value = nums[++i]
            var index = 1
            while (index <= freq) {
                answer.add(value)
                index++
            }
            i++
        }
        return answer.stream().mapToInt { obj: Int -> obj }.toArray()
    }

    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val a = IntArray(nums.size)
        for (i in nums.indices) {
            if (a[index[i]] != 0) {
                System.arraycopy(a, index[i], a, index[i] + 1, a.size - index[i] - 1)
            }
            a[index[i]] = nums[i]
        }
        return a
    }

    fun fix(arr: IntArray): IntArray {
        var i = 0
        while (i < arr.size) {
            if (arr[i] >= 0 && arr[i] != i) {
                val ele = arr[arr[i]]
                arr[arr[i]] = arr[i]
                arr[i] = ele
            } else {
                i++
            }
        }
        println(Arrays.toString(arr))
        return arr
    }

    fun subSetI(nums: IntArray): List<List<Int>>? {
        val subset: MutableList<List<Int>> = ArrayList()
        dfs(subset, 0, nums, ArrayList())
        return subset
    }


    fun dfs(subSet: MutableList<List<Int>>, index: Int, nums: IntArray, current: MutableList<Int>) {
        subSet.add(ArrayList(current))
        for (i in index until nums.size) {
            current.add(nums[i])
            dfs(subSet, i + 1, nums, current)
            current.removeAt(current.size - 1)
        }
    }
}


fun main() {

}