package Array_and_String;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean palindromePermutation(String s) {
        Map<Character,Integer> check = new HashMap();
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c != ' ')
                check.put(c, check.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for(int v: check.values())
            count += v%2;

        return count <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        String s = "Tact coa";
        System.out.println(pp.palindromePermutation(s));
    }
}
