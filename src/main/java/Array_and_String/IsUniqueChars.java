package Array_and_String;

import java.util.HashSet;
import java.util.Set;

public class IsUniqueChars {

    // using extra data structure
    public boolean isUnique(String s) {
        Set<Character> check = new HashSet<Character>();
        for(char c: s.toCharArray()) {
            if(check.contains(c))
                return false;
            check.add(c);
        }
        return true;
    }

    // using boolean array of ascii or unicode values
    public boolean isUnique2(String s) {
        if(s.length() > 128) return false;
        boolean[] characters = new boolean[128];
        for(int i=0; i<s.length(); i++) {
            int val = s.charAt(i);
//            System.out.println(val);
            if(characters[val]) return false;
            characters[val] = true;
        }
        return true;
    }

    // without using any extra data structure
    public boolean isUniqueWithoutExtraMemory(String s) {
        int check = 0;
        for(int i=0; i<s.length(); i++) {
            int val = s.charAt(i);
            if((check & (1<<val)) > 0) return false;
            check |= (1<<val);
        }
        return true;
    }

    public static void main(String[] args) {
        IsUniqueChars test = new IsUniqueChars();
        String testString = "abcde";
        System.out.println(test.isUnique(testString));
        System.out.println(test.isUnique2(testString));
        System.out.println(test.isUniqueWithoutExtraMemory(testString));
    }
}
