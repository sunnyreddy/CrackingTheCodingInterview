package Array_and_String;

public class OneAway {
    public boolean oneAway(String a, String b) {
        int alen = a.length(), blen = b.length();
        if(Math.abs(alen - blen) > 1) return false;

        int i = 0, j = 0;
        boolean foundDiff = false;
        while(i<alen && j<blen) {
            if(a.charAt(i) != b.charAt(i)) {
                if(foundDiff) return false;
                foundDiff = true;
                if(alen == blen) {
                    // if length is same then move both
                    i++;
                }
            }
            else {
                // if characters match move both
                i++;
            }
            // always move longer string pointer
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        String t1 = "pales", t2 = "pale";
        String t3 = "pale", t4 = "bale";
        String t5 = "pale", t6 = "bae";
        System.out.println(oneAway.oneAway(t1,t2));
        System.out.println(oneAway.oneAway(t3,t4));
        System.out.println(oneAway.oneAway(t5,t6));
    }
}
