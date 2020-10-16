package arrays;

import java.util.*;

public class Solutions {

    //Running Sum
    public int[] runningSum(int[] nums) {
        int prev = 0;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prev = prev + nums[i];
            output[i] = prev;
        }
        return output;
    }

    public void startRunningSum() {
        int nums[] = {1, 2, 3, 4};
        int output[] = new Solutions().runningSum(nums);
        for (int i : output) {
            System.out.println(i);
        }
    }

    //Candies
    //https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> output = new ArrayList<>();
        int highest = findHighest(candies);
        for (int i = 0; i < candies.length; i++) {
            output.add(candies[i] + extraCandies >= highest);
        }
        return output;
    }

    private int findHighest(int[] candies) {
        int hightest = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= hightest) hightest = candies[i];
        }
        return hightest;
    }

    //Minimum value to get positive step by step sum
    //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
    static class StepSummer {
        private int minStartValue(int[] nums) {
            int currSum = nums[0];
            int min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currSum += nums[i];
                min = Math.min(currSum, min);
            }
            if (min < 0) {
                System.out.println("min: " + min);
                return Math.abs(min) + 1;
            }
            return 1;
        }

        public void startStepSum() {
            int[] nums = {-3, 2, -3, 4, 2};
            System.out.println("Min Start Value is " + minStartValue(nums));
        }
    }

    //Count Largest Group
    //https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
    static class LargestGroup {
        public int countLargestGroup(int n) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i < n; i++) {
                int sum = sumOfDigits(i);
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(i);
            }
            int max = 0, group = 0;
            for (List<Integer> list : map.values()) {
                if (list.size() > max) {
                    max = list.size();
                    group = 0;
                }
                if (list.size() == max) {
                    group++;
                }
            }
            return group;
        }

        private int sumOfDigits(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            return sum;
        }

        public void startLargestGroup() {
            int n = 13;
            System.out.println(countLargestGroup(n));
        }
    }

    //https://leetcode.com/problems/array-partition-i/
    static class ArrayPairSum {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int min1 = 0;
            for (int i = 0; i < nums.length; i += 2) {
                min1 += nums[i];
            }
            return min1;
        }


        public void startArrayPairSum() {
            int[] input = {1, 2, 3, 4};
            System.out.println(arrayPairSum(input));
        }
    }

    //    The K Weakest Rows in a Matrix
//    https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    static class KWeakestRow {
        int i = 0;
        public int[] kWeakestRows(int[][] mat, int k) {
            Map<Integer, Integer> solution = new HashMap<>();
            int[] sol = new int[k];
            for (int row = 0; row < mat.length; row++) {
                int rowSum = 0;
                for (int col = 0; col < mat[row].length; col++) {
//                    if(mat[row][col] == 0) break;
                    rowSum += mat[row][col];
                }
                solution.put(row, rowSum);
            }
            solution.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .forEach(u -> {
                        if (i < k) {
                            sol[i] = u.getKey();
                            i++;
                        }
                    });
            return sol;
        }

        public void startKWeakestRow() {
            int[][] mat = {
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0},
                    {1, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 1}
            };
            for (int i :
                    kWeakestRows(mat, 3)) {
                System.out.println(i);
            }
        }
    }

    public int[] shuffle(int[] nums, int n) {
        int[] newInt = new int[nums.length];
        int newIntCounter = 0;
        for (int i = 0; i < nums.length/2; i++) {
            newInt[newIntCounter] = nums[i];
            newInt[++newIntCounter] = nums[n];
            newIntCounter++;
            n++;
        }
        return newInt;
    }

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> solSet = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            if(solSet.containsKey(i)){
                count+= solSet.get(i);
                solSet.put(i, solSet.get(i)+1);
            } else {
                solSet.put(i, 1);
            }
        }
        return count;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        int[] answer = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            map.putIfAbsent(temp[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = map.get(nums[i]);
            System.out.println(answer[i]);
        }
        return answer;
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = nums[i];
            int value = nums[++i];
            int index = 1;
            while (index <= freq){
                answer.add(value);
                index++;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int a[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (a[index[i]] != 0) {
                System.arraycopy(a, index[i], a, index[i] + 1, (a.length - index[i]) - 1);
            }
            a[index[i]] = nums[i];
        }
        return a;
    }

    public int[] fix(int[] arr) {
        for (int i = 0; i < arr.length;) {
            if (arr[i] >= 0 && arr[i] != i) {
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

}

