public class Recursion {
    
    // skip 'a' from string and return new string 
    public static void skipChar(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            skipChar(p, up.substring(1));            
        } else {
            skipChar(p + ch, up.substring(1));
        }
    }

    // print subsets of String
    public static void subSeq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSeq(p + ch, up.substring(1));
        subSeq(p, up.substring(1)); 
    }

    // maze problem - count no. of paths to reach a point
    public static int countPath(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = countPath(r-1, c);
        int right = countPath(r, c-1);
        return left + right;
    }

    // maze problem - print paths to reach a point
    public static void printPath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            printPath(p + 'D', r-1, c);
        } 
        if (c > 1) {
            printPath(p + 'R', r, c-1);
        }
    }

    public static void main(String[] args) {
        skipChar("", "cbdad"); 
        subSeq("", "abc");  
        System.out.println(countPath(3, 3)); 
        printPath("", 3, 3);
    }    
}
