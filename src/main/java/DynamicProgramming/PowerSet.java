package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> powerset(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> moreSubsets = new ArrayList<>();
            for(List<Integer> subset: allSubsets) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(nums[i]);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public void printList(List<List<Integer>> ans) {
        for(List<Integer> list: ans) {
            for(int i: list) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        int[] t1 = {1,2,3};
        List<List<Integer>> ans = ps.powerset(t1);
        ps.printList(ans);
    }
}
