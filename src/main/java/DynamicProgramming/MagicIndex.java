package DynamicProgramming;

public class MagicIndex {
    public int magicIndex(int[] arr) {
        return helper(arr, 0, arr.length-1);
    }

    public int helper(int[] arr, int s, int e) {
        if(s > e) return -1;

        int mid = s + (e-s)/2;
        if(arr[mid] == mid) return mid;
        else if(arr[mid] < mid) return helper(arr, mid+1, e);
        else return helper(arr, s, mid-1);
    }

    public static void main(String[] args) {
        int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        MagicIndex mi = new MagicIndex();
        System.out.println(mi.magicIndex(arr));
    }
}
