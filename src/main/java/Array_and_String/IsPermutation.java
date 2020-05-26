package Array_and_String;

import java.util.Arrays;

public class IsPermutation {

    // using sort
    public boolean isPermutation(String a, String b) {
        if(a.length() != b.length()) return false;
        return this.sort(a).equals(this.sort(b));
    }

    public String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // without using sort
    public boolean isPermutation2(String a, String b) {
        if(a.length() != b.length()) return false;

        int[] charCount = new int[256];
        for(int i=0; i<a.length(); i++) {
            int val = a.charAt(i);
            charCount[val]++;
        }

        for(int i=0; i<b.length(); i++) {
            int val = b.charAt(i);
            charCount[val]--;
            if(charCount[val] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPermutation ip = new IsPermutation();
        String a = "abcaq";
        String b = "aacbp";
        System.out.println(ip.isPermutation2(a,b));
    }
}
