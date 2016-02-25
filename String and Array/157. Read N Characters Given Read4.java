/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int tmp = read4(buffer);
        int ans = 0;
        boolean flag = false;
        while(tmp == 4) {
            if(ans + 4 > n) {
                flag = true;
                break;
            }
            System.arraycopy(buffer, 0, buf, ans, 4);
            ans += 4;
            tmp = read4(buffer);
        }
        if(flag || ans + tmp > n) {//1. 可以读取四个，但是再加上之后就超过n了。2. 不能读四个了，最后剩的只有小于四个了，但是加上之后还是会超n
            System.arraycopy(buffer, 0, buf, ans, n - ans);
            ans += n - ans;
        } else {//不能读四个了，最后剩的只有小于四个了，加上之后也不会超n
            System.arraycopy(buffer, 0, buf, ans, tmp);
            ans += tmp;
        }
        return ans;
    }
}