package Array_and_String;

public class Urlify {
    public char[] urlify(char[] s, int length) {
        int nlength = 0, spaces = 0;
        for(char c : s) {
            if(c == ' ') spaces++;
        }
        nlength = length + 2 * spaces;
        s[nlength] = '\0';
        for(int i=length-1; i>=0; i--) {
            if(s[i] == ' ') {
                s[nlength - 1] = '0';
                s[nlength - 2] = '2';
                s[nlength - 3] = '%';
                nlength -= 3;
            }
            else {
                s[nlength - 1] = s[i];
                nlength -= 1;
            }
        }
        return s;
    }
}
