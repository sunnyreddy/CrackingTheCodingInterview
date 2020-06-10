package DynamicProgramming;

public class MagicIndex2 {
    // finding magic index when there are repeated values in an array.
    public int magicIndex(int[] arr) {
        return helper(arr, 0, arr.length-1);
    }

    public int helper(int[] arr, int s, int e) {
        if(s > e) return -1;

        int mid = s + (e-s)/2;
        int midval = arr[mid];
        if(midval == mid) return mid;

        // search left coz it can be left
        int leftI = Math.min(mid-1, midval);
        int left = helper(arr, s, leftI);
        if(left >= 0) return left;

        // search right
        int rightI = Math.max(mid+1, midval);
        int right = helper(arr, rightI, e);
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        MagicIndex2 mi = new MagicIndex2();
        System.out.println(mi.magicIndex(arr));
    }
}
