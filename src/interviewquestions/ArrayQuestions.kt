package interviewquestions

class ArrayQuestions {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 0) return 0
        var prev = nums[0]
        var count = 1
        for (i in 1 until nums.size) {
            val cur = nums[i]
            if (cur != prev) {
                nums[count] = cur
                count++
            }
            prev = nums[i]
        }
        for (i in nums) println(i)
        return count
    }

    fun maxProfit(prices: IntArray): Int {
        var diff = 0
        for (i in 1 until prices.size) if (prices[i] > prices[i - 1]) diff += prices[i] - prices[i - 1]
        print(diff)
        return diff
    }

    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty()) return

        fun reverse(start: Int, end: Int) {
            if (start < end) {
                val temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                reverse(start + 1, end - 1)
            } else return
        }

        reverse(0, nums.size - 1)
        reverse(0, k - 1)
        reverse(k, nums.size - 1)

        nums.printArray()
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        var result: Boolean = false
        nums.sort()
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                result = true
                break
            }
        }
        return result
    }

    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>();
        for (i in nums) {
            if (!set.add(i)) set.remove(i)
        }
        return set.toArray()[0] as Int
        /*
        if (nums.size == 1) {
            return nums[0]
        }
        var num = 0
        for (x in nums) {
            num = num xor x
        }
        return num
        * */
    }

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val freq1 = HashMap<Int, Int>()
        val freq2 = HashMap<Int, Int>()
        val output = mutableListOf<Int>()
        for (i in nums1) {
            if (freq1.containsKey(i)) freq1[i] = freq1[i]!!.plus(1)
            else freq1[i] = 1
        }
        for (i in nums2) {
            if (freq2.containsKey(i)) freq2[i] = freq2[i]!!.plus(1)
            else freq2[i] = 1
        }
        for (x in freq1.keys) {
            if (freq2.containsKey(x)) {
                val min = (freq1[x]!!).coerceAtMost(freq2[x]!!)
                var i = 0
                while (i < min) {
                    output.add(x)
                    i++
                }
            }
        }
        return output.toIntArray()
        /*
        val map = mutableMapOf<Int, Int>()
        nums1.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val resultList = mutableListOf<Int>()
        nums2.forEach {
            val existing = map.getOrDefault(it, 0)
            if (existing > 0) {
                resultList.add(it)
                map[it] = existing - 1
            }
        }

        return resultList.toIntArray()
        * */
    }

    fun plusOne(digits: IntArray): IntArray {
        val output = mutableListOf<Int>()
        var carryforward = true
        for (i in digits.size - 1 downTo 0) {
            var x = digits[i]
            if (carryforward) {
                x++
            }
            if (x == 10) {
                carryforward = true
                output.add(0)
            } else {
                carryforward = false
                output.add(x)
            }
            if (i == 0 && carryforward) {
                output.add(1)
            }
        }
        output.reverse()
        return output.toIntArray()
    }

    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var j = 0
        while (i < nums.size && j < nums.size) {
            if (nums[j] != 0) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i++
            }
            j++
        }
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            var comp = target - num
            if (map.containsKey(comp)) {
                return intArrayOf(map[comp]!!, index)
            }
            map[num] = index
        }
        return intArrayOf()
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = HashSet<String>()
        board.forEachIndexed() { index, chars ->
            chars.forEachIndexed() { idx, c ->
                if (c != '.') {
                    if (!set.add("$c in row $index") || !set.add("$c in col $idx") ||
                            !set.add("$c in box ${index / 3} , ${idx / 3}")) {
                        println("value is ${board[index][idx]} of index $index and idx $idx")
                        return false
                    }
                }
            }
        }
        return true
    }

    fun reverse(n: Int): Int {
        var number = n
        var reverse = 0L
        if(number < 0) Math.abs(number)
        while(number > 0) {
            var lastDigit = number % 10
            reverse = (reverse * 10) + lastDigit
            number /= 10
        }
        return reverse.toInt()
    }

    fun reverseString(s: CharArray): Unit {
        var startIndex = 0
        var endIndex = s.size - 1
        while (startIndex < endIndex) {
            var temp = s[startIndex]
            s[startIndex] = s[endIndex]
            s[endIndex] = temp
            startIndex++
            endIndex--
        }
    }

    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        var sarr = s.toCharArray()
        var tarr = t.toCharArray()
        sarr.sort()
        tarr.sort()
        return sarr.contentEquals(tarr)
    }
    class TreeNode(var value: Int) {
             var left: TreeNode? = null
             var right: TreeNode? = null
         }
    fun isValidBST(root: TreeNode?, min: Int =Int.MIN_VALUE, max: Int =Int.MAX_VALUE): Boolean {
        if(root == null) return true
        if(root.left!!.value < min ||  root.right!!.value > max) return false
        return isValidBST(root.left, root.value, Int.MAX_VALUE) && isValidBST(root.right, Int.MIN_VALUE, root.value)
    }
}

fun IntArray.printArray() {
    forEach { print("${it} ") }
}

fun main(args: Array<String>) {
    /*val sudoku = arrayOf(charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'))*/
    ArrayQuestions().run {
//        removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)).run { print(this) }
//        maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)).run { print(this) }
//        rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
//        rotate(intArrayOf(-1), 2)
//        intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).printArray()
//        plusOne(intArrayOf(5, 6, 2, 0, 0, 4, 6, 2, 4, 9)).printArray()
//        twoSum(intArrayOf(2, 7, 11, 15), 9).printArray()
//        isValidSudoku(sudoku).run { print(this) }
//        reverse(1534236469).run { print(this) }
        isAnagram(s="anagram", t = "amagram").run { print(this) }
    }
}
