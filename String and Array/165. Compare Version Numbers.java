/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        String[] a = deleteZero(v1);
        String[] b = deleteZero(v2);
        if(a == null && b == null) {
            return 0;
        } else if(a != null && b == null) {
            return 1;
        } else if(a == null && b != null) {
            return -1;
        }  
        int indx1 = 0;
        int indx2 = 0;
        while(indx1 < a.length && indx2 < b.length) {
            if(Integer.parseInt(a[indx1]) > Integer.parseInt(b[indx2])) {
                return 1;
            } else if(Integer.parseInt(a[indx1]) < Integer.parseInt(b[indx2])) {
                return -1;
            }
            indx1++;
            indx2++;
        }
        if(indx1 == a.length && indx2 == b.length) {
            return 0;
        }
        if(indx1 != a.length && indx2 == b.length) {
            return 1;
        } else if(indx1 == a.length && indx2 != b.length) {
            return -1;
        }
        return 0;
    }
    public String[] deleteZero(String[] tmp) {
        int i = tmp.length - 1;
        while(i >= 0 && Integer.parseInt(tmp[i]) == 0) {//小心00这样的情况，所以用parse
            i--;
        }
        if(i == -1) {//整个都是0，像0.0.0
            return null;
        }
        String[] ans = new String[i + 1];
        for(int j = 0; j <= i; j++) {
            ans[j] = tmp[j];
        }
        return ans;
    }
}