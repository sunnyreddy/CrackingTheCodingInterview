package Array_and_String;

public class StringCompression {

    /* method 1
     here we stringBuilder because stringBuilder will have O(n)
     complexity when we do a concatenation unlike string which has O(n**2)
    */
    public  String stringCompression1(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count++;
            // since we need to iterate the last element and then we dont have i+1
            // the or if true for 1st expression will not go into the second
            if(i+1>=s.length() || s.charAt(i) != s.charAt(i+1)) {
                sb.append(""+s.charAt(i)+count);
                count = 0;
            }
        }
        return sb.length() > s.length() ? s : sb.toString();
    }

    // My solution
    public String stringCompression(String s) {
        int newLen = checkForLength(s);
        if(newLen > s.length()) return s;

        StringBuilder sb = new StringBuilder(newLen);
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            count++;
            if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                sb.append(""+s.charAt(i)+count);
                count = 0;
            }
        }
        return sb.toString();
    }

    public int checkForLength(String s) {
//        int slen = s.length(), nlen = 0;
//        char prev = ' ';
//        for(int i=0; i<slen; i++) {
//            char curr = s.charAt(i);
//            if(prev != curr) {
//                nlen += 2;
//                prev = curr;
//            }
//        }
//        return nlen;
        int nlen = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                nlen += 2;
                count = 0;
            }
        }
        return nlen;
    }

    /*
    one of the benefit of checking length before creating string is that you can
    initialize the string length beforehand which does not account for the cost
    we need to increase the size of the stringBuilder in runtime
    */

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        String t1 = "aabcccccaaae";
        System.out.println(sc.stringCompression(t1));
        System.out.println(sc.checkForLength(t1));

        String t2 = "abcde";
        System.out.println(sc.stringCompression(t2));
    }
}
