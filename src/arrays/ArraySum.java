package arrays;

import java.util.ArrayList;
import java.util.List;

public class ArraySum {

    public static void main(String[] args){
        Solutions solutions = new Solutions();
//        solutions.startRunningSum();
//        Solutions.StepSummer stepSummer = new Solutions.StepSummer();
//        stepSummer.startStepSum();
//        Solutions.LargestGroup largestGroup = new Solutions.LargestGroup();
//        largestGroup.startLargestGroup();
//        Solutions.ArrayPairSum arrayPairSum = new Solutions.ArrayPairSum();
//        arrayPairSum.startArrayPairSum();
//        Solutions.KWeakestRow kWeakestRow = new Solutions.KWeakestRow();
//        kWeakestRow.startKWeakestRow();
        int[] numbs = {2,5,1,3,4,7};
        int n = 3;
//        solutions.shuffle(numbs, n);
        int[] numbes = {8, 1 ,2, 2, 3};
//        solutions.smallerNumbersThanCurrent(numbes);
        int[] numbers = {1,2,3,4};
//        solutions.decompressRLElist(numbers);
        int[] nums = {1,2,3};
//        new ArraySum().subSetI(nums);
        int [] numbersn = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        solutions.fix(numbersn);
    }

    public List<List<Integer>> subSetI(int[] nums){
        List<List<Integer>> subset = new ArrayList<>();
        dfs(subset, 0, nums, new ArrayList<>());
        return subset;
    }


    public void dfs(List<List<Integer>> subSet, int index, int[] nums, List<Integer> current ){
        subSet.add(new ArrayList<>(current));
        for (int i = index; i < nums.length ; i++) {
            current.add(nums[i]);
            dfs(subSet, i+1, nums, current);
            current.remove(current.size() - 1);
        }
    }


}
